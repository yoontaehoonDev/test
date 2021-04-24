package com.spring.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  @GetMapping("hello")
  public String hello(Model model) {
    model.addAttribute("data", "hello!!!!");

    return "hello";
  }

  @GetMapping("hello-mvc")
  public String helloMvc(@RequestParam("name") String name, Model model) {
    model.addAttribute("name", name);

    return "hello-template";
  }

  @GetMapping("hello-string")
  @ResponseBody
  public String helloString(@RequestParam("name") String name) {
    return "few " + name;
  }

  @GetMapping("hello-api")
  @ResponseBody
  public Hello helloApi(@RequestParam("name") String name, @RequestParam("number") int number) {
    Hello hello = new Hello();
    hello.setName(name);
    hello.setNumber(number);

    return hello;
  }

  static class Hello {
    private int number;
    private String name;

    public void setNumber(int number) {
      this.number = number;
    }

    public int getNumber() {
      return number;
    }

    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
  }
}
