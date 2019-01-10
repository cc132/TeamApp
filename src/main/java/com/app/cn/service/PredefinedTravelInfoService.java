package com.app.cn.service;

import com.app.cn.dto.ResultDto;
import com.app.cn.entity.PredefinedTravelInfo;

public interface PredefinedTravelInfoService {
	
	ResultDto<PredefinedTravelInfo> addPredefinedTravelInfo(PredefinedTravelInfo info);
}
