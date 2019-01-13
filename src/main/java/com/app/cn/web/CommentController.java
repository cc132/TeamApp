package com.app.cn.web;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.cn.dto.ResultDto;
import com.app.cn.entity.DiscussionBeforeTravel;
import com.app.cn.service.CommentService;
import com.app.cn.util.PathUtil;

@Controller
public class CommentController {
	@Autowired
	private CommentService beforeService;

	@RequestMapping(value = "/user/commentbyfilebeforetravel", method = RequestMethod.POST)
	@ResponseBody
	public ResultDto<DiscussionBeforeTravel> commentBeforeTravel(Integer userId, String userName, Integer activityId,
			@RequestParam(value = "file") CommonsMultipartFile file) {
		DiscussionBeforeTravel info = new DiscussionBeforeTravel();
		ResultDto<DiscussionBeforeTravel> result = new ResultDto<>();
		info.setUserId(userId);
		info.setUsername(userName);
		info.setActivityId(activityId);

		String basePath = PathUtil.getBasePath();// 获取基本路径,
		String relativeFilePath = null;

		if (file != null) {
			String fileName = file.getOriginalFilename();
			relativeFilePath = "" + userId + new Date().getTime() + fileName;
			String finalVideoPath = basePath + relativeFilePath;
			File file1 = new File(finalVideoPath);
			if (!file1.exists()) {
				file1.mkdirs();
			}
			try {
				file.transferTo(file1);
			} catch (Exception e) {
				result.setSuccess("no");
				result.setErrMsg(e.toString());
				return result;
			}
		}
		info.setFilePath(relativeFilePath);
		try {
			beforeService.commentBeforeTravel(info);
			result.setSuccess("ok");
			result.setResult(info);
		} catch (Exception e) {
			result.setSuccess("no");
			result.setErrMsg(e.toString());
		}
		return result;
	}

	@RequestMapping(value = "/user/commentbywordbeforetravel", method = RequestMethod.POST)
	@ResponseBody
	public ResultDto<DiscussionBeforeTravel> commentBeforeTravel(Integer userId, String userName, Integer activityId,
			String words) {
		DiscussionBeforeTravel info = new DiscussionBeforeTravel();
		ResultDto<DiscussionBeforeTravel> result = new ResultDto<>();
		info.setUserId(userId);
		info.setUsername(userName);
		info.setActivityId(activityId);
		info.setWords(words);
		try {
			beforeService.commentBeforeTravel(info);
			result.setSuccess("ok");
			result.setResult(info);
		} catch (Exception e) {
			result.setSuccess("no");
			result.setErrMsg(e.toString());
		}
		return result;
	}
}
