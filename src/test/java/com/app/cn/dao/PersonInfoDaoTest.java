package com.app.cn.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.cn.BaseTest;
import com.app.cn.entity.PersonInfo;

public class PersonInfoDaoTest extends BaseTest{
	@Autowired
	private PersonInfoDao dao;
	
	@Test
	@Ignore
	public void testAddPersonInfo() throws Exception {
		PersonInfo info = new PersonInfo();
		info.setUsername("测试2");
		info.setAge(24);
		info.setGender(1);
		info.setSchoolArea("测试区域");
		int effectedRow = dao.addPersonInfo(info);
		System.out.println(info.getId());
		System.out.println(effectedRow);
	}
	
	@Test
	public void testUpdatePersonInfo() throws Exception {
		PersonInfo info = new PersonInfo();
		info.setUsername("测试2");
		info.setAge(30);
		info.setGender(0);
		info.setSchoolArea("测试更新数据");
		int effectedRow = dao.updatePersonInfo(info);
		System.out.println(effectedRow);
	}
	
	@Test
	public void testQueryPersonInfo() throws Exception {
		PersonInfo info = dao.queryPersonInfo("测试事务2");
		System.out.println(info.toString());
	}
}
