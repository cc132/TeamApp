package com.app.cn.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.cn.BaseTest;
import com.app.cn.entity.DiscussionBeforeTravel;

public class CommentDaoTest extends BaseTest{
	@Autowired
	private CommentDao dao;
	
	@Test
	public void testDiscussionBeforeTravel() throws Exception {
		DiscussionBeforeTravel info = new DiscussionBeforeTravel();
		info.setUsername("张三");
		info.setUserId(1);
		info.setActivityId(1);
		info.setWords("hello 各位小伙伴");
		dao.discussionBeforeTravel(info);
		System.out.println(info.getId());
	}
}
