package com.study.springcorebasic.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}