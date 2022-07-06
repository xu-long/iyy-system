package com.mushan.service.impl;

/**
 * @author MuShan
 * @version 1.0
 * @date 2022/3/28 15:56
 */

import com.mushan.entity.Department;
import com.mushan.entity.Employee;
import com.mushan.mapper.DepartmentMapper;
import com.mushan.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("departmentService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;
    @Override
    public Department selectByIdDepartment(Integer id) {
        return departmentMapper.selectByIdDepartment(id);
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentMapper.getDepartmentList();
    }
}
