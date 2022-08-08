package com.iyy.service;

/**
 * @author MuShan
 * @version 1.0
 * @date 2022/3/28 15:55
 */

import com.iyy.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department selectByIdDepartment(Integer id);

    public List<Department> getDepartmentList();
}
