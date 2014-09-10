package com.eugenefe.saa.entity;

// Generated Sep 10, 2014 4:21:17 AM by Hibernate Tools 4.0.0

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Erba07tb generated by hbm2java
 */
@Entity
@Table(name = "ERBA07TB")
public class Benchmark implements java.io.Serializable {

	private String bmkId;
	private String bmkNm;
	private String bmkTypeCd;
//	private String procClerkNo;
//	private Serializable dbChngDttm;

	public Benchmark() {
	}

	public Benchmark(String bmkId) {
		this.bmkId = bmkId;
	}

	public Benchmark(String bmkId, String bmkNm, String bmkTypeCd) {
		this.bmkId = bmkId;
		this.bmkNm = bmkNm;
		this.bmkTypeCd = bmkTypeCd;
//		this.procClerkNo = procClerkNo;
//		this.dbChngDttm = dbChngDttm;
	}

	@Id
	@Column(name = "BMK_ID", unique = true, nullable = false, length = 20)
	public String getBmkId() {
		return this.bmkId;
	}

	public void setBmkId(String bmkId) {
		this.bmkId = bmkId;
	}

	@Column(name = "BMK_NM", length = 100)
	public String getBmkNm() {
		return this.bmkNm;
	}

	public void setBmkNm(String bmkNm) {
		this.bmkNm = bmkNm;
	}

	@Column(name = "BMK_TYPE_CD", length = 10)
	public String getBmkTypeCd() {
		return this.bmkTypeCd;
	}

	public void setBmkTypeCd(String bmkTypeCd) {
		this.bmkTypeCd = bmkTypeCd;
	}

//	@Column(name = "PROC_CLERK_NO", length = 10)
//	public String getProcClerkNo() {
//		return this.procClerkNo;
//	}
//
//	public void setProcClerkNo(String procClerkNo) {
//		this.procClerkNo = procClerkNo;
//	}
//
//	@Column(name = "DB_CHNG_DTTM")
//	public Serializable getDbChngDttm() {
//		return this.dbChngDttm;
//	}
//
//	public void setDbChngDttm(Serializable dbChngDttm) {
//		this.dbChngDttm = dbChngDttm;
//	}

}
