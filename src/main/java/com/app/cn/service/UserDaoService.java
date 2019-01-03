package com.app.cn.service;

import com.app.cn.dto.UserDto;
import com.app.cn.entity.User;

public interface UserDaoService {
	 
	//用户注册
	UserDto addUser(User user);
	//用户登录
	UserDto queryOneUser(User user);
}
