package com.iyy.command;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/20 10:21 下午
 */
@Data
public class QueryUserMenuCommand implements Serializable {

    @NotNull(message = "用户ID不能为空！")
    private Integer userId;
}
