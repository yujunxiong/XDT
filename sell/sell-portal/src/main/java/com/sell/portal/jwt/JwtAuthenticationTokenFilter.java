package com.sell.portal.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sell.mapper.MemberMapper;
import com.sell.model.Member;
import com.sell.util.CommonResult;
import com.sell.util.JsonUtils;
import com.sell.util.ReturnCode;

import io.jsonwebtoken.JwtException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * JWT登录授权过滤器
 * Created by macro on 2018/4/26.
 */
public class JwtAuthenticationTokenFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private MemberMapper memberMapper;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

   /* @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        String authHeader = request.getHeader(this.tokenHeader);
        if (authHeader != null && authHeader.startsWith(this.tokenHead)) {
            String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
            String openid = jwtTokenUtil.getUserNameFromToken(authToken);
            LOGGER.info("checking openid:{}", openid);
            if (openid != null ) {
            	UmsMember umsMember = memberMapper.selectMemberByOpenId(openid);
                LOGGER.info("authenticated user:{}", openid);
            }
        }
        chain.doFilter(request, response);
    }*/

    @Override
	public void init(FilterConfig filterConfig) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
	            filterConfig.getServletContext());

		
	}
    
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.setCharacterEncoding("UTF-8");  
		httpResponse.setContentType("application/json; charset=utf-8"); 
		String authHeader = httpRequest.getHeader(this.tokenHeader);
		if(httpRequest.getRequestURI().startsWith("/wx")||httpRequest.getRequestURI().startsWith("/home")||httpRequest.getRequestURI().startsWith("/setMeal")||httpRequest.getRequestURI().startsWith("/chef")){
			chain.doFilter(request, response);
    		return;
		}
		if (authHeader != null && authHeader.startsWith(this.tokenHead)) {
			 	String authToken = authHeader.substring(this.tokenHead.length());// The part after "Bearer "
	            String openid = null;
				try {
					openid = jwtTokenUtil.getUserNameFromToken(authToken);
				} catch (JwtException e) {
					httpResponse.getWriter().write(JsonUtils.toJson(new CommonResult().failed(ReturnCode.LOGIN_TOKEN_INVALID)));
					return;
				}
	            LOGGER.info("checking openid:{}", openid);
	            if (openid != null ) {
	            	LOGGER.info("authenticated user:{}", openid);
	            	Member umsMember = memberMapper.selectMemberByOpenId(openid);
	            	if(umsMember!=null){
	            		chain.doFilter(request, response);
	            		return;
	            	}else{
	            		httpResponse.getWriter().write(JsonUtils.toJson(new CommonResult().failed(ReturnCode.LOGIN_VERIFY_FAILED)));
	        			return;
	            	}
	            }
		}else{
			httpResponse.getWriter().write(JsonUtils.toJson(new CommonResult().failed(ReturnCode.LOGIN_VERIFY_FAILED)));
			return;
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
