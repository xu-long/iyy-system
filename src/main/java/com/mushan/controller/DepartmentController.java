package com.mushan.controller;

/**
 * @author xuhualongßßß
 * @version 1.0
 * @date 2022/3/28 16:39
 */

import com.mushan.entity.Department;
import com.mushan.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
        List<Department> departmentList = departmentService.getDepartmentList();
        map.put("code", "0");
        map.put("msg", "success");
        map.put("data", departmentList);
        return map;
    }

}
