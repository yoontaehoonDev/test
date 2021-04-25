package com.spring.test;

import com.spring.test.repository.JdbcMemberRepository;
import com.spring.test.repository.JdbcTemplateMemberRepository;
import com.spring.test.repository.JpaMemberRepository;
import com.spring.test.repository.MemberRepository;
import com.spring.test.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureParameter;
import javax.sql.DataSource;
import java.lang.invoke.StringConcatException;

@Configuration
public class SpringConfig {

  private final MemberRepository memberRepository;

  @Autowired
  public SpringConfig(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository);
  }

//  @Bean
//  public MemberRepository memberRepository()
//  {
// return new MemoryMemberRepository();
// return new JdbcMemberRepository(dataSource);
// return new JdbcTemplateMemberRepository(dataSource);
//    return new JpaMemberRepository(em);
//
//  }
}