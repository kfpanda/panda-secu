package com.util.common.rule;

import com.kfpanda.util.DateUtil;
import com.util.common.StringUtil;

public class DateValue extends Rule {
	public String formatStr="";
	public DateValue(String formatStr) {
		this.formatStr=formatStr;
	}
	public DateValue() {
    }
	@Override
	public boolean valid() throws Exception {
		if (StringUtil.isBlank(this.getValue())) {
			return true;
		}
			
		java.util.Date dtValue = DateUtil.parseToDateTry(this.getValue());
		
		if (dtValue == null) {
			this.setMessage("err.param.date");
			return false;
		}
		else {
			return true;
		}
	}

}
