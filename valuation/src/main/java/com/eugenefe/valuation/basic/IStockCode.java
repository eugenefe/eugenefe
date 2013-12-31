package com.eugenefe.valuation.basic;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface IStockCode extends Library {
	IStockCode INSTANCE = (IStockCode)Native.loadLibrary("cputil", IStockCode.class);
	
	public String CodeToName(String code);
	public int IsConnect();
}
