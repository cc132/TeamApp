package com.app.cn.util;

import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.app.cn.dto.ResultDto;

public class CommonsUtil {
	public static String Date2String(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	public static Date String2Date(String time) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	//将网络字符串转化成utf-8编码的字符串
	public static void NetDecoder(Object...params) throws Exception{
		for(int i = 0;i < params.length;i++) {
			params[i] =URLDecoder.decode((String) params[i], "UTF-8");
		}
	}
	
	public static ResultDto<Object> getDecoderResult(Object...params){
		ResultDto<Object> dto = new ResultDto<>();
		dto.setSuccess("ok");
		try {
			NetDecoder(params);
		}catch(Exception e) {
			dto.setSuccess("no");
			dto.setErrMsg(e.toString());
		}
		return dto;
	}
	
}
