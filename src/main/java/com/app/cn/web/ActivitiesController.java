package com.app.cn.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.cn.dto.ResultDto;
import com.app.cn.dto.TravelInfoDto;
import com.app.cn.entity.PersonInfo;
import com.app.cn.entity.PredefinedTravelInfo;
import com.app.cn.entity.TravelInfo;
import com.app.cn.service.PersonInfoService;
import com.app.cn.service.PredefinedTravelInfoService;
import com.app.cn.service.TravelInfoService;
import com.app.cn.util.CommonsUtil;

@Controller
public class ActivitiesController {
	@Autowired
	private TravelInfoService service;
	@Autowired
	private PersonInfoService personInfoService;
	@Autowired
	private PredefinedTravelInfoService predefinedTravelInfoService;
	
	@RequestMapping(value="/user/addtravelinfo",method=RequestMethod.POST)
	@ResponseBody
	public TravelInfoDto addTravelInfo(String username,String toWhere,String startTime,Integer num,String descInfo) {
		Object[] params = {username,toWhere,startTime,num,descInfo};
		ResultDto<Object> result = CommonsUtil.getDecoderResult(params);
		if("no".equals(result.getSuccess())) {
			TravelInfoDto dto = new TravelInfoDto();
			dto.setSuccess("no");
			dto.setErrMsg(result.getErrMsg());
			return dto;
		}
		TravelInfoDto dto = null;
		Date date = CommonsUtil.String2Date(startTime);
		if(date == null) {
			dto = new TravelInfoDto();
			dto.setSuccess("no");
			dto.setErrMsg("时间格式解析错误");
			return dto;
		}
		TravelInfo info = new TravelInfo();
		info.setUsername(username);
		info.setToWhere(toWhere);
		info.setStartTime(date);
		info.setPeopleNum(num);
		info.setDescInfo(descInfo);
		dto = service.addTravelInfo(info);
		dto.setData(info);
		dto.setSuccess("ok");
		return dto;
	}
	
	@RequestMapping(value="/user/addpersoninfo",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto<PersonInfo> addPersonInfo(String username,Integer age,Integer gender,String schoolArea){
		//格式化判断
		Object[] params = {username,age,gender,schoolArea};
		ResultDto<Object> tempResult = CommonsUtil.getDecoderResult(params);
		if("no".equals(tempResult.getSuccess())) {
			ResultDto<PersonInfo> dto = new ResultDto<>();
			dto.setSuccess("no");
			dto.setErrMsg(tempResult.getErrMsg());
			return dto;
		}
		
		PersonInfo info = new PersonInfo();
		info.setUsername(username);
		info.setAge(age);
		info.setGender(gender);
		info.setSchoolArea(schoolArea);
		ResultDto<PersonInfo> result = personInfoService.addPersonInfo(info);
		return result;
	}
	
	@RequestMapping(value="/user/addpredefinedtravelinfo",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto<PredefinedTravelInfo> addPredefinedTravelInfo(String username,String activityName,String area,String specificLocation){
		Object params[]= {username,activityName,area,specificLocation};
		//使用异常机制重构下！！！
		ResultDto<Object> tempResult = CommonsUtil.getDecoderResult(params);
		if("no".equals(tempResult.getSuccess())) {
			ResultDto<PredefinedTravelInfo> dto = new ResultDto<>();
			dto.setSuccess("no");
			dto.setErrMsg(tempResult.getErrMsg());
			return dto;
		}
		PredefinedTravelInfo info = new PredefinedTravelInfo();
		info.setUsername(username);
		info.setActivityName(activityName);
		info.setArea(area);
		info.setSpecificLocation(specificLocation);
		ResultDto<PredefinedTravelInfo> result = predefinedTravelInfoService.addPredefinedTravelInfo(info);
		
		return result;
	}
	
}
