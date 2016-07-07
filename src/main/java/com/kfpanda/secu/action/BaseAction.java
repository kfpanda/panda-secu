package com.kfpanda.secu.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kfpanda.core.page.Pageable;

public class BaseAction {

	protected ResultDTO getResult(int result, Object data, String msg) {
		return new ResultDTO(result, data, msg);
	}
	protected ResultDTO getResult(int result, String msg) {
		return this.getResult(result, null, msg);
	}
	protected ResultDTO getResult() {
		return this.getResult(ErrorEnum.SUCC.getKey(), null, null);
	}
	protected ResultDTO getResult(Object data) {
		return this.getResult(ErrorEnum.SUCC.getKey(), data, null);
	}



	protected ResultDTO getResult(int result, Object data, String msg, Pageable page) {
		return new ResultDTO(result, data, msg, page);
	}
	protected ResultDTO getResult(Object data, Pageable page) {
		return new ResultDTO(ErrorEnum.SUCC.getKey(), data, null, page);
	}

	/**
	 * 根据错误码键，生成错误实体。
	 * @param error
	 * @return
     */
	protected ResultDTO getErrorResult(ErrorEnum error, String... params) {
		return new ResultDTO(error.getKey(), replaceContent(error.getValue(), params));
	}
	private static Pattern pattern = Pattern.compile("\\{\\}");
	//将字符串中的{}，替换为params中的值。
	protected String replaceContent(String content, String... params){
		Matcher matcher = pattern.matcher(content);
		StringBuffer sb = new StringBuffer();
		Integer idx = 0;
		while(matcher.find()) {
			if(params != null && idx < params.length) {
				matcher.appendReplacement(sb, params[idx++]);
			}else{
				//参数个数不匹配。
				return null;
			}
		}
		matcher.appendTail(sb);

		return sb.toString();
	}

	public List<String> newList(String[] objList) {
		List<String> list = new ArrayList<String>();
		for (String obj : objList) {
			list.add(obj);
		}
		return list;
	}
}