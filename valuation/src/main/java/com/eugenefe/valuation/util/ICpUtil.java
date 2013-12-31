package com.eugenefe.valuation.util;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface ICpUtil extends Library{
	ICpUtil INSTANCE = (ICpUtil)Native.loadLibrary("cputil", ICpUtil.class);
	
	public String CodeToName(String code);
	public int isConnect();
}
