package com.app.cn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.cn.dto.UserDto;
import com.app.cn.entity.User;
import com.app.cn.service.UserDaoService;

@Controller
public class UserRegisterAndLoginController {
	@Autowired
	private UserDaoService service;
	
	@RequestMapping(value="/user/register",method=RequestMethod.POST)
	@ResponseBody
	public UserDto registerUser(String username,String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		UserDto addUser = service.addUser(user);
		return addUser;
	}
	
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	@ResponseBody
	public UserDto loginUser(String username,String password) {
		System.out.println("order arrival..............");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		UserDto addUser = service.queryOneUser(user);
		return addUser;
	}
}
