package com.iyy.command;

import lombok.Data;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/5 3:17 下午
 */
@Data
public class QueryMemberInfoCommand implements Serializable {

    /**
     * 会员Id
     */
    @NotNull(message = "会员Id不能为空！")
    private Integer memberId;
}
