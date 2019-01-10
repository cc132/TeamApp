package com.app.cn.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.cn.BaseTest;
import com.app.cn.dto.ResultDto;
import com.app.cn.entity.PersonInfo;

public class PersonInfoServiceTest extends BaseTest{
	@Autowired
	private PersonInfoService service;
	
	@Test
	public void testAddPersonInfo() throws Exception {
		PersonInfo info = new PersonInfo();
		info.setUsername("测试3");
		info.setAge(24);
		info.setGender(1);
		info.setSchoolArea("测试区域");
		ResultDto<PersonInfo> addPersonInfo = service.addPersonInfo(info);
		assertEquals("ok",addPersonInfo.getSuccess());
		System.out.println(addPersonInfo.getResult().getId());
	}
}
