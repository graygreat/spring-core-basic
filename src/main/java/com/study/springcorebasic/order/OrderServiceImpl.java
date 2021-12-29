package com.study.springcorebasic.order;

import com.study.springcorebasic.discount.DiscountPolicy;
import com.study.springcorebasic.discount.FixDiscountPolicy;
import com.study.springcorebasic.member.Member;
import com.study.springcorebasic.member.MemberRepository;
import com.study.springcorebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
