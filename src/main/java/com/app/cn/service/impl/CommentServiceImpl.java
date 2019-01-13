package com.app.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cn.dao.CommentDao;
import com.app.cn.dto.ResultDto;
import com.app.cn.entity.DiscussionBeforeTravel;
import com.app.cn.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentDao beforeDao;
	
	@Override
	public ResultDto<DiscussionBeforeTravel> commentBeforeTravel(DiscussionBeforeTravel info) {
		ResultDto<DiscussionBeforeTravel> res = new ResultDto<>();
		
		//此处只是保存相关信息,具体文件存储在controller层进行处理
		beforeDao.discussionBeforeTravel(info);
		res.setSuccess("ok");
		res.setResult(info);
		return res;
	}

}
