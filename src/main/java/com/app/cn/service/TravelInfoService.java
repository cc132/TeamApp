package com.app.cn.service;

import java.util.List;

import com.app.cn.dto.ResultDto;
import com.app.cn.dto.TravelInfoDto;
import com.app.cn.entity.TeamInfo;
import com.app.cn.entity.TravelInfo;

public interface TravelInfoService {
	//添加发布的出游信息
	TravelInfoDto addTravelInfo(TravelInfo info);

	
	//显示所有处于组队状态中的出游信息
	ResultDto<List<TravelInfo>> showAllExecutingTravelInfo();
	
	//显示用户自己发布的组队出游信息
	ResultDto<List<TravelInfo>> showOwnTravelInfo(String username);
	
	//申请加入某个活动
	ResultDto<Object> applyForOneActivity(TeamInfo info);
	
	//作为活动的发起人,可以查看申请入队的情况
	ResultDto<List<TeamInfo>> checkTeamCondition(String leaderUsername,Integer leaderId,Integer activityId);
	
	//作为活动的发起人，可以删除一些入队请求
	ResultDto<Object> deleteSomeApplication(String leaderUsername,Integer activityId,String memberUsername,Integer memberId);
	
	//作为活动的发起人，可以确定招募队员何时结束
	ResultDto<List<TeamInfo>> endApplication(String leaderUsername,Integer leaderId,Integer activityId);
	ResultDto<List<TeamInfo>> getFinalTeamInfo(String leaderUsername,Integer leaderId,Integer activityId);
}
