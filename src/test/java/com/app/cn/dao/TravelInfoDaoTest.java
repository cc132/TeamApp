package com.app.cn.dao;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.cn.BaseTest;
import com.app.cn.entity.TeamInfo;
import com.app.cn.entity.TravelInfo;
import com.app.cn.util.CommonsUtil;

public class TravelInfoDaoTest extends BaseTest {
	@Autowired
	private TravelInfoDao dao;

	@Test
	public void testAddTravelInfo() throws Exception {
		TravelInfo info = new TravelInfo();
		info.setUsername("测试8");
		info.setToWhere("南京雨花台");
		Date date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);// 把日期往后增加一天.正数往后推,负数往前推
		date = calendar.getTime();
		info.setStartTime(CommonsUtil.Date2String(date));
		info.setPeopleNum(4);
		info.setProcess(0);
		info.setReleaseTime(CommonsUtil.Date2String(new Date()));
		info.setUsernameId(8);
		dao.addTravelInfo(info);
		System.out.println(info.getId());
	}
	
	@Test
	public void testShowAllExecutingTravelInfo() throws Exception {
		List<TravelInfo> infos = dao.showAllExecutingTravelInfo();
		assertEquals(7,infos.size());
	}
	
	@Test
	public void testShowOwnTravelInfo() throws Exception {
		List<TravelInfo> infos = dao.showOwnTravelInfo("张三1");
		if(infos != null && infos.size() >= 1) {
			for (TravelInfo info : infos) {
				System.out.println(info);
			}
		}else {
			System.out.println("没有相关数据");
		}
	}
	
	@Test
	public void testApplyForOneActivity() throws Exception {
		TeamInfo info = new TeamInfo();
		info.setLeaderUsername("张三");
		info.setLeaderId(1);
		info.setActivityId(1);
		info.setMemberUsername("张6");
		info.setMemberId(16);
		info.setProcess(0);
		info.setFlag(0);
		dao.applyForOneActivity(info);
		System.out.println(info.getId());
	}
	
	@Test
	public void testCheckTeamConition() throws Exception {
		List<TeamInfo> conditions = dao.checkTeamCondition("张三",1,1);
		if(conditions != null && conditions.size() >= 1) {
			for (TeamInfo condition : conditions) {
				System.out.println(condition);
			}
		}
	}
	
	@Test
	public void testDeleteSomeApplication() throws Exception {
		
	}
	
	@Test
	public void EndApplication() throws Exception {
		dao.endApplication("张三", 1, 1);
		dao.changeTravelInfoProcess("张三", 1,1);
	}
	
	@Test
	public void testGetFinalTeamInfo() throws Exception {
		List<TeamInfo> infos = dao.getFinalTeamInfo("张三", 1, 1);
		if(infos != null && infos.size() > 0) {
			for (TeamInfo info : infos) {
				System.out.println(info);
			}
		}else {
			System.out.println("error==========");
		}
	}
}
