package com.iyy.command;

import cn.hutool.core.util.ObjectUtil;

import java.io.Serializable;

/**
 * 默认入参
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/16 2:45 下午
 */
public class BaseCommand implements Serializable {

    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 每页条数
     */
    private Integer pageSize;

    public Integer getPageNum() {
        if(ObjectUtil.isEmpty(pageNum)){
            return 1;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNum = pageNo;
    }

    public Integer getPageSize() {
        if(ObjectUtil.isEmpty(pageSize)){
            return 10;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
