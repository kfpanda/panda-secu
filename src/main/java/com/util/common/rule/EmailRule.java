package com.util.common.rule;

import com.util.common.StringUtil;



public class EmailRule extends Rule {
	
	public EmailRule() {
		
	}
	
	@Override
	public boolean valid() throws Exception {
		if(this.getValue() == null || this.getValue().equals("")){
			return true;
		}else{
			if (StringUtil.isEmail(this.getValue())) {
				return true;
			}
			else {
				this.setMessage("err.param.format.email");
				return false;
			}
		}
	}

}
