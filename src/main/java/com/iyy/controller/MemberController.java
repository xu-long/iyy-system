package com.iyy.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageInfo;
import com.iyy.command.QueryMemberInfoCommand;
import com.iyy.command.QueryMemberListCommand;
import com.iyy.command.SaveMemberCommand;
import com.iyy.command.UpdateMemberCommand;
import com.iyy.constant.StatusConstant;
import com.iyy.entity.Member;
import com.iyy.service.MemberService;
import com.iyy.service.params.QueryMemberListParams;
import com.iyy.service.params.SaveMemberParams;
import com.iyy.service.params.UpdateMemberParams;
import com.iyy.utils.tools.ValidationUtil;
import com.iyy.vo.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 会员controller
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/4 2:50 下午
 */
@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {
    @Resource
    private MemberService memberService;

    /**
     * 查询会员信息集合
     * @param queryMemberListCommand
     * @return
     */
    @GetMapping("/queyrMemberList")
    public Map<String, Object> queyrMemberList(QueryMemberListCommand queryMemberListCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            List<Member> memberList =  memberService.queyrMemberList(queryMemberListCommand.getMemberNickname(), queryMemberListCommand.getMobileNumber());
            map.put("code", StatusConstant.successCode);
            map.put("message", "查询成功！");
            map.put("result", memberList);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "查询失败！" + e.getMessage());
        }
        return map;
    }

    /**
     * 查询会员信息集合
     * @param queryMemberListCommand
     * @return
     */
    @GetMapping("/queyrMemberListPage")
    public Map<String, Object> queyrMemberListPage(QueryMemberListCommand queryMemberListCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            QueryMemberListParams queryMemberListParams = new QueryMemberListParams();
            BeanUtil.copyProperties(queryMemberListCommand, queryMemberListParams);
            PageInfo<Member> memberList =  memberService.queyrMemberListPage(queryMemberListParams);
            Map<String, Object> data = new HashMap<>();
            data.put("data", memberList.getList());
            data.put("pageSize", memberList.getPageSize());
            data.put("pageNo", memberList.getPageNum());
            data.put("totalCount", memberList.getTotal());
            data.put("totalPage", memberList.getPages());
            map.put("code", StatusConstant.successCode);
            map.put("message", "查询成功");
            map.put("result", data);
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "查询失败！" + e.getMessage());
        }
        return map;
    }

    @GetMapping("/getMemberInfo")
    public Map<String, Object> getMemberInfo(QueryMemberInfoCommand queryMemberInfoCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            ValidationUtil.validateBean(queryMemberInfoCommand);
            Integer memberId = queryMemberInfoCommand.getMemberId();
            Member member = memberService.getMemberInfo(memberId);
            if (ObjectUtil.isNotEmpty(member)){
                map.put("code", StatusConstant.successCode);
                map.put("message", "获取成功！");
                map.put("result", member);
            }else{
                map.put("code", StatusConstant.failCode);
                map.put("message", "获取失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "获取失败！" + e.getMessage());
        }
        return map;
    }

    @PostMapping("/saveMember")
    public Map<String, Object> saveMember(SaveMemberCommand saveMemberCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            SaveMemberParams saveMemberParams = new SaveMemberParams();
            BeanUtil.copyProperties(saveMemberCommand, saveMemberParams);
            ResultResponse resultResponse = memberService.saveMember(saveMemberParams);
            map.put("code", resultResponse.getCode());
            map.put("message", resultResponse.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "新增失败！" + e.getMessage());
        }
        return map;
    }

    @PostMapping("/updateMember")
    public Map<String, Object> UpdateMember(UpdateMemberCommand updateMemberCommand){
        Map<String, Object> map = new HashMap<>();
        try{
            UpdateMemberParams updateMemberParams = new UpdateMemberParams();
            BeanUtil.copyProperties(updateMemberCommand, updateMemberParams);
            ResultResponse resultResponse = memberService.updateMember(updateMemberParams);
            map.put("code", resultResponse.getCode());
            map.put("message", resultResponse.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            map.put("code", StatusConstant.failCode);
            map.put("message", "修改失败！" + e.getMessage());
        }
        return map;
    }



}
