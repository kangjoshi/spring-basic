package com.example.springbasic.autowired;

import com.example.springbasic.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void  AutowiredTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {

        @Autowired(required = false)    // 의존 관계가 없다면 호출 자체가 안된다.
        public void setNoBean1(Member member) {
            System.out.println("TestBean.setNoBean1");
            System.out.println("member = " + member);
        }

        @Autowired  // null로 들어온다.
        public void setNoBean2(@Nullable Member member) {
            System.out.println("TestBean.setNo Bean2");
            System.out.println("member = " + member);
        }

        @Autowired  // Optional.empty로 들어온다.
        public void setNoBean3(Optional<Member> member) {
            System.out.println("TestBean.setNoBean3");
            System.out.println("member = " + member);
        }

    }

}
