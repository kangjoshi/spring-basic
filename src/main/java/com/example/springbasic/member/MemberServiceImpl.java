package com.example.springbasic.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;


    // @Autowired(required = false) required 기본 값은 true이므로 자동 주입 대상이 없다면 오류가 발생한다.
    @Autowired // 의존 관계를 자동으로 주입해준다. 기본 조회 전략은 동일한 타입을 찾는다. 생성자가 하나라면 @Autowired는 생략되어도 된다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findId(memberId);
    }
}
