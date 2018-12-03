package com.fuengp.spring_demo.controller;

import com.fuengp.spring_demo.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class MyController {

    @Autowired
    private Config config ;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "success!" ;
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


    //定义了method为GET请求，如果其他方式会提示405错误
    //ModelAndView 高内聚，低耦合设计（自己的事情自己做）
//    @RequestMapping(value = "/",method = RequestMethod.GET)
    @GetMapping("/") //此注解是上面注解的简写
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("date",new Date());
        return modelAndView ;
    }

    /*

    //Model对象 如果在测试的时候需要手动传入Model对象
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(Model model){
       model.addAttribute("date",new Date());
       return "index" ;
    }

    //request对象 强耦合，依赖tomcat等服务器容器，如果没有启动容器不能使用
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(WebRequest webRequest, HttpServletRequest request){
        webRequest.setAttribute("date",new Date(),1);
        request.setAttribute("date",new Date());
        return "index" ;
    }

    */

}
