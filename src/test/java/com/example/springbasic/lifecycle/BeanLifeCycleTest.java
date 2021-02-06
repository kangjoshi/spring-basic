package com.example.springbasic.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* 스프링 빈의 이벤트 라이프 사이클
*   컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 -> 사용 -> 소멸전 콜백 -> 스프링 종료
*   초기화 콜백 : 빈이 생성되고 빈의 의존관계 주입이 완료된 후 호출
*   소멸전 콜백 : 빈이 소멸되지 직전에 호출
*
* 객체의 생성과 초기화의 분리
*   생성자는 필수 파라미터를 받고 메모리를 할당해서 객체를 생성하는 책임을 가진다.
*   따라서 생성자 안에서 무거운 초기화 작업을 함께 하는 것 보다는 객체를 생성하는 부분과 초기화 하는 부분을 명확하게 나누는 것 이 유지보수 관점에서 유리하다.
*   물론 초기화 작업이 내부 값들만 약간 변경하는 정도의 간단한 경우에는 생성자에서 한번에 다 처리하는게 나을 수 있다.
* */
public class BeanLifeCycleTest {

    @Test
    void lifeCycleTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient networkClient = applicationContext.getBean(NetworkClient.class);

        applicationContext.close();
    }

    @Configuration
    static class LifeCycleConfig {

        //@Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkClient networkClient() {

            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello.spring");
            return networkClient;
        }
    }
}
