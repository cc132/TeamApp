package com.app.cn.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.cn.dto.ResultDto;
import com.app.cn.dto.TravelInfoDto;
import com.app.cn.entity.TeamInfo;
import com.app.cn.entity.TravelInfo;
import com.app.cn.service.TravelInfoService;
import com.app.cn.util.CommonsUtil;

@Controller
public class TravelActivityController {
	@Autowired
	private TravelInfoService service;
	
	@RequestMapping(value="/user/addtravelinfo",method=RequestMethod.POST)
	@ResponseBody
	public TravelInfoDto addTravelInfo(Integer id,String username,String toWhere,String startTime,Integer peopleNum,String descInfo) {
		Object[] params = {username,toWhere,descInfo};
		ResultDto<Object> result = CommonsUtil.getDecoderResult(params);
		if("no".equals(result.getSuccess())) {
			TravelInfoDto dto = new TravelInfoDto();
			dto.setSuccess("no");
			dto.setErrMsg(result.getErrMsg());
			return dto;
		}
		TravelInfo info = new TravelInfo();
		info.setUsername((String)params[0]);
		info.setToWhere((String)params[1]);
		info.setDescInfo((String)params[2]);
		info.setUsernameId(id);
		info.setReleaseTime(CommonsUtil.Date2String(new Date()));
		info.setStartTime(startTime);
		info.setProcess(0);
		info.setPeopleNum(peopleNum);
		TravelInfoDto result1 = service.addTravelInfo(info);
		return result1;
	}
	
	@RequestMapping(value="/user/showallexecutingtravelinfo",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto<List<TravelInfo>> showAllExecutingTravelInfo(){
		ResultDto<List<TravelInfo>> result = service.showAllExecutingTravelInfo();
		return result;
	}
	
	@RequestMapping(value="/user/showowntravelinfo",method=RequestMethod.POST)
	@ResponseBody
	ResultDto<List<TravelInfo>> showOwnTravelInfo(String username){
		Object[] params = {username};
		ResultDto<Object> result = CommonsUtil.getDecoderResult(params);
		if("no".equals(result.getSuccess())) {
			ResultDto<List<TravelInfo>> dto = new ResultDto<>();
			dto.setSuccess("no");
			dto.setErrMsg(result.getErrMsg());
			return dto;
		}
		ResultDto<List<TravelInfo>> res = service.showOwnTravelInfo((String)params[0]);
		return res;
	}
	
	@RequestMapping(value="/user/applyforoneactivity",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto<Object> applyForOneActivity(String leaderUsername,Integer leaderId,String memberUsername,Integer memberId,Integer activityId){
		Object[] params = {leaderUsername,memberUsername};
		ResultDto<Object> result = CommonsUtil.getDecoderResult(params);
		if("no".equals(result.getSuccess())) {
			ResultDto<Object> dto = new ResultDto<>();
			dto.setSuccess("no");
			dto.setErrMsg(result.getErrMsg());
			return dto;
		}
		TeamInfo info = new TeamInfo();
		info.setLeaderUsername((String)params[0]);
		info.setMemberUsername((String)params[1]);
		info.setActivityId(activityId);
		info.setLeaderId(leaderId);
		info.setMemberId(memberId);
		info.setFlag(0);
		info.setProcess(0);
		ResultDto<Object> result1 = service.applyForOneActivity(info);
		return result1;
	}
	
	@RequestMapping(value="/user/checkteamcondition",method=RequestMethod.POST)
	@ResponseBody
	ResultDto<List<TeamInfo>> checkTeamCondition(String leaderUsername,Integer leaderId,Integer activityId){
		Object[] params = {leaderUsername};
		ResultDto<Object> result = CommonsUtil.getDecoderResult(params);
		if("no".equals(result.getSuccess())) {
			ResultDto<List<TeamInfo>> dto = new ResultDto<>();
			dto.setSuccess("no");
			dto.setErrMsg(result.getErrMsg());
			return dto;
		}
		ResultDto<List<TeamInfo>> result1 = service.checkTeamCondition((String)params[0], leaderId, activityId);
		return result1;
	}
	
	@RequestMapping(value="/user/deletesomeapplication",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto<Object> deleteSomeApplication(String leaderUsername,Integer activityId,String memberUsername,Integer memberId){
		Object[] params = {memberUsername,leaderUsername};
		ResultDto<Object> result = CommonsUtil.getDecoderResult(params);
		if("no".equals(result.getSuccess())) {
			ResultDto<Object> dto = new ResultDto<>();
			dto.setSuccess("no");
			dto.setErrMsg(result.getErrMsg());
			return dto;
		}
		ResultDto<Object> result1 = service.deleteSomeApplication((String)params[1],activityId,(String)params[0], memberId);
		return result1;
	}
	
	@RequestMapping(value="/user/endapplication",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto<List<TeamInfo>> endApplication(String leaderUsername,Integer leaderId,Integer activityId){
		Object[] params = {leaderUsername};
		ResultDto<Object> result = CommonsUtil.getDecoderResult(params);
		if("no".equals(result.getSuccess())) {
			ResultDto<List<TeamInfo>> dto = new ResultDto<>();
			dto.setSuccess("no");
			dto.setErrMsg(result.getErrMsg());
			return dto;
		}
		ResultDto<List<TeamInfo>> result1 = service.endApplication(leaderUsername, leaderId, activityId);
		return result1;
	}
}
