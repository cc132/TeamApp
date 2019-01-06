package com.app.cn.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.cn.dto.TravelInfoDto;
import com.app.cn.entity.TravelInfo;
import com.app.cn.service.TravelInfoService;
import com.app.cn.util.CommonsUtil;

@Controller
public class ActivitiesController {
	@Autowired
	private TravelInfoService service;
	
	@RequestMapping(value="/user/addtravelinfo",method=RequestMethod.POST)
	@ResponseBody
	public TravelInfoDto addTravelInfo(String username,String toWhere,String startTime,Integer num,String descInfo) {
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
		//==========
		return null;
	}
}
