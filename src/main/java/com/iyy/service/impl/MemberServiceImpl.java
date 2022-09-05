package com.iyy.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iyy.constant.StatusConstant;
import com.iyy.entity.Member;
import com.iyy.entity.User;
import com.iyy.mapper.MemberMapperDao;
import com.iyy.mapper.UserMapperDao;
import com.iyy.service.MemberService;
import com.iyy.service.params.QueryMemberListParams;
import com.iyy.service.params.SaveMemberParams;
import com.iyy.service.params.UpdateMemberParams;
import com.iyy.vo.ResultResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/4 2:58 下午
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Resource
    private MemberMapperDao memberMapperDao;

    @Resource
    private UserMapperDao userMapperDao;

    @Override
    public List<Member> queyrMemberList(String memberNickname, String mobileNumber) {
        List<Member> members = memberMapperDao.queyrMemberList(memberNickname, mobileNumber);
        return members;
    }

    @Override
    public PageInfo<Member> queyrMemberListPage(QueryMemberListParams queryMemberListParams) {
        PageHelper.startPage(queryMemberListParams.getPageNum(), queryMemberListParams.getPageSize());
        List<Member> members = memberMapperDao.queyrMemberList(queryMemberListParams.getMemberNickname(), queryMemberListParams.getMobileNumber());
        return new PageInfo<>(members);
    }

    @Override
    public ResultResponse saveMember(SaveMemberParams saveMemberParams) {
        ResultResponse resultResponse = new ResultResponse();
        String mobileNumber = saveMemberParams.getMobileNumber();
        String openId = saveMemberParams.getOpenId();
        if(StrUtil.isEmpty(openId) && StrUtil.isEmpty(mobileNumber)){
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("手机号不能为空！");
        }
        Member saveMember = new Member();
        BeanUtil.copyProperties(saveMemberParams, saveMember);
        saveMember.setCreateDate(new Date());
        int rows = memberMapperDao.insertSelective(saveMember);
        if(rows > 0){
            resultResponse.setCode(StatusConstant.successCode);
            resultResponse.setMessage("新增成功！");
        }else{
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("新增失败！");
        }
        return resultResponse;
    }

    @Override
    public ResultResponse updateMember(UpdateMemberParams updateMemberParams) {
        ResultResponse resultResponse = new ResultResponse();
        Integer userId = updateMemberParams.getUserId();
        User user = userMapperDao.selectByPrimaryKey(userId);
        if(ObjectUtil.isEmpty(user)){
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("用户信息不存在！");
            return resultResponse;
        }
        Member updateMember = new Member();
        BeanUtil.copyProperties(updateMemberParams, updateMember);
        int rows = memberMapperDao.updateByPrimaryKeySelective(updateMember);
        if(rows > 0){
            resultResponse.setCode(StatusConstant.successCode);
            resultResponse.setMessage("修改成功！");
        }else{
            resultResponse.setCode(StatusConstant.failCode);
            resultResponse.setMessage("修改失败！");
        }
        return resultResponse;
    }

    @Override
    public Member getMemberInfo(Integer memberId) {
        Member member = memberMapperDao.getMemberInfo(memberId);
        return member;
    }
}
