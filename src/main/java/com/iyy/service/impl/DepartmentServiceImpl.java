package com.iyy.service.impl;

/**
 * @author MuShan
 * @version 1.0
 * @date 2022/3/28 15:56
 */

import com.iyy.entity.Department;
import com.iyy.mapper.DepartmentMapper;
import com.iyy.service.DepartmentService;
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
