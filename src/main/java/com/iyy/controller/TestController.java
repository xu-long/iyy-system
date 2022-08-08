package com.iyy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/8 5:14 下午
 */
@RestController
@RequestMapping(value ="/test")
public class TestController {

    @GetMapping(value = "/testOne")
    @ResponseBody
    public Map<String, Object> testOne() {
        Map<String, Object> map = new HashMap<>();


        map.put("code", "0");
        map.put("msg", "success");
        map.put("data", "");
        return map;
    }
}
