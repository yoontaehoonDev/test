package com.spring.test.service;

import com.spring.test.domain.Member;
import com.spring.test.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class MemberServiceTest {

  MemberService memberService;
  MemoryMemberRepository memberRepository;

  @BeforeEach
  public void beforeEach() {
    memberRepository = new MemoryMemberRepository();
    memberService = new MemberService(memberRepository);
  }

  @AfterEach
  public void afterEach() {
    memberRepository.clearStore();
  }

  @Test
  void register() {
    //given
    Member member = new Member();
    member.setName("hello");

    //when
    Long saveId = memberService.join(member);

    //then
    Member findMember = memberService.findOne(saveId).get();
    Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
  }

  @Test
  public void 중복회원예외() {
    //given
    Member member = new Member();
    member.setName("spring");

    Member member2 = new Member();
    member2.setName("spring");

    //when
    memberService.join(member);
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

    Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//    try {
//      memberService.join(member2);
//      fail();
//    }
//    catch (IllegalStateException e) {
//      Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//    }

    //then
  }

  @Test
  void findMembers() {

  }

  @Test
  void findOne() {

  }

}
