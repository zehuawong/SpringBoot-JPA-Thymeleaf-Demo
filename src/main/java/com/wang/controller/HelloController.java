package com.wang.controller;

import com.wang.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wzh-zhua on 2018/9/30.
 */
//@RestController //spring4之后新加的注解，原来返回json需要@ResponseBody配合@Controller
@Controller    //配合模板使用
public class HelloController {

    @Value("${cupSize}")
    private String cupSize; //通过注解将配置文件里面的属性注入到此

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHi() {
        return girlProperties.getCupSize();
    }

    @RequestMapping(value = {"index", "hi"}, method = RequestMethod.GET)
    public String hello() {
        return "/index";
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("/index");
        mv.addObject("title", "欢迎使用Thymeleaf");
        return mv;
    }


}
