package com.adolph.controller;

import com.adolph.pojo.Resource;
import com.adolph.pojo.ResponseJsonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author MaJuntao
 */
@RestController
public class HelloController {

    @Autowired
    private Resource resource;

    @RequestMapping(value = "/hello")
    public Object hello() {
        return "Hello springboot!!";
    }

    @RequestMapping(value = "/getResource")
    public ResponseJsonResult getResource() {
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource,bean);
        System.out.println(bean);
        return ResponseJsonResult.ok(bean);
    }
}
