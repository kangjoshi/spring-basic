package com.example.springbasic.scan;

import com.example.springbasic.member.MemberService;
import com.example.springbasic.AutoAppConfig;
import com.example.springbasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = applicationContext.getBean(MemberService.class);

        System.out.println("memberService : " + memberService);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
}
