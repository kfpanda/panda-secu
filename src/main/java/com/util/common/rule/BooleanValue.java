package com.util.common.rule;


public class BooleanValue extends Rule {
	
	@Override
	public boolean valid() throws Exception {
        if (this.getValue() == null) {
            return true;
        }

		if (this.getValue() != null && 
				(this.getValue().equalsIgnoreCase(Boolean.TRUE.toString()) 
						|| this.getValue().equalsIgnoreCase(Boolean.FALSE.toString()))){
			return true;
		}
		else {
			this.setMessage("err.param.boolean");
			return false;			
		}
	
	}
}
