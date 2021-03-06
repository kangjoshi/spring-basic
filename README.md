## 1. 객체 지향 설계와 스프링
##### 객체 지향 프로그래밍
프로그래밍을 명령어의 목록에서 보는 시각에서 벗어나 여러개의 독립된 객체들의 모임으로 파악하고자 하는 것.
각각의 객체는 메시지를 주고받고 협력하며 데이터를 처리할 수 있다.

##### 역할과 구현을 분리
역할과 구현으로 구분하면 유연해지고 변경도 편리해진다.
클라이언트는 대상의 역할만 알면 되므로 구현 대상 자체의 구조, 변경에 영향을 받지 않는다.

자바에서는 다형성을 활용하여 역할과 구현을 분리한다. 객체 설계시 역할(인터페이스)를 먼저 부여하고, 그 역할을 수행하는 구현 객체를 만든다.  
역할 = 인터페이스  
구현 = 인터페이스를 구현한 클래스
 
##### 좋은 객체 지향 설계의 5가지 원칙 (SOLID)
1. 단일 책임 원칙
    - 한 클래스는 하나의 책임만 가져야한다.
    - 기준은 변경이다. 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른것이다. (주문시 할인 정책을 변경할 때 할인 정책을 담당하는 클래스에서만 변경이 일어나야 한다. 주문을 담당하는 클래스에서 많은 변경이 있다면 책임 분리가 되지 않은것)
2. 개방-폐쇄 원칙
    - 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.
    - 다형성과 DI를 이용하여 개방-폐쇄 원칙을 준수하는 코드를 작성할 수 있다.
3. 리스코프 치환 원칙
    - 다형성을 지원하기 위한 원칙으로 다형성을 이용하여 구현체를 믿고 사용하려면 구현체는 인터페이스 규약을 다 지켜야한다.
    - 자동차 인터페이스에서 엑셀 메서드를 하위 함수에서 클락션 기능으로 구현했다면 리스코프 치환 원칙을 위반한 것.
4. 인터페이스 분리 원칙
    - 하나의 큰 인터페이스보다 각각의 책임을 가진 인터페이스로 분리하면 인터페이스가 명확해지고 대체 가능성이 높아진다.
5. 의존관계 역전 원칙
    - 다형성을 이용하여 인터페이스에 의존해야지 구현체에 의존하면 안 된다.

## 2. 스프링 핵심 원리 이해
##### 제어의 역전와 의존 관계 주입
기존 프로그램은 클라이언트 구현 객체가 스스로 필요한 객체를 생성하고 실행했다. 
한마디로 구현 객체가 프로그램의 제어 흐름을 스스로 제어했다.  
사용 영역과 구성 영역을 분리함으로 구성 영역에서 사용 영역에서 필요한 객체를 관리하며 사용 영역에서 필요한 객체를 주입(의존 관계 주입)하고 사용 영역는 어느 구현체가 사용될지 모른채 자신의 로직을 실행한다.
이렇듯 프로그램의 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것을 제어의 역전이라고 한다.

## 3. 스프링 컨테이너와 스프링 빈
ApplicationContext를 스프링 컨테이너라 한다. 스프링 컨테이너는 XML, 애노테이션 기반등의 자바 설정 클래스로 만들 수 있다.
스프링 컨테이너가 관리하는 객체를 스프링 빈이라고 부른다. 기본적으로 싱글톤 객체로 생성된다. 

## 4. 싱글톤 컨테이너
##### 싱글톤 패턴
클래스의 인스턴스가 1개만 생성되는 것을 보장하는 디자인 패턴이다. 요청이 올 때 마다 객체를 생성하는 것이 아니라, 이미 만들어진 객체를 공유하므로 효율적으로 사용할 수 있다.
하지만 싱글톤 패턴은 사용시 주의해야 될 점과 많은 문제점도 가지고 있다.

스프링 컨테이너는 싱글톤 패턴의 문제점을 해결하면서, 스프링 빈을 싱글톤으로 관리한다.

## 5. 컴포넌스 스캔
@ComponentScan 애노테이션은 @Component가 붙은 모든 클래스를 스프링 빈으로 등록한다. 빈의 기본 이름은 클래스명을 사용하되 맨 앞글자만 소문자를 사용한다.
탐색하지 않을 타입을 지정하거나 탐색 시작 패키지의 위치를 지정할 수 있다. 기본값으로는 @ComponentScan가 붙은 설정 정보 클래스의 패키지가 시작 위치가 된다.

## 6. 의존관계 자동 주입
의존관계 주입은 크게 4가지 방법이 있지만 권장하는 방법은 생성자를 통한 주입, 수정자를 통한 주입이다.
생성자를 통한 주입은 불변, 필수 의존관계에서 사용하고 수정자를 통한 주입은 가변, 선택 의존관계에서 사용한다.

@Autowired는 타입 매칭을 시도하고 여러 빈이 있다면 필드 또는 파라미터의 이름으로 추가 매칭한다.
@Qualifier를 사용하여 Qualifier끼리 매칭하는 방법과 @Primary 애노테이션을 사용하여 동일한 타입이 검색 되었을때 우선 주입이 되어야할 빈을 선택할 수 있다.


## 7. 빈 생명주기 콜백
스프링 빈의 라이프사이클은
객체 생성 -> 의존 관계 주입 -> 초기화 콜백 -> 사용 -> 소멸전 콜백 -> 스프링 종료의 순서를 가진다.

초기화 콜백은 빈이 생성되고, 빈의 의존 관계 주입이 완료된 후 호출된다.  
소멸전 콜백은 빈이 소멸되기 직전에 호출

스프링은 다양한 방식으로 생명 주기 콜백을 지원하지만 메서드에 자바 표준인 @PostConstruct(초기화 콜백), @PreDestory(소멸전 콜백)을 사용하는 것을 권장한다.

## 8. 빈 스코프
- 싱글톤 : 기본 스코프, 스프링 컨테이너의 시작과 종료까지 유지되는 가장 넒은 범위의 스코프, 요청시 컨테이너에서 관리되는 스프링 빈을 반환하므로 같은 객체 인스턴스의 스프링빈을 반환한다.
- 프로토타입 : 빈의 생성과 의존 관계 주입까지만 관여하고 더는 관리하지 않는 짧은 범위의 스코프, 요청시 컨테이너는 프로토탑의 빈을 생성하고, 필요한 의존관계만 주입하고 반환한다. 반환된 빈은 관리되지 않는다.(관리되지 않는 빈이므로 @PreDestory와 같은 종료 메서드를 지정해도 호출되지 않는다.)
- 웹 관련 스코프 : 웹 환경에서만 동작한다.
    - request : 웹 요청이 들어오고 나갈때 까지의 유지되는 스코프, 각각의 HTTP 요청마다 별도의 빈 인스턴스가 생성되고 관리된다.
    - session : 웹 세션이 생성되고 종료될 때 까지 유지되는 스코프, Http Session과 동일한 생명주기를 가진다.
    - application : 웹의 서블릿 컨텍스트와 같은 범위로 유지되는 스코프
    
    
##### Reference
스프링 핵심 원리 - 기본편_김영한_인프런 강의
    
    