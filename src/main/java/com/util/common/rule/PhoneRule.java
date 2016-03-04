package com.util.common.rule;

import com.util.common.StringUtil;


public class PhoneRule extends Rule {
	
	public PhoneRule() {
		
	}
	
	@Override
	public boolean valid() throws Exception {
		if(this.getValue() == null || this.getValue().equals("")){
			return true;
		}else{
			if (StringUtil.isPhone(this.getValue())) {
				return true;
			}
			else {
				this.setMessage("err.param.numeric");
				return false;
			}
		}
	}

}
