package com.eugenefe.mvfeed;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.proxy.annotation.SetDelegate;

import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eugenefe.entity.Basedate;
import com.eugenefe.entity.QDataMaster;
import com.eugenefe.entity.QFutures;
import com.eugenefe.mvfeed.quandl.QConnection;
import com.eugenefe.mvfeed.quandl.QDataset;
import com.eugenefe.mvfeed.quandl.QDatasetList;
import com.eugenefe.util.HibernateUtil;
import com.mysql.jdbc.Blob;

public class TestQDataMaster {
	private final static Logger logger = LoggerFactory.getLogger(TestQDataMaster.class);
	private final static String authToken = "W6qxqMz1sZPZcG93SxS4";
	private final static String fileName = "/home/takion77/Dev/qcode.txt";
	
	public static void main(String[] args) {
//		setTable();
//		viewTable();
//		String source = "OFDP";
//		String qCode ="FUTURE_C1";
//		setQDataMaster(source, qCode);

		String searchString = "ETF";
		int max = 3656;
		int stIndex = 1;
		int maxIndex = stIndex +1000;
//		
		for(int i =stIndex ; i<maxIndex; i++){
			setQDataMaster(searchString, i);
		}
		
//		setQDataMasterFile(fileName);
		
//		for (String aa : getQcodeFromFile(fileName)){
//			logger.info("QCode:{}", aa);
//		}
	}
	
	public static void viewTable() {
		String hql = " from QDataMaster a ";
		logger.info("query :{}", hql);
		for (QDataMaster zz : getQueryResult(hql)) {
			logger.info("Data List :{},{}", zz.getqCode(), zz.getqSourceCode());
		}
	}

	public static void setQDataMaster(String searchString){
		setQDataMaster(convertFromQDataset(getQuandlQuery(searchString)));
	}
	
	public static void setQDataMaster(String searchString, int pageNo){
		setQDataMaster(convertFromQDataset(getQuandlQuery(searchString, pageNo)));
	}
	
	public static void setQDataMasterFile(String fileName){
		List<QDataset> rst = new ArrayList<QDataset>();
		for(String aa : getQcodeFromFile(fileName)){
			rst.add(getQDataset(aa));
			setQDataMaster(convertFromQDataset(rst));
		}
		
	}
	public static void setQDataMaster(String sourceCode, String code){
		String qCode = sourceCode+"/" + code;
		List<QDataset> rst = new ArrayList<QDataset>();
//		QDataset zz = getQDataset(qCode);
//		logger.info("Set: {},{}", zz.getColumn_names(), zz.getName());
		rst.add(getQDataset(qCode));
		
		setQDataMaster(convertFromQDataset(rst));
		
	}
	
	
	
	public static void setQDataMaster(List<QDataMaster> qList){
		Session s = HibernateUtil.currentSession();
		Transaction tx = s.beginTransaction();
		int cnt = 0;
		logger.info("Size : {}", qList.size());
		if(qList.size()>0){
			for(QDataMaster aa : qList){
				s.saveOrUpdate(aa);
				cnt =cnt +1;
			}
			if(cnt % 200==0){
				s.flush();
				s.clear();
			}
		}
		tx.commit();
	}
	
	public static QDataset getQDataset(String qCode){
		List<QDataset> rst = new ArrayList<QDataset>();
		QConnection q = new QConnection();
		return q.getQDataset(authToken, qCode);
	}
		
	public static List<QDataset> getQuandlQuery(String searchString){
		List<QDataset> rst = new ArrayList<QDataset>();
		QConnection q = new QConnection();
		QDatasetList dataList = q.getCodeQuery(authToken,searchString);
		
		int totalSize = dataList.getTotal_count();
		int totalPageNo = dataList.getTotal_count() / 20 + 1;
		for (int i = 1; i <= totalPageNo; i++) {
//			logger.info("Quandl1111 : {}, {}");
			dataList = q.getCodeQuery(authToken, searchString, i);
			rst.addAll(dataList.getDocs());
		}
		return rst;
	}
	
	public static List<QDataset> getQuandlQuery(String searchString, int pageNo){
		QConnection q = new QConnection();
		QDatasetList dataList = q.getCodeQuery(authToken,searchString, pageNo);
		return dataList.getDocs();
	}
	
	public static List<String> getQcodeFromFile(String fileName){
		List<String> rst = new ArrayList<String>();
		Reader in = null;
		BufferedReader bin = null;
		try{
			in = new FileReader(fileName);
			bin = new BufferedReader(in);
			while(true){
				String temp = bin.readLine();
				if(temp != null && temp!= "\r\n"){
//					logger.info("AAA:{}", temp);
					rst.add(temp);
				}else {
					break;
				}
			}
			bin.close();
			return rst;
		} catch(Exception e){
			
		}
		return rst;		
	}
	
	private static List<QDataMaster> getQueryResult(String hql) {
		Session s = HibernateUtil.currentSession();
		Query qr = s.createQuery(hql);
		
		return qr.list();
	}
	private static List<QDataMaster> convertFromQDataset(List<QDataset> qSetList){
		List<QDataMaster> rst =new ArrayList<QDataMaster>();
		QDataMaster temp ;
				
		for(QDataset aa : qSetList){
//			if(aa.getSource_code().equals("OFDP")){
			temp = new QDataMaster();
			temp.setqId(aa.getId());
			temp.setqCode(aa.getCode());
			temp.setqSourceCode(aa.getSource_code());
			temp.setqName(aa.getName());
			temp.setFrequency(aa.getFrequency());
			temp.setqType(aa.getType());
			temp.setFromDate(aa.getFrom_date());
			temp.setToDate(aa.getTo_date());
			temp.setUrl(aa.getUrlize_name());
			temp.setUrlQuery(aa.getUrlize_name());
			temp.setColumns(aa.getColumn_names().toString());
			temp.setDescription(aa.getDescription());
			rst.add(temp);
//			}
		}
		return rst;
	}
}

	