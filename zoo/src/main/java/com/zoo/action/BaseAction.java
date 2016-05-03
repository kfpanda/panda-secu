package com.zoo.action;
import com.awifi.core.page.Page;
import com.zoo.bean.ResultDTO;

public class BaseAction  {
    
	
	protected ResultDTO getResult(int result, String msg){
		return new ResultDTO(result, msg);
    }
	protected ResultDTO getResult(int result, String msg, Page page){
		return new ResultDTO(result, msg, page);
    }
}