package com.study.springcorebasic.order;

import com.study.springcorebasic.annotation.MainDiscountPolicy;
import com.study.springcorebasic.discount.DiscountPolicy;
import com.study.springcorebasic.member.Member;
import com.study.springcorebasic.member.MemberRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(
            MemberRepository memberRepository,
            @MainDiscountPolicy DiscountPolicy discountPolicy
    ) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
