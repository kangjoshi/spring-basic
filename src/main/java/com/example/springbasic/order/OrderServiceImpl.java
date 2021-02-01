package com.example.springbasic.order;

import com.example.springbasic.discount.DiscountPolicy;
import com.example.springbasic.discount.FixedDiscountPolicy;
import com.example.springbasic.discount.RateDiscountPolicy;
import com.example.springbasic.member.Member;
import com.example.springbasic.member.MemberRepository;
import com.example.springbasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;

    /*
    * 역할과 책임은 분리 되었지만 DiscountPolicy는 구현체도 의존하고 있다.
    * */
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    /*
    * 생성자를 통한 DI로 구현체를 주입하여 구현체는 위존하지 않도록 설계 변경
    * */
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findId(memberId);
        int disCountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, disCountPrice);
    }
}
