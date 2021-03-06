package com.app.cn.service;

import java.util.List;

import com.app.cn.dto.ResultDto;
import com.app.cn.entity.PredefinedTravelInfo;

public interface PredefinedTravelInfoService {
	
	ResultDto<PredefinedTravelInfo> addPredefinedTravelInfo(PredefinedTravelInfo info);
	
	ResultDto<String> deletePredefinedTravelInfo(Integer id);
	
	ResultDto<String>updatePredefinedTravelInfo(PredefinedTravelInfo info);
	
	ResultDto<List<PredefinedTravelInfo>> queryPredefinedTravelInfos(String username);
}
