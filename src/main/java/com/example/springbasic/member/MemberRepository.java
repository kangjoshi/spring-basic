package com.example.springbasic.member;

public interface MemberRepository {

    void save(Member member);

    Member findId(Long memberId);

}
