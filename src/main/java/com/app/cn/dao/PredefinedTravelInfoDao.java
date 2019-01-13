package com.app.cn.dao;

import java.util.List;

import com.app.cn.entity.PredefinedTravelInfo;

public interface PredefinedTravelInfoDao {
	//增加自定义出游地点
	int addPredefinedTravelInfo(PredefinedTravelInfo info);
	
	//查询自定义出游地点
	List<PredefinedTravelInfo> queryPredefinedTravelInfos(String username);
	
	//更新自定义出游地点
	int updatePredefinedTravelInfo(PredefinedTravelInfo info);
	
	//删除自定义出游地点
	int deletePredefinedTravelInfo(Integer id);
}
