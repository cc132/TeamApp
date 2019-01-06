package com.app.cn.service;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.cn.BaseTest;
import com.app.cn.dto.TravelInfoDto;
import com.app.cn.entity.TravelInfo;

public class TravelInfoServiceTest extends BaseTest{
	@Autowired
	private TravelInfoService infoService;
	
	@Test
	public void testAddTravelInfo() throws Exception {
		TravelInfo info = new TravelInfo();
		info.setUsername("测试5");
		info.setToWhere("南京雨花台");
		Date date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 2);// 把日期往后增加两天.正数往后推,负数往前推
		date = calendar.getTime();
		info.setStartTime(date);
		info.setPeopleNum(4);
		info.setProcess(0);
		info.setReleaseTime(new Date());
		TravelInfoDto addTravelInfo = infoService.addTravelInfo(info);
		assertEquals("ok",addTravelInfo.getSuccess());
		System.out.println(addTravelInfo.getData().getId());
	}
}
