package com.app.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cn.dao.TravelInfoDao;
import com.app.cn.dto.ResultDto;
import com.app.cn.dto.TravelInfoDto;
import com.app.cn.entity.TeamInfo;
import com.app.cn.entity.TravelInfo;
import com.app.cn.service.TravelInfoService;

@Service
public class TravelInfoServiceImpl implements TravelInfoService {
	@Autowired
	private TravelInfoDao dao;

	public TravelInfoDto addTravelInfo(TravelInfo info) {
		dao.addTravelInfo(info);
		TravelInfoDto dto = new TravelInfoDto();
		Integer activityId = info.getId();
		String leaderUsername = info.getUsername();
		Integer leaderId = info.getUsernameId();
		TeamInfo leaderInfo = new TeamInfo();
		leaderInfo.setLeaderUsername(leaderUsername);
		leaderInfo.setLeaderId(leaderId);
		leaderInfo.setActivityId(activityId);
		leaderInfo.setMemberUsername(leaderUsername);
		leaderInfo.setMemberId(leaderId);
		leaderInfo.setProcess(0);
		leaderInfo.setFlag(0);
		dao.applyForOneActivity(leaderInfo);
		dto.setSuccess("ok");
		dto.setData(info);
		return dto;
	}

	@Override
	public ResultDto<List<TravelInfo>> showAllExecutingTravelInfo() {
		ResultDto<List<TravelInfo>> infos = new ResultDto<>();
		try {
			List<TravelInfo> showAllExecutingTravelInfo = dao.showAllExecutingTravelInfo();
			infos.setSuccess("ok");
			infos.setResult(showAllExecutingTravelInfo);
		} catch (Exception e) {
			infos.setSuccess("no");
			infos.setErrMsg(e.toString());
		}
		return infos;
	}

	@Override
	public ResultDto<List<TravelInfo>> showOwnTravelInfo(String username) {
		ResultDto<List<TravelInfo>> infos = new ResultDto<>();
		try {
			List<TravelInfo> showOwnTravelInfo = dao.showOwnTravelInfo(username);
			infos.setSuccess("ok");
			infos.setResult(showOwnTravelInfo);
		} catch (Exception e) {
			infos.setSuccess("no");
			infos.setErrMsg(e.toString());
		}
		return infos;
	}

	@Override
	public ResultDto<Object> applyForOneActivity(TeamInfo info) {
		ResultDto<Object> result = new ResultDto<>();
		try {
			dao.applyForOneActivity(info);
			result.setSuccess("ok");
		} catch (Exception e) {
			result.setSuccess("no");
			result.setErrMsg(e.toString());
		}
		return result;
	}

	@Override
	public ResultDto<List<TeamInfo>> checkTeamCondition(String leaderUsername, Integer leaderId, Integer activityId) {
		ResultDto<List<TeamInfo>> infos = new ResultDto<>();
		try {
			List<TeamInfo> result = dao.checkTeamCondition(leaderUsername, leaderId, activityId);
			infos.setSuccess("ok");
			infos.setResult(result);
		} catch (Exception e) {
			infos.setSuccess("no");
			infos.setErrMsg(e.toString());
		}
		return infos;
	}

	@Override
	public ResultDto<Object> deleteSomeApplication(String leaderUsername, Integer activityId, String memberUsername,
			Integer memberId) {
		ResultDto<Object> infos = new ResultDto<>();
		try {
			dao.deleteSomeApplication(leaderUsername, activityId, memberUsername, memberId);
			infos.setSuccess("ok");
		} catch (Exception e) {
			infos.setSuccess("no");
			infos.setErrMsg(e.toString());
		}
		return infos;
	}

	@Override
	public ResultDto<List<TeamInfo>> endApplication(String leaderUsername, Integer leaderId, Integer activityId) {
		ResultDto<List<TeamInfo>> infos = new ResultDto<>();
		try {
			dao.endApplication(leaderUsername, leaderId, activityId);
			dao.changeTravelInfoProcess(leaderUsername, leaderId, activityId);
			ResultDto<List<TeamInfo>> finalTeamInfo = getFinalTeamInfo(leaderUsername, leaderId, activityId);
			infos.setSuccess("ok");
			infos.setResult(finalTeamInfo.getResult());
		} catch (Exception e) {
			infos.setSuccess("no");
			infos.setErrMsg(e.toString());
		}
		return infos;
	}

	@Override
	public ResultDto<List<TeamInfo>> getFinalTeamInfo(String leaderUsername, Integer leaderId, Integer activityId) {
		ResultDto<List<TeamInfo>> res = new ResultDto<>();
		List<TeamInfo> infos = dao.getFinalTeamInfo(leaderUsername, leaderId, activityId);
		res.setResult(infos);
		res.setSuccess("ok");
		return res;
	}

	@Override
	public ResultDto<Object> acceptSomeApplication(String leaderUsername, Integer activityId, String memberUsername,
			Integer memberId) {
		ResultDto<Object> infos = new ResultDto<>();
		try {
			dao.acceptOneApplication(leaderUsername, activityId, memberUsername, memberId);
			infos.setSuccess("ok");
		} catch (Exception e) {
			infos.setSuccess("no");
			infos.setErrMsg(e.toString());
		}
		return infos;
	}

	@Override
	public ResultDto<Object> refuseSomeApplication(String leaderUsername, Integer activityId, String memberUsername,
			Integer memberId) {
		ResultDto<Object> infos = new ResultDto<>();
		try {
			dao.refuseOneApplication(leaderUsername, activityId, memberUsername, memberId);
			infos.setSuccess("ok");
		} catch (Exception e) {
			infos.setSuccess("no");
			infos.setErrMsg(e.toString());
		}
		return infos;
	}
}
