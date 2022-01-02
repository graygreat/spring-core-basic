package com.study.springcorebasic;

import com.study.springcorebasic.discount.RateDiscountPolicy;
import com.study.springcorebasic.member.MemberService;
import com.study.springcorebasic.member.MemberServiceImpl;
import com.study.springcorebasic.member.MemoryMemberRepository;
import com.study.springcorebasic.order.OrderService;
import com.study.springcorebasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public RateDiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}