package com.study.springcorebasic;

import com.study.springcorebasic.member.Grade;
import com.study.springcorebasic.member.Member;
import com.study.springcorebasic.member.MemberService;
import com.study.springcorebasic.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
    }
}
