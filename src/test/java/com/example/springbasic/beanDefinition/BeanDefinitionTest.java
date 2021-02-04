package com.example.springbasic.beanDefinition;

import com.example.springbasic.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
* BeanDefinition 정보
*   BeanClassName : 생성할 빈의 클래스명
*   factoryBeanName : 팩토리 역할의 빈을 사용할 경우 이름
*   factoryMethodName : 빈을 생성할 팩토리 메서드 지정
*   Scope : 기본 싱글톤
*   LazyInit : 스프링 컨터이너를 생성할 때 빈을 생성하는 것이 아니라 실제 빈을 사용할 때 까지 생성을 지연
*   initMethodName : 빈을 생성하고 의존 관계를 적용한 뒤 호출되는 초기화 메서드 명
*   DestroyMethodName : 빈의 생명주기가 끝나서 제거하기 직전에 호출되는 메서드 명
*   Constructor arguments, Properties : 의존 관계 주입에서 사용
*
* 메타 정보 기반으로 빈을 생성한다.
*
* */

public class BeanDefinitionTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName + " beanDefinition = " + beanDefinition);
            }

        }
    }

}
