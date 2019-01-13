package com.app.cn.util;

public class PathUtil {
	
	private static String seperator = System.getProperty("file.separator");
	/**
	 * 
	 * @return 图片在服务器上存储的根路径
	 */
	public static String getBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if(os.toLowerCase().startsWith("win")) {
			basePath = "E:/projectDev/teamapp/";
		}else {
			basePath = "/home/hcc/teamapp/image/";
		}
		basePath = basePath.replace("/", seperator);
		return basePath;
	}
	
}
