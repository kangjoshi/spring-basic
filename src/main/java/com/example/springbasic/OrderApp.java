package com.example.springbasic;

import com.example.springbasic.member.*;
import com.example.springbasic.order.Order;
import com.example.springbasic.order.OrderService;
import com.example.springbasic.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = context.getBean("memberService", MemberService.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 9000);

        System.out.println("order : " + order);
        System.out.println("orderPrice : " + order.calculatePrice());
    }

}
