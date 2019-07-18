package com.sell.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.AuthenticationException;

import com.sell.admin.service.LoginService;
import com.sell.admin.utils.JwtTokenUtil;
import com.sell.admin.utils.MD5Utils;
import com.sell.mapper.LoginMapper;
import com.sell.model.Function;
import com.sell.model.User;

@Service
public class LoginServiceImpl implements LoginService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
	@Autowired
	private LoginMapper loginMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
    private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public int check(String uuid, int funcId) {
		
		return loginMapper.checkUser(uuid,funcId);
	}

	   @Override
	    public String login(String username, String password) {
	        String token = null;
	        //密码需要客户端加密后传递
	        System.out.println("^^^^^^^^^^^^^+"+passwordEncoder.encodePassword(password, null));
	        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, passwordEncoder.encodePassword(password, null));
	        try {
	            Authentication authentication = authenticationManager.authenticate(authenticationToken);
	            SecurityContextHolder.getContext().setAuthentication(authentication);
	            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	            token = jwtTokenUtil.generateToken(userDetails);
	            updateLoginTimeByUsername(username);
	              insertLoginLog(username);
	            //同步token信息到商户信息表中
	            if(!username.equals("admin"))
	                 saveToken(token,username,password);
	        } catch (AuthenticationException e) {
	            LOGGER.warn("登录异常:{}", e.getMessage());
	        }
	        return token;
	    }

	private void updateLoginTimeByUsername(String username) {
		User user = new User();
		user.setLoginTime(new Date());
		user.setUsername(username);
		loginMapper.update(user);
		
	}
	
	@Override
	public void saveToken(String token,String username,String password) {
		//查询用户id
		User user= loginMapper.login(username, MD5Utils.string2MD5(password));
		if(user!=null)
		  loginMapper.saveToken(token,user.getId());
	}

	@Override
	public User getAdminByUsername(String username) {
		
		return loginMapper.getUser(username);
	}

	@Override
	public List<Function> getPermissionList(int id) {
		
		return loginMapper.getPermissionList(id);
	}
	
	 /**
     * 添加登录记录
     * @param username 用户名
     */
    private void insertLoginLog(String username) {
      /*  UmsAdmin admin = getAdminByUsername(username);
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());
        loginLogMapper.insert(loginLog);*/
    }

}
