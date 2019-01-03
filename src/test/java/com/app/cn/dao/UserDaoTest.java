package com.app.cn.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.cn.BaseTest;
import com.app.cn.entity.User;

public class UserDaoTest extends BaseTest{
	@Autowired
	private UserDao userDao;
	@Test
	@Ignore
	public void testListAll() throws Exception {
		 List<User> listAll = userDao.listAll();
		 assertEquals(1,listAll.size());
	}
	
	@Test
	@Ignore
	public void testQueryForOneUser() throws Exception {
		int count = userDao.queryForOneUser("张三丰");
		assertEquals(1,count);
		int scount = userDao.queryForOneUser("张无忌");
		assertEquals(0,scount);
	}
	
	@Test
	@Ignore
	public void testInsertOneUser() throws Exception {
		User user = new User();
		user.setUsername("谢逊1");
		user.setPassword("654321");
		userDao.insertOneUser(user);
		System.out.println(user.getId());
	}
	
	@Test
	@Ignore
	public void testQueryRegisteredUser() throws Exception {
		User user = new User();
		user.setUsername("张三丰");
		user.setPassword("123456");
		int effectedCount = userDao.queryRegisteredUser(user);
		assertEquals(effectedCount,1);
		user.setUsername("张三丰1");
		effectedCount = userDao.queryRegisteredUser(user);
		assertEquals(0,effectedCount);
	}
}
