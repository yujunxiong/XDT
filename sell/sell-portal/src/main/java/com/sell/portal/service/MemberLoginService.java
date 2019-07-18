package com.sell.portal.service;

import com.sell.portal.dto.LoginParameter;
import com.sell.util.CommonResult;

public interface MemberLoginService {

	CommonResult login(LoginParameter loginParameter);

}
