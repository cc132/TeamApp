package com.app.cn.service.impl;

import java.util.List;

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

	@Override
	public ResultDto<String> deletePredefinedTravelInfo(Integer id) {
		ResultDto<String> dto = new ResultDto<>();
		try {
			dao.deletePredefinedTravelInfo(id);
			dto.setSuccess("ok");
		}catch(Exception e) {
			dto.setSuccess("no");
			dto.setResult(e.toString());
		}
		return dto;
	}

	@Override
	public ResultDto<List<PredefinedTravelInfo>> queryPredefinedTravelInfos(String username) {
		ResultDto<List<PredefinedTravelInfo>> dto = new ResultDto<>();
		try {
			List<PredefinedTravelInfo> infos = dao.queryPredefinedTravelInfos(username);
			dto.setSuccess("ok");
			dto.setResult(infos);
		}catch(Exception e) {
			dto.setSuccess("no");
		}
		return dto;
	}

	@Override
	public ResultDto<String> updatePredefinedTravelInfo(PredefinedTravelInfo info) {
		ResultDto<String> dto = new ResultDto<>();
		try {
			dao.updatePredefinedTravelInfo(info);
			dto.setSuccess("ok");
		}catch(Exception e) {
			dto.setSuccess("no");
		}
		return dto;
	}

}
