package com.spring.test.repository;

import com.spring.test.domain.Member;
import com.spring.test.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

  MemoryMemberRepository repository = new MemoryMemberRepository();

  @AfterEach
  public void afterEach() {
    repository.clearStore();
  }

  @Test
  public void save() {
    Member member = new Member();
    member.setName("spring");

    repository.save(member);

    Member result = repository.findById(member.getId()).get();

    assertThat(member).isEqualTo(result);
  }

  @Test
  public void findByName() {
    Member member1 = new Member();
    member1.setName("spring2");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    Member result = repository.findByName("spring2").get();
    assertThat(member1).isEqualTo(result);
  }

  @Test
  public void findAll() {
    Member member = new Member();
    member.setName("spring1");
    repository.save(member);
    member.setName("Spring1");
    repository.save(member);

    List<Member> list = repository.findAll();
    assertThat(list.size()).isEqualTo(2);
  }
}
