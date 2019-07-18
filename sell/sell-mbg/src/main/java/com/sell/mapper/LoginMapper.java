package com.sell.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sell.model.Function;
import com.sell.model.User;

public interface LoginMapper {

	int checkUser(@Param("uuid") String uuid,@Param("funcId") int funcId);

	User login(@Param("username") String username,@Param("password") String password);

	void update(User user);

	List<Function> getPermissionList(int id);

	User getUser(String username);

	void saveToken(@Param("token") String token,@Param("id") int id);


}
