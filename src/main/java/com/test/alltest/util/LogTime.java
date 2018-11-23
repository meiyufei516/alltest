package com.test.alltest.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author MeiYF
 * @time 2018/11/21 14:06
 **/
public class LogTime {

	/**
	 * 获取日志时间
	 * @return
	 */
	public static String getLogTime(){
		Date d=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String loggerTime = sdf.format(d);
		return loggerTime;
	}
}
