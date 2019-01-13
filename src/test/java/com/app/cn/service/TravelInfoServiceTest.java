package com.app.cn.service;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.cn.BaseTest;
import com.app.cn.dto.ResultDto;
import com.app.cn.dto.TravelInfoDto;
import com.app.cn.entity.TeamInfo;
import com.app.cn.entity.TravelInfo;
import com.app.cn.util.CommonsUtil;

public class TravelInfoServiceTest extends BaseTest{
	@Autowired
	private TravelInfoService infoService;
	
	@Test
	public void testAddTravelInfo() throws Exception {
		TravelInfo info = new TravelInfo();
		info.setUsername("新的测试2");
		info.setToWhere("南京新街口");
		Date date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 2);// 把日期往后增加两天.正数往后推,负数往前推
		date = calendar.getTime();
		info.setStartTime(CommonsUtil.Date2String(date));
		info.setPeopleNum(4);
		info.setProcess(0);
		info.setUsernameId(88);
		info.setReleaseTime(CommonsUtil.Date2String(new Date()));
		TravelInfoDto addTravelInfo = infoService.addTravelInfo(info);
		assertEquals("ok",addTravelInfo.getSuccess());
		System.out.println(addTravelInfo.getData().getId());
	}
	@Test
	public void testEndApplication() throws Exception {
		ResultDto<List<TeamInfo>> result = infoService.getFinalTeamInfo("张三", 1, 1);
		List<TeamInfo> infos = result.getResult();
		if(infos != null && infos.size() > 0) {
			for (TeamInfo teamInfo : infos) {
				System.out.println(teamInfo);
			}
		}
	}
}
