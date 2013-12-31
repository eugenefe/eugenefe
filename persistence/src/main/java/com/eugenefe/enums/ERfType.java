package com.eugenefe.enums;


//@Name("rfType")
public enum ERfType {
	 IR ("IR")
	,EQ ("EQ")
	,FX	("FX")
	,CO	("CO")
	;
	
	private String type;
	
	private ERfType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
}
