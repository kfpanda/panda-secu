package com.util.common;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StringUtil {
	/**
	 * 获取异常堆栈信息
	 * @param e
	 * @return
	 */
	public static String getExceptionStackTrace(Exception e){
		StringWriter writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer,true));
		return writer.toString();
	}
}
