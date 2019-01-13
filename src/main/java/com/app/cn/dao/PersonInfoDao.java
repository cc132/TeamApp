package com.app.cn.dao;

import com.app.cn.entity.PersonInfo;

public interface PersonInfoDao {
	//添加个人详细信息
	int addPersonInfo(PersonInfo info);
	
	//更新个人信息
	int updatePersonInfo(PersonInfo info);
	
	//查询个人信息
	PersonInfo queryPersonInfo(String username);
}
