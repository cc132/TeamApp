package com.app.cn.dao;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.cn.BaseTest;
import com.app.cn.entity.PredefinedTravelInfo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PredefinedTravelInfoDaoTest extends BaseTest{
	@Autowired
	private PredefinedTravelInfoDao dao;
	@Test
	@Ignore
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
	
	@Test
	public void testBQueryPredefinedTravelInfo() throws Exception {
		List<PredefinedTravelInfo> infos = dao.queryPredefinedTravelInfos("测试人员1");
		System.out.println(infos.size());
		for (PredefinedTravelInfo info : infos) {
			System.out.println(info);
		}
	}
	
	@Test
	public void testCUpdatePredefinedTravelInfo() throws Exception {
		PredefinedTravelInfo info = new PredefinedTravelInfo();
		info.setId(1);
		info.setUsername("测试人员1");
		info.setActivityName("更新后的预定活动1");
		info.setArea("更新后的测试区域1");
		info.setSpecificLocation("更新后的具体区域1");
		dao.updatePredefinedTravelInfo(info);
	}
	
	@Test
	public void testDeletePredefinedTravelInfo() throws Exception {
		dao.deletePredefinedTravelInfo(3);
	}
}
