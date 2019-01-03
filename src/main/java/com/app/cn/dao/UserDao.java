package com.app.cn.dao;

import java.util.List;
import com.app.cn.entity.User;

public interface UserDao {
	List<User> listAll();
	
	//首先对用户名排查，保证用户名唯一
	int queryForOneUser(String username);
	
	//用户注册
	int insertOneUser(User user);
	//用户登录
	int queryRegisteredUser(User user);
	
	int getIdByUsernameAndPassword(User user);
}
