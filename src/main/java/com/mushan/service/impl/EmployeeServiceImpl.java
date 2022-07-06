package com.mushan.service.impl;

/**
 * @author MuShan
 * @version 1.0
 * @date 2022/3/27 19:25
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mushan.entity.Employee;
import com.mushan.mapper.DepartmentMapper;
import com.mushan.mapper.EmployeeMapper;
import com.mushan.service.EmployeeService;
import com.mushan.utils.exception.BussinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("employeeService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Override
    public PageInfo<Employee> selectEmployee(Integer page, Integer pageSize, Integer dId, String search) {
        PageHelper.startPage(page, pageSize);
        List<Employee> employees = employeeMapper.selectEmployee(dId, search);

        employees.forEach(emp -> emp.setDepartment(departmentMapper.selectByIdDepartment(emp.getdId())));

        return new PageInfo<>(employees);
    }

    @Override
    public Employee selectByIdEmployee(Integer id) {
        return employeeMapper.selectByIdEmployee(id);
    }

    @Override
    @Transactional
    public int insertEmployee(Employee employee) {
        int i;
        try {
            i = employeeMapper.insertEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BussinessException("新增失败！");
        }
        return i;
    }

    @Override
    @Transactional
    public int deleteEmployee(Integer id) {
        int i;
        try {
            i = employeeMapper.deleteEmployee(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BussinessException("删除失败！");
        }
        return i;
    }

    @Override
    @Transactional
    public int updateEmployee(Employee employee) {
        int i = 0;
        try {
            i = employeeMapper.updateEmployee(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    @Transactional
    public void batchDeleteEmployee(String ids) {
        String[] str = ids.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s : str) {
            list.add(Integer.parseInt(s));
        }
        System.out.println(list);
        employeeMapper.batchDeleteEmployee(list);
    }
}
