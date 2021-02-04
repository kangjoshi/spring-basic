package com.example.springbasic.beanfind;

import com.example.springbasic.AppConfig;
import com.example.springbasic.member.MemberService;
import com.example.springbasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 실패")
    void findBeanByNameFail() {
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class, ()-> applicationContext.getBean("wrongService", MemberService.class));
    }

    @Test
    @DisplayName("빈 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = applicationContext.getBean(MemberService.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    /*
    * 구현체를 직접 의존해서 테스트 하는건 좋지 않을 수 있다.
    * */
    @Test
    @DisplayName("구현테 타입으로 조회")
    void findBeanByType2() {
        MemberService memberService = applicationContext.getBean(MemberServiceImpl.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

}
