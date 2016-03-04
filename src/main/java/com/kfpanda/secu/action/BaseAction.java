package com.kfpanda.secu.action;

import java.util.ArrayList;
import java.util.List;

import com.util.common.error.ErrorMessage;

public class BaseAction {

	protected ResultDTO getResult() {
		return this.getResult(0, null, null);
	}

	protected ResultDTO getResult(int result) {
		return this.getResult(result, null, null);
	}

	protected ResultDTO getResult(Object data) {
		return this.getResult(data, null);
	}

	protected ResultDTO getResult(Object data, String msg) {
		return this.getResult(0, data, msg);
	}

	protected ResultDTO getResult(int result, String msg) {
		return this.getResult(result, null, msg);
	}

	/**
	 * 根据错误码键，生成错误实体。
	 * 
	 * @param errorMsgKey
	 * @return
	 */
	protected ResultDTO getErrorResult(String errorMsgKey) {
		return new ResultDTO(ErrorMessage.getErrorMsgCode(errorMsgKey), null,
				ErrorMessage.getErrorMsg(errorMsgKey));
	}

/*	*//**
	 * @param result
	 * @return
	 *//*
	protected ResultDTO getResult(ResultDTO result) {
		if (result.getMsgKey() != null) {
			result.setMsg(ErrorMessage.getErrorMsg(result.getMsgKey()));
			result.setR(ErrorMessage.getErrorMsgCode(result.getMsgKey()));
			result.setMsgKey(null);
		}
		return result;
	}*/

	protected ResultDTO getResult(int result, Object data, String msg) {
		return new ResultDTO(result, data, msg);
	}

	/*protected ResultDTO getResult(Object data, int totalPage, long totalElem) {
		return this.getResult(0, data, null, totalPage, totalElem);
	}*/

	/*protected ResultDTO getResult(int result, Object data, String msg,
			int totalPage, long totalElem) {
		return new ResultDTO(result, data, msg, totalPage, totalElem);
	}*/

	public List<String> newList(String[] objList) {
		List<String> list = new ArrayList<String>();
		for (String obj : objList) {
			list.add(obj);
		}
		return list;
	}
}