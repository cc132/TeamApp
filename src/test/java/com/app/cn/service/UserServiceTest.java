package com.app.cn.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.cn.BaseTest;
import com.app.cn.dto.UserDto;
import com.app.cn.entity.User;

public class UserServiceTest extends BaseTest{
	@Autowired
	private UserDaoService userDaoService;
	
	@Test
	public void testAddUser() throws Exception {
		User user = new User();
		user.setUsername("谢逊");
		user.setPassword("1112231");
		UserDto addUser = userDaoService.addUser(user);
		assertEquals("no",addUser.getSuccess());
		user.setUsername("谢逊1");
		addUser = userDaoService.addUser(user);
		assertEquals("no",addUser.getSuccess());
		user.setUsername("石破天2");
		addUser = userDaoService.addUser(user);
		assertEquals("yes",addUser.getSuccess());
		System.out.println(addUser.getUser().getId());
	}
	
	@Test
	public void testQueryOneUser() throws Exception {
		User user = new User();
		user.setUsername("张三丰");
		user.setPassword("123456");
		UserDto dto = userDaoService.queryOneUser(user);
		assertEquals("yes",dto.getSuccess());
		System.out.println(dto.getUser().getId());
		user.setUsername("张三丰1");
		user.setPassword("123456");
		dto = userDaoService.queryOneUser(user);
		assertEquals("no",dto.getSuccess());
		System.out.println(dto.getErrMsg());
	}
}
