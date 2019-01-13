package com.app.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.cn.dao.PersonInfoDao;
import com.app.cn.dto.ResultDto;
import com.app.cn.entity.PersonInfo;
import com.app.cn.service.PersonInfoService;

@Service
public class PersonInfoServiceImpl implements PersonInfoService{
	@Autowired
	private PersonInfoDao dao;
	
	public ResultDto<PersonInfo> addPersonInfo(PersonInfo info) {
		ResultDto<PersonInfo> dto = null;
		int effectedRow=dao.addPersonInfo(info);
		if(effectedRow != 1) {
			dto = new ResultDto<>();
			dto.setSuccess("no");
			dto.setErrMsg("插入个人信息失败");
			return dto;
		}
		dto = new ResultDto<>();
		dto.setSuccess("ok");
		dto.setResult(info);
		return dto;
	}

	@Override
	@Transactional
	public ResultDto<PersonInfo> updatePersonInfo(PersonInfo info) {
		ResultDto<PersonInfo> dto = new ResultDto<>();
		try {
			dao.updatePersonInfo(info);
			dto.setSuccess("ok");
			dto.setResult(info);
		}catch(Exception e) {
			dto.setSuccess("no");
			dto.setErrMsg(e.toString());
		}
		return dto;
	}

	@Override
	public ResultDto<PersonInfo> queryPersonInfo(String username) {
		ResultDto<PersonInfo> dto = new ResultDto<>();
		try {
			PersonInfo info = dao.queryPersonInfo(username);
			dto.setSuccess("ok");
			dto.setResult(info);
		}catch(Exception e) {
			dto.setSuccess("no");
			dto.setErrMsg(e.toString());
		}
		return dto;
	}

}
