package com.example.springbasic.scan;

import com.example.springbasic.member.MemberService;
import com.example.springbasic.AutoAppConfig;
import com.example.springbasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AutoAppConfigTest {

    /*
    * @Autowired : 동일한 타입을 찾고 타입 매칭이 중복된다면 이름을 비교하여 주입한다.
    * @Qualifier : 추가 구분자를 지정한다. @Qualifier로 추가 구분자를 지정하면 @Qualifier로 동일한 구분자를 가진 스프링빈을 찾는다.
    * @Primary : 빈의 우선순위를 지정한다.
    *
    * */

    @Test
    void basicScan() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = applicationContext.getBean(MemberService.class);

        System.out.println("memberService : " + memberService);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
}
