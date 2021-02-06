package com.example.springbasic.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("NetworkClient.NetworkClient");
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public void connect() {
        System.out.println("NetworkClient.connect");
        System.out.println("url = " + url);
    }

    public void call(String message) {
        System.out.println("NetworkClient.call");
        System.out.println("url = " + url);
    }

    public void disconnect() {
        System.out.println("NetworkClient.disconnect");
        System.out.println("url = " + url);
    }

    /*
    * @PostConstruct, @PreDestory
    *   최신 스프링에서 권장
    *   javax.annotation 패키지로 자바의 기술이므로 스프링에 종속적이지 않다.
    *   단점은 외부 라이브러리에는 적용하지 못한다는것. (코드를 수정할 수 없는 외부 라이브러리를 초기화, 종료해야 하면 @Bean의 initMethod, destroyMethod를 사용하자.
     * */

    @PostConstruct
    public void init() {
        // 의존관계 주입이 끝나면 호출되는 메서드
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() {
        // 빈이 종료될 때 호출되는 메서드
        disconnect();
    }

    /*
    public void init() {
        // 의존관계 주입이 끝나면 호출되는 메서드
        // 메서드 이름은 지정할 수 있고 스프링 코드에 의존하지 않는다.
        // 코드가 아닌 설정 정보를 사용하기 때문에 코드를 고칠 수 없는 외부 라이브러리에도 초기화 종료 메서드 적용 가능
        connect();
        call("초기화 연결 메세지");
    }

    public void close() {
        // 빈이 종료될 때 호출되는 메서드
        // 메서드 이름은 지정할 수 있고 스프링 코드에 의존하지 않는다.
        // 코드가 아닌 설정 정보를 사용하기 때문에 코드를 고칠 수 없는 외부 라이브러리에도 초기화 종료 메서드 적용 가능
        disconnect();
    }
    */

    /*
    @Override
    public void afterPropertiesSet() throws Exception {
        // 의존관계 주입이 끝나면 호출되는 메서드
        // 스프링 전용 인터페이스이므로 스프링에 의존
        connect();
        call("초기화 연결 메세지");
    }

    @Override
    public void destroy() throws Exception {
        // 빈이 종료될 때 호출되는 메서드
        // 스프링 전용 인터페이스이므로 스프링에 의존
        disconnect();
    }
     */
}
