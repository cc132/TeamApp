package com.app.cn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.cn.dto.ResultDto;
import com.app.cn.entity.PersonInfo;
import com.app.cn.service.PersonInfoService;
import com.app.cn.util.CommonsUtil;

@Controller
public class UserInfoController {

	@Autowired
	private PersonInfoService personInfoService;
	
	@RequestMapping(value="/user/querypersoninfo",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto<PersonInfo> queryPersonInfo(String username){
		//字符转换
		Object[] params = {username};
		ResultDto<Object> result = CommonsUtil.getDecoderResult(params);
		if("no".equals(result.getSuccess())) {
			ResultDto<PersonInfo> dto = new ResultDto<>();
			dto.setSuccess("no");
			dto.setErrMsg(result.getErrMsg());
			return dto;
		}
		ResultDto<PersonInfo> queryPersonInfo = personInfoService.queryPersonInfo((String)params[0]);
		return queryPersonInfo;
	}
	
	@RequestMapping(value="/user/updatepersoninfo",method=RequestMethod.POST)
	@ResponseBody
	public ResultDto<PersonInfo> updatePersonInfo(String username,Integer age,Integer gender,String schoolArea){
		//字符转换
		Object[] params = {username,schoolArea};
		ResultDto<Object> result = CommonsUtil.getDecoderResult(params);
		if("no".equals(result.getSuccess())) {
			ResultDto<PersonInfo> dto = new ResultDto<>();
			dto.setSuccess("no");
			dto.setErrMsg(result.getErrMsg());
			return dto;
		}
		PersonInfo info = new PersonInfo();
		info.setUsername((String)params[0]);
		info.setAge(age);
		info.setGender(gender);
		info.setSchoolArea((String)params[1]);
		ResultDto<PersonInfo> updatePersonInfo = personInfoService.updatePersonInfo(info);
		return updatePersonInfo;
	}
}
