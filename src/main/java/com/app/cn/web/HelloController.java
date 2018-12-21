package com.app.cn.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.cn.entity.User;

@Controller
public class HelloController {
	private Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(value="hello",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> demoController(String username,String password) {
		Map<String,Object> modelMap = new HashMap<>();
		logger.debug("=====start=====");
		try {
			//具体业务编写
			//此处缩略。。。用字符串拼接代替
			User user = new User();
			user.setUsername(username+"测试");
			user.setPassword(password+"测试");
			modelMap.put("success", true);
			modelMap.put("msg", user);
		}catch(Exception e) {
			modelMap.put("success", false);
			modelMap.put("msg", e.toString());
		}
		logger.debug("=====end=====");
		return modelMap;
	}
}
