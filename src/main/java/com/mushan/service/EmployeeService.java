package com.mushan.service;

/**
 * @author MuShan
 * @version 1.0
 * @date 2022/3/27 19:24
 */

import com.github.pagehelper.PageInfo;
import com.mushan.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public PageInfo<Employee> selectEmployee(Integer page, Integer pageSize, Integer dId, String search);

    public Employee selectByIdEmployee(Integer id);

    public int insertEmployee(Employee employee);

    public int deleteEmployee(Integer id);

    public int updateEmployee(Employee employee);

    public void batchDeleteEmployee(String ids);

}
