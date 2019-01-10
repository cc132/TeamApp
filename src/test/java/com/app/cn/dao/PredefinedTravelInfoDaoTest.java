package com.app.cn.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.cn.BaseTest;
import com.app.cn.entity.PredefinedTravelInfo;

public class PredefinedTravelInfoDaoTest extends BaseTest{
	@Autowired
	private PredefinedTravelInfoDao dao;
	@Test
	public void testAddPredefindeTravelInfo() throws Exception {
		PredefinedTravelInfo info = new PredefinedTravelInfo();
		info.setUsername("测试人员1");
		info.setActivityName("测试预定活动1");
		info.setArea("测试区域1");
		info.setSpecificLocation("测试具体区域1");
		int effectedRow = dao.addPredefinedTravelInfo(info);
		System.out.println(effectedRow);
		System.out.println(info.getId());
	}
}
