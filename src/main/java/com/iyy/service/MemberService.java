package com.iyy.service;

import com.github.pagehelper.PageInfo;
import com.iyy.entity.Member;
import com.iyy.service.params.QueryMemberListParams;
import com.iyy.service.params.SaveMemberParams;
import com.iyy.service.params.UpdateMemberParams;
import com.iyy.vo.ResultResponse;

import java.util.List;

/**
 * @author xuhualong
 * @version 1.0
 * @since 2022/9/4 2:58 下午
 */
public interface MemberService {
    /**
     * 查询会员list
     * @param memberNickname
     * @param mobileNumber
     * @return
     */
    List<Member> queyrMemberList(String memberNickname, String mobileNumber);

    /**
     * 查询会员List分页
     * @param queryMemberListParams
     * @return
     */
    PageInfo<Member> queyrMemberListPage(QueryMemberListParams queryMemberListParams);

    /**
     * 新增会员
     * @param saveMemberParams
     * @return
     */
    ResultResponse saveMember(SaveMemberParams saveMemberParams);

    /**
     * 修改会员
     * @param updateMemberParams
     * @return
     */
    ResultResponse updateMember(UpdateMemberParams updateMemberParams);

    /**
     * 获取会员信息
     * @param memberId
     * @return
     */
    Member getMemberInfo(Integer memberId);
}
