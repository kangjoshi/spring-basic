package com.example.springbasic.member;

public enum Grade {
    BASIC("fixedDiscountPolicy"),
    VIP("rateDiscountPolicy");

    private String discountPolicyName;

    Grade(String discountPolicyName) {
        this.discountPolicyName = discountPolicyName;
    }

    public String getDiscountPolicyName() {
        return discountPolicyName;
    }
}
