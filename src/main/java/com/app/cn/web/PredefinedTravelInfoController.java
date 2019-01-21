package com.app.cn.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.cn.dto.ResultDto;
import com.app.cn.entity.PredefinedTravelInfo;
import com.app.cn.service.PredefinedTravelInfoService;
import com.app.cn.util.CommonsUtil;

@Controller
public class PredefinedTravelInfoController {
	@Autowired
	private PredefinedTravelInfoService service;
	
	@RequestMapping(value="/user/addpredefinedtravelinfo",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto<PredefinedTravelInfo> addPredefinedTravelInfo(String username,String activityName,String area,String specificLocation){
		Object[] params = {username,activityName,area,specificLocation};
		ResultDto<Object> result = CommonsUtil.getDecoderResult(params);
		if("no".equals(result.getSuccess())) {
			ResultDto<PredefinedTravelInfo> dto = new ResultDto<>();
			dto.setSuccess("no");
			dto.setErrMsg(result.getErrMsg());
			return dto;
		}
		PredefinedTravelInfo info = new PredefinedTravelInfo();
		info.setUsername((String)params[0]);
		info.setActivityName((String)params[1]);
		info.setArea((String)params[2]);
		info.setSpecificLocation((String)params[3]);
		ResultDto<PredefinedTravelInfo> result1 = service.addPredefinedTravelInfo(info);
		return result1;
	}
	
	@RequestMapping(value="/user/deletepredefinedtravelinfo",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto<String> deletePredefinedTravelInfo(Integer id){
		ResultDto<String> result = service.deletePredefinedTravelInfo(id);
		return result;
	}
	
	@RequestMapping(value="/user/updatepredefinedtravelinfo",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto<String> updatePredefinedTravelInfo(Integer id,String username,String activityName,String area,String specificLocation){
		Object[] params = {username,activityName,area,specificLocation};
		ResultDto<Object> result = CommonsUtil.getDecoderResult(params);
		if("no".equals(result.getSuccess())) {
			ResultDto<String> dto = new ResultDto<>();
			dto.setSuccess("no");
			dto.setErrMsg(result.getErrMsg());
			return dto;
		}
		PredefinedTravelInfo info = new PredefinedTravelInfo();
		info.setId(id);
		info.setUsername((String)params[0]);
		info.setActivityName((String)params[1]);
		info.setArea((String)params[2]);
		info.setSpecificLocation((String)params[3]);
		ResultDto<String> result1 = service.updatePredefinedTravelInfo(info);
		return result1;
	}
	
	@RequestMapping(value="/user/querypredefinedtravelinfo",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto<List<PredefinedTravelInfo>> queryPredefinedTravelInfos(String username){
		Object[] params = {username};
		ResultDto<Object> result = CommonsUtil.getDecoderResult(params);
		if("no".equals(result.getSuccess())) {
			ResultDto<List<PredefinedTravelInfo>> dto = new ResultDto<>();
			dto.setSuccess("no");
			dto.setErrMsg(result.getErrMsg());
			return dto;
		}
		ResultDto<List<PredefinedTravelInfo>> result1 = service.queryPredefinedTravelInfos((String)params[0]);
		return result1;
	}
}
