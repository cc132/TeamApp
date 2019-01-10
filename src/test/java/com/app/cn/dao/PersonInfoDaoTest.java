package com.app.cn.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.cn.BaseTest;
import com.app.cn.entity.PersonInfo;

public class PersonInfoDaoTest extends BaseTest{
	@Autowired
	private PersonInfoDao dao;
	
	@Test
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
}
