package com.app.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cn.dao.TravelInfoDao;
import com.app.cn.dto.TravelInfoDto;
import com.app.cn.entity.TravelInfo;
import com.app.cn.service.TravelInfoService;
@Service
public class TravelInfoServiceImpl implements TravelInfoService{
	@Autowired
	private TravelInfoDao dao;
	
	public TravelInfoDto addTravelInfo(TravelInfo info) {
		dao.addTravelInfo(info);
		TravelInfoDto dto = new TravelInfoDto();
		dto.setSuccess("ok");
		dto.setData(info);
		return dto;
	}
}
