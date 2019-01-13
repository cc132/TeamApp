package com.app.cn.service;

import com.app.cn.dto.ResultDto;
import com.app.cn.entity.DiscussionBeforeTravel;

public interface CommentService {
	
	//存储用户开始组队旅行之前的评论
	ResultDto<DiscussionBeforeTravel> commentBeforeTravel(DiscussionBeforeTravel info);
}
