package com.app.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cn.dao.PredefinedTravelInfoDao;
import com.app.cn.dto.ResultDto;
import com.app.cn.entity.PredefinedTravelInfo;
import com.app.cn.service.PredefinedTravelInfoService;

@Service
public class PredefinedTravelInfoImpl implements PredefinedTravelInfoService {
	@Autowired
	private PredefinedTravelInfoDao dao;
	
	public ResultDto<PredefinedTravelInfo> addPredefinedTravelInfo(PredefinedTravelInfo info) {
		ResultDto<PredefinedTravelInfo> result = null;
		int effectedRow = dao.addPredefinedTravelInfo(info);
		
		if(effectedRow != 1) {
			result = new ResultDto<>();
			result.setSuccess("no");
			result.setErrMsg("插入预定义旅游信息失败");
			return result;
		}
		result = new ResultDto<>();
		result.setSuccess("ok");
		result.setResult(info);
		return result;
	}

}
