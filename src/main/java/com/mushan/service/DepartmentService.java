package com.mushan.service;

/**
 * @author MuShan
 * @version 1.0
 * @date 2022/3/28 15:55
 */

import com.mushan.entity.Department;
import com.mushan.entity.Employee;

import java.util.List;

public interface DepartmentService {
    public Department selectByIdDepartment(Integer id);

    public List<Department> getDepartmentList();
}
