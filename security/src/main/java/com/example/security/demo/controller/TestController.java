package com.example.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@RequestMapping 映射为动态生成网页 需要Thymeleaf

@RequestMapping
@Controller
public class TestController {

    @GetMapping("/hello")
    public ModelAndView hello(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","游客");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
    @GetMapping("/admin/hello")
    public ModelAndView ahello(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","管理员");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
    @GetMapping("/dba/hello")
    public ModelAndView dbahello(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","数据库管理员");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
    @GetMapping("/user/hello")
    public ModelAndView uhello(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("name","用户");
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
