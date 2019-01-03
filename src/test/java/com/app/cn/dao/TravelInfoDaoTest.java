package com.app.cn.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.cn.BaseTest;
import com.app.cn.entity.TravelInfo;

public class TravelInfoDaoTest extends BaseTest {
	@Autowired
	private TravelInfoDao dao;

	@Test
	public void testAddTravelInfo() throws Exception {
		TravelInfo info = new TravelInfo();
		info.setUsername("测试2");
		info.setToWhere("南京雨花台");
		Date date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);// 把日期往后增加一天.正数往后推,负数往前推
		date = calendar.getTime();
		info.setStartTime(date);
		info.setPeopleNum(4);
		info.setProcess(0);
		dao.addTravelInfo(info);
		System.out.println(info.getId());
	}
}
