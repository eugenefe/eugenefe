package com.eugenefe.mvfeed;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eugenefe.mvfeed.quandl.QDataset;
import com.eugenefe.mvfeed.quandl.QDatasetList;
import com.eugenefe.mvfeed.quandl.QuandlConnection;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import com.mashape.unirest.http.HttpResponse;

public class TestQuandl {
//	private static Loggerr logger = Logger.getLogger("MainTest");
//	private static Logger logger = Logger.getLogger(TestUnirest.class);
	
	private final static Logger logger = LoggerFactory.getLogger(TestQuandl.class);
	
//	private static Logger
	/**
	 * @param args
	 */
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException{
		
		getQuandlData();
	}
	
	public static void getQuandlData() {
		
		QuandlConnection q = new QuandlConnection("W6qxqMz1sZPZcG93SxS4");
//		QuandlConnection q = new QuandlConnection();
		
		QDataset data1 = q.getQDataset("GOOG/LON_LYUK");
		logger.info("Quandl : {},{}", data1.getColumn_names(), data1.getDescription());
		logger.info("Quandl : {},{}", data1.getDisplay_url(), data1.getData());
		
		QDatasetList dataList = q.getCodeQuery("LYUK");
		logger.info("Quandl2 : {},{}", dataList.getCurrent_page(), dataList.getTotal_count());
		
//		for( QDataSource zz : dataList.getSources()){
//			logger.info("Quandl2 : {}, {}",  zz.getName(), zz.getHost());
//			logger.info("Quandl2 : {}, {}",  zz.getDatasets_count(), zz.getDescription());
//		}
		for ( QDataset aa : dataList.getDocs()){
//			logger.info("Quandl2 : {}", aa.getData());
			logger.info("Quandl2 : {}, {}",  aa.getSource_code(), aa.getCode());
			logger.info("Quandl2 : {}, {}", aa.getColumn_names() );
		}
		
		/*
		QMultiset datamulti = q.getMultiData("GOOG.NASDAQ_GOOG.1,GOOG.NASDAQ_GOOG.4");
		logger.info("Quandl2 : {},{}", datamulti.getColumn_names());
		logger.info("Quandl2 : {},{}", datamulti.getData());*/
	}
	
	
	

}	
