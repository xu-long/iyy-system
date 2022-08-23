package com.iyy.controller;

import com.github.pagehelper.PageInfo;
import com.iyy.constant.StatusConstant;
import com.iyy.service.HandoverReceiverService;
import com.iyy.utils.tools.ValidationUtil;
import com.iyy.vo.HandoverReceiverInfo;
import com.iyy.command.QueryUserHandoverReceiverInfoCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 交接记录controller
 * @author xuhualong
 * @version 1.0
 * @since 2022/8/16 11:01 上午
 */

@RestController
@RequestMapping("/handoverReceiver")
@Slf4j
public class HandoverReceiverController {
    @Resource
    private HandoverReceiverService handoverReceiverService;

    @GetMapping("/queryUserHandoverReceiverInfo")
    @ResponseBody
    public Map<String, Object> queryUserHandoverReceiverInfo(QueryUserHandoverReceiverInfoCommand command){
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        ValidationUtil.validateBean(command);
        try{
            PageInfo<HandoverReceiverInfo> handoverReceiverInfoPageInfo = handoverReceiverService.queryUserHandoverReceiverInfo(command.getUserId(), command.getPageNum(), command.getPageSize());
            response.put("result", handoverReceiverInfoPageInfo);
            response.put("code", StatusConstant.successCode);
        }catch (Exception e){
            e.printStackTrace();
            response.put("code", StatusConstant.failCode);
            response.put("message", e.getMessage());
        }
        return response;
    }
}
