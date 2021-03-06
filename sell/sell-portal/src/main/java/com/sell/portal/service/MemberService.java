package com.sell.portal.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;

import com.sell.model.Member;
import com.sell.util.CommonResult;

/**
 * 会员管理Service
 * Created by macro on 2018/8/3.
 */
public interface MemberService {
    /**
     * 根据用户名获取会员
     */
    Member getByUsername(String username);

    /**
     * 根据会员编号获取会员
     */
    Member getById(Long id);

    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 修改密码
     */
    @Transactional
    CommonResult updatePassword(String telephone, String password, String authCode);

    /**
     * 获取当前登录会员
     * @param request 
     */
    Member getCurrentMember(HttpServletRequest request);

}
