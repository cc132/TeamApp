package com.app.cn.service;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.cn.BaseTest;
import com.app.cn.dto.ResultDto;
import com.app.cn.entity.PredefinedTravelInfo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PredefinedTravelInfoServiceTest extends BaseTest{
	@Autowired
	private PredefinedTravelInfoService service;
	
	@Test
	public void testAAddPredefinedTravelInfo() throws Exception {
		PredefinedTravelInfo info = new PredefinedTravelInfo();
		info.setUsername("测试人员1");
		info.setActivityName("测试活动3");
		info.setArea("测试区域3");
		info.setSpecificLocation("具体测试区域3");
		service.addPredefinedTravelInfo(info);
		System.out.println("--------id:" + info.getId());
	}
	
	@Test
	public void testBQueryPredefinedTravelInfos() throws Exception {
		ResultDto<List<PredefinedTravelInfo>> result = service.queryPredefinedTravelInfos("测试人员1");
		assertEquals(3,result.getResult().size());
	}
	
	@Test
	public void testCUpdatePredefinedTravelInfo() throws Exception {
		PredefinedTravelInfo info = new PredefinedTravelInfo();
		info.setId(4);
		info.setUsername("测试人员1");
		info.setActivityName("更新后的预定活动33");
		info.setArea("更新后的测试区域33");
		info.setSpecificLocation("更新后的具体区域33");
		service.updatePredefinedTravelInfo(info);
	}
	
	@Test
	public void testDDeletePredefinedTravelInfo() throws Exception {
		
	}
}
