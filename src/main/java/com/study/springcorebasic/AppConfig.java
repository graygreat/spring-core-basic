package com.study.springcorebasic;

import com.study.springcorebasic.discount.RateDiscountPolicy;
import com.study.springcorebasic.member.MemberService;
import com.study.springcorebasic.member.MemberServiceImpl;
import com.study.springcorebasic.member.MemoryMemberRepository;
import com.study.springcorebasic.order.OrderService;
import com.study.springcorebasic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private RateDiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}