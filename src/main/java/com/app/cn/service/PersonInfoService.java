package com.app.cn.service;

import com.app.cn.dto.ResultDto;
import com.app.cn.entity.PersonInfo;

public interface PersonInfoService {
	ResultDto<PersonInfo> addPersonInfo(PersonInfo info);
}
