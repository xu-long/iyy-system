package com.iyy.entity;

/**
 * @author MuShan
 * @version 1.0
 * @date 2022/3/28 15:40
 */

/**
 * 部门
 */
public class Department {
    private Integer deptId;
    private String deptName;

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
