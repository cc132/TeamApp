package com.app.cn.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.cn.BaseTest;
import com.app.cn.entity.User;

public class UserDaoTest extends BaseTest{
	@Autowired
	private UserDao userDao;
	@Test
	public void testListAll() throws Exception {
		 List<User> listAll = userDao.listAll();
		 assertEquals(1,listAll.size());
	}
}
