package com.spring.test.domain;

import javax.persistence.*;

@Entity
public class Member {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  public void setName(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Long getId() {
    return id;
  }
}

