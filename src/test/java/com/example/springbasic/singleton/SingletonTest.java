package com.example.springbasic.singleton;

import com.example.springbasic.AppConfig;
import com.example.springbasic.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {


    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        /*
        * 스프링 컨테이너가 기본값으로 빈을 싱글톤 빈으로 관리한다.
        * */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = applicationContext.getBean(MemberService.class);
        MemberService memberService2 = applicationContext.getBean(MemberService.class);

        System.out.println(memberService1);
        System.out.println(memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }



}
