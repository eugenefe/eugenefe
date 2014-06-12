package com.eugenefe.mvfeed.old;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.http.entity.mime.MultipartEntity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eugenefe.mvfeed.krx.KrxBondType;
import com.eugenefe.mvfeed.util.MultipartUtility;

public class IsinMasterTestOld {
	private final static Logger logger = LoggerFactory
			.getLogger(IsinMasterTestOld.class);
	private static Properties properties = new Properties();

	public static void main(String[] args) {

		bondMasterTest();
		
//		aaa();
		// bondDivCdTest();
		// for ( KrxBondType aa : jsonTest()){
		// logger.info("Bond: {},{}", aa.getType(), aa.getTypeName());
		// logger.info("Bond: {},{}", aa.getDivType(), aa.getDivTypeName());
		// }
		// getKrxData();
	}

	private static List<KrxBondType> jsonTest() {
		Document doc;
		String type, typeName = null;
		String divType;
		Class klazz = KrxBondType.class;
		KrxBondType entity;
		List<KrxBondType> entityList = new ArrayList<KrxBondType>();
		try {
			properties.load(IsinMasterTestOld.class
					.getResourceAsStream("/url.properties"));
			logger.info("Master: {}", properties.getProperty("krxBondMaster"));

			doc = Jsoup.connect(properties.getProperty("krxBondMaster")).get();
			// .data("isu_id", "KR6029881283").post();

			Elements _types = doc
					.select("fieldset>table>tbody>tr>td>label, fieldset>table>tbody>tr>td>span");
			// logger.info("JSON: {}", _types);

			for (Element aa : _types) {
				// logger.info("JSON: {},{}", aa.tagName(), aa.text());
				if (aa.tagName().equals("label")) {
					typeName = aa.text();
					// entity.setTypeName(aa.text());
				} else if (aa.tagName().equals("span")) {
					for (Element bb : aa.children()) {
						if (bb.tagName().equals("select")) {
							// logger.info("JSON1111: {},{}", bb.attr("name"));
							type = bb.attr("name");
							// entity.setType(bb.attr("name"));
							// logger.info("JSON11: {},{}",
							// bb.select("option"));
							for (Element cc : bb.select("option")) {
								divType = cc.attr("value");
								if (divType != "") {
									// logger.info("JSON111: {},{}",
									// cc.attr("value"), cc.text());
									entity = new KrxBondType(type, typeName,
											divType, cc.text());
									entityList.add(entity);
								}
							}
						}

					}
				}
			}
			return entityList;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entityList;
	}

	private static void bondDivCdTest() {
		Document doc;
		String bondTypeCd;

		try {
			properties.load(IsinMasterTestOld.class
					.getResourceAsStream("/url.properties"));
			logger.info("Master: {}", properties.getProperty("krxBondMaster"));
			logger.info("Detail: {}", properties.getProperty("krxBondInfo"));

			// need http protocol
			doc = Jsoup.connect(properties.getProperty("krxBondMaster"))
					.timeout(1000000).get();
			// doc =
			// Jsoup.connect("http://www.krx.co.kr/por_kor/popup/JHPKOR13008_01.jsp").get();
			// logger.info("Html Size : {}", doc);
			// Elements _types =
			// doc.select("fieldset>table>tbody>tr>td>input[type=radio] ");
			Elements _types = doc.select("fieldset>table>tbody>tr>td ");
			// Elements _types =
			// doc.select("fieldset>table td >input[type =radio]") ;

			// JSONPObject json = (JSONPObject)new
			// XMLSerializer().read(_types.toString());

			// logger.info("JSON: {}", json);

			for (Element bondType : _types) {
				if (bondType.nodeName().equals("BondGubun")) {

				}
				// logger.info("Html Size : {}, {}", _types.size(),
				// bondType.toString());

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void bondMasterTest() {
		Document doc;

		try {
			properties.load(IsinMasterTestOld.class
					.getResourceAsStream("/url.properties"));
			logger.info("Master: {}", properties.getProperty("isinSearch"));
			// Connection conn =
			// Jsoup.connect(properties.getProperty("isinSearch"));
			// conn.method(method)

			// need http protocol
			doc = Jsoup	.connect(properties.getProperty("isinSearch"))
					// doc =
					// Jsoup.connect(properties.getProperty("isinSearchPopup"))
					// doc =
					// Jsoup.connect(properties.getProperty("isinSearchRst"))
					// doc =
					// Jsoup.connect("http://www.krx.co.kr/por_kor/popup/JHPKOR13008_01.jsp")
					// doc =
					// Jsoup.connect("http://www.krx.co.kr/por_kor/popup/JHPKOR05010_01.jsp")
					// .get();
					.data("curSh", "2")
					.data("searchRadio", "2")
//					 .data("hd_curDate", "20140510")
//					.data("hd_oneDate", "20140510")
//					.data("hd_threeDate", "20140310")
//					.data("hd_sixDate", "20140110")
//					.data("list_start_dd", "20140110")
//					.data("list_start_dd", "20140610")
					.data("std_cd_grnt_start_dd","20140513")
					.data("std_cd_grnt_end_dd","20140612")
					// .data("list_dd", "Y")
					.data("currentPage", "15")
					.timeout(100000000)
					// .userAgent("Mozilla")
					.userAgent("Chrome")
					// .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
					// .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.114 Safari/537.36")
					.post();

			// Elements _rows = doc.select("table[id = dataTb]> tbody>tr");
			// Elements _rows = doc.select(".type-00 list mt25 > tbody>tr");
			Elements _rows = doc.select("tr[name=dataTr]");
			logger.info("Table : {}", doc.toString());
			for (int i = 0; i < _rows.size(); i++) {
				logger.info("Table : {}", _rows.get(i));
			}
			// logger.info("Html Size : {},{}", _rows.size(), doc.toString());

			for (Element _row : _rows) {
				// System.out.println("Row11: "+ _row.childNodeSize());
				// for(Node _node : _row.childNodes()){
				// System.out.println("Row : "+ _node.nodeName());
				// }

				// logger.info("Row1: {}, {}", _row, _row.children().size());
				if (_row.children().size() == 4) {
					for (int i = 0; i < _row.children().size(); i = i + 2) {
						// _row.children().get(i).select("th:matchesOwn(?is)").remove();
						// _row.children().get(i+1).select("td:matchesOwn(?is)").remove();
						if (!_row.children().get(i).text().contains("\u00a0")) {
							;
							// if(
							// _row.children().get(i).text().replace("&nbsp;","")!=""){;
							logger.info("Row1: {}: {}", _row.children().get(i)
									.text(), _row.children().get(i + 1).text());
						}
					}
					for (Element _rowCont : _row.children()) {
						// logger.info("Row1: {}, {}", _rowCont.text());
					}
				}

				// System.out.println("Row : "+ _rowCont.nodeName());
			}

			// System.out.println("Row : "+ aa.children() );
			// Elements colName = aa.select("th[class != tac]");
			// if( colName.size()>0){
			// System.out.println("Row : "+ colName+ colValue );
			// }
			// Elements colValue = aa.select("td:eq(0)");
			// System.out.println("Row : "+ colValue);
			// System.out.println("Row : "+ colName +"_" + colValue);

			// }
			// get page title
			String title = doc.title();
			System.out.println("title : " + title);

			// get all links
			Elements links = doc.select("a[href]");
			for (Element link : links) {

				// get the value from href attribute
				// System.out.println("\nlink : " + link.attr("href"));
				// System.out.println("text : " + link.text());
				//
			}
			logger.info("text : {}", _rows.size());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void aaa() {
		String charset = "UTF-8";
		String requestURL = "http://isin.krx.co.kr/srch/srch.do?method=srchList";
		try {
			MultipartUtility multipart = new MultipartUtility(requestURL,charset);
//			multipart.addHeaderField("User-Agent", "CodeJava");
//			multipart.addHeaderField("Test-Header", "Header-Value");
			multipart.addFormField("curSh", "2");
			multipart.addFormField("hd_curDate", "20140610");
//			multipart.addFormField("hd_oneDate", "20140510");
//			multipart.addFormField("hd_threeDate", "20140310");
//			multipart.addFormField("hd_sixDate", "20140110");
			multipart.addFormField("list_start_dd", "20140110");
			multipart.addFormField("list_start_dd", "20140610");
//			multipart.addFormField("currentPage", "30");
			
			List<String> response = multipart.finish();
			System.out.println("SERVER REPLIED:");
			for (String line : response) {
				System.out.println(line);
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
	
	
	private static void apacheClient(){
		
	}
}
