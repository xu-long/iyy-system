package com.iyy.command;

import com.iyy.command.BaseCommand;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/16 2:38 下午
 */
@Data
public class QueryUserHandoverReceiverInfoCommand extends BaseCommand implements Serializable {
    /**
     * 用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Integer userId;
}
