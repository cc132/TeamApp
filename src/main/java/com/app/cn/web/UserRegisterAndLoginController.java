package com.app.cn.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.cn.dto.ResultDto;
import com.app.cn.dto.UserDto;
import com.app.cn.entity.User;
import com.app.cn.service.UserDaoService;
import com.app.cn.util.CommonsUtil;

@Controller
public class UserRegisterAndLoginController {
	@Autowired
	private UserDaoService service;
	
	@RequestMapping(value="/user/register",method=RequestMethod.POST)
	@ResponseBody
	public UserDto registerUser(String username,String password) {
		//字符转换
		Object[] params = {username,password};
		ResultDto<Object> result = CommonsUtil.getDecoderResult(params);
		if("no".equals(result.getSuccess())) {
			UserDto dto = new UserDto();
			dto.setSuccess("no");
			dto.setErrMsg(result.getErrMsg());
			return dto;
		}
		User user = new User();
		user.setUsername((String)params[0]);
		user.setPassword((String)params[1]);
		UserDto addUser = service.addUser(user);
		return addUser;
	}
	
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	@ResponseBody
	public UserDto loginUser(String username,String password) {
		Object[] params = {username,password};
		ResultDto<Object> result = CommonsUtil.getDecoderResult(params);
		if("no".equals(result.getSuccess())) {
			UserDto dto = new UserDto();
			dto.setSuccess("no");
			dto.setErrMsg(result.getErrMsg());
			return dto;
		}
		User user = new User();
		user.setUsername((String)params[0]);
		user.setPassword((String)params[1]);
		UserDto addUser = service.queryOneUser(user);
		return addUser;
	}
}
