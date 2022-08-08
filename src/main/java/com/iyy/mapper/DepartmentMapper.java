package com.iyy.mapper;

/**
 * @author MuShan
 * @version 1.0
 * @date 2022/3/28 15:49
 */

import com.iyy.entity.Department;

import java.util.List;

/**
 * 部门Mapper接口
 */
public interface DepartmentMapper {

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    public Department selectByIdDepartment(Integer id);

    /**
     * 查询所有部门
     * @return
     */
    public List<Department> getDepartmentList();

}
