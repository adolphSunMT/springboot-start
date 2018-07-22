package com.adolph.controller;

import com.adolph.pojo.ResponseJsonResult;
import com.adolph.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * UserController
 *
 * @author MaJuntao
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public User getUser() {
        User u = new User();
        u.setName("Tom3");
        u.setAge(23);
        u.setBirthday(new Date());
        u.setPassword("tom1233");
        u.setDesc("Hello Springboot~~~");

        return u;
    }

    @RequestMapping(value = "/getUserJson")
    @ResponseBody
    public ResponseJsonResult getUserJson() {
        User u = new User();
        u.setName("Tom");
        u.setAge(23);
        u.setBirthday(new Date());
        u.setPassword("tom123");
        u.setDesc("Hello Springboot~~~");

        return ResponseJsonResult.ok(u);
    }
}
