package com.fuengp.spring_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class MyController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "success!" ;
    }
    @RequestMapping("/")
    public String index(){
        return "index" ;
    }

    /**
     * 如果不在application.properties文件中设置（spring.mvc.date-format=yyyy-MM-dd HH:mm:ss）日期格式化会报错
     * @param date
     * @return
     */
    @RequestMapping("/outDate")
    @ResponseBody
    public Date outDate(Date date){
        return date;
    }
}
