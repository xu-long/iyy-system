package com.mushan.mapper;

/**
 * @author MuShan
 * @version 1.0
 * @date 2022/3/27 18:21
 */

import com.mushan.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工Mapper接口
 */
public interface EmployeeMapper {

    /**
     * 查询所有员工
     * @return
     */
    public List<Employee> selectEmployee(@Param("dId") Integer dId, @Param("search") String search);

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    public Employee selectByIdEmployee(Integer id);

    /**
     * 添加员工
     * @param employee
     * @return
     */
    public int insertEmployee(Employee employee);

    /**
     * 删除员工
     * @param id
     * @return
     */
    public int deleteEmployee(Integer id);

    /**
     * 修改员工
     * @param employee
     * @return
     */
    public int updateEmployee(Employee employee);

    /**
     * 批量删除员工
     * @param ids 员工id列表
     */
    public void batchDeleteEmployee(List<Integer> ids);
}
