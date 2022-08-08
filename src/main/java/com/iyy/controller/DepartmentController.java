package com.iyy.controller;

/**
 * @author xuhualongßßß
 * @version 1.0
 * @date 2022/3/28 16:39
 */

import com.alibaba.fastjson.JSON;
import com.iyy.entity.Department;
import com.iyy.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;

    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> getDepartmentList() {
        Map<String, Object> map = new HashMap<>();
        List<Department> departmentList = null;
        try{
            departmentList = departmentService.getDepartmentList();
        }catch (Exception e){
            e.printStackTrace();
        }

        map.put("code", "0");
        map.put("msg", "success");
        map.put("data", departmentList);
        return map;
    }
    @PostMapping("/login")
    public Map<String, Object> loginIn(Long number) {
        System.out.println(JSON.toJSONString(number));
        Map<String, Object> map = new HashMap<>();


        map.put("code", "0");
        map.put("msg", "success");
        return map;
    }

}
