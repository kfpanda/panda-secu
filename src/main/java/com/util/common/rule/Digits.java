package com.util.common.rule;

import com.util.common.StringUtil;




public class Digits extends Rule {
	int integer=10;
	int fraction=0;
	public Digits() {
		
	}
public Digits(int integer,int fraction) {
		this.integer=integer;
		this.fraction=fraction;
	}
	@Override
	public boolean valid() throws Exception {
		if(this.getValue() == null || this.getValue().equals("")){
			return true;
		}else{
			if (StringUtil.checkFloat(this.value, integer, fraction)) {
				return true;
			}
			else {
				this.setMessage("err.param.float");
				return false;
			}
		}
	}

}
