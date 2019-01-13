package com.app.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.cn.dao.PersonInfoDao;
import com.app.cn.dao.UserDao;
import com.app.cn.dto.UserDto;
import com.app.cn.entity.PersonInfo;
import com.app.cn.entity.User;
import com.app.cn.service.UserDaoService;

@Service
public class UserDaoServiceImpl implements UserDaoService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private PersonInfoDao personInfoDao;
	
	@Override
	@Transactional
	//用户注册
	public UserDto addUser(User user) {
		UserDto dto = new UserDto();
		String username = user.getUsername();
		//判断用户注册时用户名是否重复
		int effectedCount = userDao.queryForOneUser(username);
		if(effectedCount >= 1) {
			dto.setSuccess("no");
			dto.setErrMsg("用户名重复");
			return dto;
		}
		//用户注册时用户名不冲突则正常执行
		try {
			userDao.insertOneUser(user);
			PersonInfo initialInfo = new PersonInfo();
			initialInfo.setUsername(username);
			personInfoDao.addPersonInfo(initialInfo);
			dto.setSuccess("ok");
			dto.setUser(user);
		}catch(Exception e) {
			dto.setSuccess("no");
			dto.setErrMsg(e.toString());
		}
		return dto;
	}

	@Override
	//用户登录
	public UserDto queryOneUser(User user) {
		int effectedNum = userDao.queryRegisteredUser(user);
		UserDto dto = new UserDto();
		//无匹配的用户
		if(effectedNum == 0) {
			dto.setSuccess("no");
			dto.setErrMsg("用户名或者密码不正确");
			return dto;
		}
		int id = userDao.getIdByUsernameAndPassword(user);
		user.setId(id);
		dto.setSuccess("ok");
		dto.setUser(user);
		return dto;
	}

}
