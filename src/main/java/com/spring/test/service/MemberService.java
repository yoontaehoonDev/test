package com.spring.test.service;

import com.spring.test.domain.Member;
import com.spring.test.repository.MemberRepository;
import com.spring.test.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

  private final MemberRepository memberRepository;

  @Autowired
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public Long join(Member member) {
    long start = System.currentTimeMillis();
    try {
      validateDuplicateMember(member);

      memberRepository.save(member);
      return member.getId();
    }
    finally {
      long finish = System.currentTimeMillis();
      long timeMs = finish - start;
      System.out.printf("join = %d ms\n", timeMs);
    }
  }

  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName())
            .ifPresent(m -> {throw new IllegalStateException("이미 존재하는 회원입니다.");});
  }

   public List<Member> findMembers() {
     long start = System.currentTimeMillis();
     try {
       return memberRepository.findAll();
     }
     finally {
       long finish = System.currentTimeMillis();
       long timeMs = finish - start;
       System.out.printf("join = %d ms\n", timeMs);
     }
     }

   public Optional<Member> findOne(Long memberId) {
    return memberRepository.findById(memberId);
   }
}
