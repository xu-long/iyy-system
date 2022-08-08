package com.iyy.controller;

/**
 * @author MuShan
 * @version 1.0
 * @date 2022/3/27 16:41
 */

import com.github.pagehelper.PageInfo;
import com.iyy.entity.Employee;
import com.iyy.service.EmployeeService;
import com.iyy.utils.exception.BussinessException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/*
 * 员工
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    /**
     * 查询员工
     * @param page 当前页
     * @param limit 一页记录数
     * @param dId 部门id
     * @param search 搜索内容
     * @return json数据
     */
    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> showIndex(Integer page, Integer limit, Integer dId, String search) {
        Map<String, Object> map = new HashMap<>();
        if (page == null || page < 1) {
            page = 1;
        }
        if (limit == null || limit < 1) {
            limit = 10;
        }
        PageInfo<Employee> pageInfo = employeeService.selectEmployee(page, limit, dId, search);
        map.put("code", "0");
        map.put("msg", "success");
        map.put("count", pageInfo.getTotal());
        map.put("pageSize", pageInfo.getPages());
        map.put("data", pageInfo.getList());
        return map;
    }

    /**
     * 新增员工
     * @param employee 员工对象
     * @return json数据
     */
    @PostMapping("/insert")
    public Map<String, Object> insert(Employee employee) {
        System.out.println(employee);
        Map<String, Object> map = new HashMap<>();
        try {
            int i = employeeService.insertEmployee(employee);
            if (i == 0) {
                map.put("code", "1");
                map.put("msg", "新增失败！");
            }else {
                map.put("code", "0");
                map.put("msg", "新增成功！");
            }
        } catch (BussinessException e) {
            map.put("code", "1");
            map.put("msg", e.getMsg());
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 删除指定员工
     * @param id 员工id
     * @return json数据
     */
    @PostMapping("/delete")
    public Map<String, Object> delete(Integer id) {
        Map<String, Object> map = new HashMap<>();
        try {
            int i = employeeService.deleteEmployee(id);
            if (i == 0) {
                map.put("code", "1");
                map.put("msg", "删除失败！");
            }else {
                map.put("code", "0");
                map.put("msg", "删除成功！");
            }
        } catch (BussinessException e) {
            map.put("code", "1");
            map.put("msg", e.getMsg());
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 修改员工 员工对象
     * @param employee 员工对象
     * @return json数据
     */
    @PostMapping("/update")
    @ResponseBody
    public Map<String, Object> updateEmployee(Employee employee) {
        Map<String, Object> map = new HashMap<>();
        try {
            int i = employeeService.updateEmployee(employee);
            if (i == 0) {
                map.put("code", "1");
                map.put("msg", "修改失败！");
            }else {
                map.put("code", "0");
                map.put("msg", "修改成功！");
            }
        } catch (BussinessException e) {
            map.put("code", "1");
            map.put("msg", e.getMsg());
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 批量删除员工
     * @param ids 员工id列表
     * @return json数据
     */
    @PostMapping("/batch_delete")
    @ResponseBody
    public Map<String, Object> batchDelete(String ids) {
        Map<String, Object> map = new HashMap<>();
        try {
            employeeService.batchDeleteEmployee(ids);
            map.put("code", "0");
            map.put("msg", "删除成功！");
        } catch (Exception e) {
            map.put("code", "1");
            map.put("msg", "删除失败！");
            e.printStackTrace();
        }
        return map;
    }
}
