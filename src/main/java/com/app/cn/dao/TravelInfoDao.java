package com.app.cn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.app.cn.entity.TeamInfo;
import com.app.cn.entity.TravelInfo;

public interface TravelInfoDao {
	//添加发布的出游信息
	void addTravelInfo(TravelInfo info);
	
	//显示所有处于组队状态中的出游信息
	List<TravelInfo> showAllExecutingTravelInfo();
	
	//显示用户自己发布的组队出游信息
	List<TravelInfo> showOwnTravelInfo(String username);

	//申请加入某个活动
	void applyForOneActivity(TeamInfo info);
	
	//作为活动的发起人,可以查看申请入队的情况
	List<TeamInfo> checkTeamCondition(@Param("leaderUsername")String leaderUsername,@Param("leaderId")Integer leaderId,@Param("activityId")Integer activityId);

	//作为活动的发起人，可以删除一些入队请求
	void deleteSomeApplication(@Param("leaderUsername")String leaderUsername,@Param("activityId") Integer activityId,@Param("memberUsername")String memberUsername,@Param("memberId")Integer memberId);
	
	//作为活动的发起人，可以确定招募队员何时结束
	void endApplication(@Param("leaderUsername")String leaderUsername,@Param("leaderId")Integer leaderId,@Param("activityId")Integer activityId);
	void changeTravelInfoProcess(@Param("username")String username,@Param("username_id")Integer username_Id,@Param("id") Integer id);
	List<TeamInfo> getFinalTeamInfo(@Param("leaderUsername")String leaderUsername,@Param("leaderId")Integer leaderId,@Param("activityId")Integer activityId);
	
	//活动发起人拒绝队员的入队申请
	int refuseOneApplication(@Param("leaderUsername")String leaderUsername,@Param("activityId") Integer activityId,@Param("memberUsername")String memberUsername,@Param("memberId")Integer memberId);
	//活动发起人接受队员的入队申请
	int acceptOneApplication(@Param("leaderUsername")String leaderUsername,@Param("activityId") Integer activityId,@Param("memberUsername")String memberUsername,@Param("memberId")Integer memberId);
}
