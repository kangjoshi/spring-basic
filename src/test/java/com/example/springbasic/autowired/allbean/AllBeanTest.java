package com.example.springbasic.autowired.allbean;

import com.example.springbasic.AutoAppConfig;
import com.example.springbasic.discount.DiscountPolicy;
import com.example.springbasic.discount.FixedDiscountPolicy;
import com.example.springbasic.member.Grade;
import com.example.springbasic.member.Member;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);

        DiscountService discountService = applicationContext.getBean(DiscountService.class);

        Member member1 = new Member(1L, "userA", Grade.BASIC);
        int discountPrice1 = discountService.discount(member1, 20000, member1.getGrade().getDiscountPolicyName());
        Assertions.assertThat(discountPrice1).isEqualTo(1000);

        Member member2 = new Member(1L, "userA", Grade.VIP);
        int discountPrice2 = discountService.discount(member2, 20000, member2.getGrade().getDiscountPolicyName());
        Assertions.assertThat(discountPrice2).isEqualTo(2000);

    }

    @RequiredArgsConstructor
    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        public int discount(Member member, int price, String discountPolicyName) {
            DiscountPolicy discountPolicy = policyMap.computeIfAbsent(discountPolicyName, (key) -> new FixedDiscountPolicy());

            System.out.println("member = " + member + ", price = " + price + ", discountPolicyName = " + discountPolicyName);
            System.out.println("discountPolicy = " + discountPolicy);
            return discountPolicy.discount(member, price);
        }

    }





}
