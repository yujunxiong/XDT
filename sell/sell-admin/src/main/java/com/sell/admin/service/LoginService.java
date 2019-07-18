package com.sell.admin.service;

import java.util.List;

import com.sell.model.Function;
import com.sell.model.User;

public interface LoginService {

	int check(String uuid, int funcId);

	String login(String username, String password);

	User getAdminByUsername(String username);

	List<Function> getPermissionList(int id);
	
	void saveToken (String token,String username,String password);

}
