package com.shoubei.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String say(){
        return "Hello Spring Boot！";
    }

    @RequestMapping(value = "test")
    public Map<String, String> user() {

        Map<String, String> user = new HashMap<String, String>();

        user.put("name", "zhengzx");
        user.put("level", "黄金会员");
        return user;
    }
}
