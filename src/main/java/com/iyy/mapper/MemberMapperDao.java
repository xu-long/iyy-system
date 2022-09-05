package com.iyy.mapper;

import com.iyy.entity.Member;
import com.iyy.service.params.QueryMemberListParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapperDao extends MemberMapper{

    /**
     * 查询会员信息list
     * @param memberNickname
     * @param mobileNumber
     * @return
     */
    List<Member> queyrMemberList(@Param("memberNickname") String memberNickname, @Param("mobileNumber") String mobileNumber);

    /**
     * 获取会员信息
     * @param memberId
     * @return
     */
    Member getMemberInfo(@Param("memberId") Integer memberId);
}