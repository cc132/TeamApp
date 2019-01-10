package com.app.cn.util;


import java.util.Date;

import org.junit.Test;

public class UtilsTest {
	@Test
	public void testString2Date() throws Exception {
		String date = "2012-03-22 12:00:00";
		Date string2Date = CommonsUtil.String2Date(date);
		System.out.println(string2Date);
		System.out.println(new Date());
	}
	
	@Test
	public void testNetDecoder() throws Exception {
		Object[] params = {"南京南京","123456"};
		CommonsUtil.NetDecoder(params);
		for(int i = 0;i < params.length;i++) {
			System.out.println(params[i]);
		}
	}
}
