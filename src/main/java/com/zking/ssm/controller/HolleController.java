package com.zking.ssm.controller;

import com.zking.ssm.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class HolleController {

    @RequestMapping(value = "/holle",method = RequestMethod.GET)
    public String holle(){
        System.out.println("进来了---6666666666666666666666666666");

        return  "a";
    }

    @RequestMapping(value = "/add")
    public String add(Book book,@RequestParam("strName") String str){
        System.out.println(book);
        System.out.println("str:"+str);
        return null;
    }

}
