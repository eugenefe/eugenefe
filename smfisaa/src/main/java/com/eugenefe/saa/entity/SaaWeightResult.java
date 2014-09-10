package com.eugenefe.saa.entity;

// Generated Sep 10, 2014 4:21:17 AM by Hibernate Tools 4.0.0

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Erba29tb generated by hbm2java
 */
@Entity
@Table(name = "ERBA29TB")
public class SaaWeightResult implements java.io.Serializable {

	private SaaWeightResultId id;
	private Long bookAmt;
	private Long evalAmt;
	private Long optDtbnBookAmt;
	private BigDecimal bookAmtChngRate;
//	private String procClerkNo;
//	private Serializable dbChngDttm;

	public SaaWeightResult() {
	}

	public SaaWeightResult(SaaWeightResultId id) {
		this.id = id;
	}

	public SaaWeightResult(SaaWeightResultId id, Long bookAmt, Long evalAmt
								, Long optDtbnBookAmt, BigDecimal bookAmtChngRate) {
		this.id = id;
		this.bookAmt = bookAmt;
		this.evalAmt = evalAmt;
		this.optDtbnBookAmt = optDtbnBookAmt;
		this.bookAmtChngRate = bookAmtChngRate;
//		this.procClerkNo = procClerkNo;
//		this.dbChngDttm = dbChngDttm;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "basDt", column = @Column(name = "BAS_DT", nullable = false, length = 8)),
			@AttributeOverride(name = "optMthdlId", column = @Column(name = "OPT_MTHDL_ID", nullable = false, length = 20)),
			@AttributeOverride(name = "segId", column = @Column(name = "SEG_ID", nullable = false, length = 20)) })
	public SaaWeightResultId getId() {
		return this.id;
	}

	public void setId(SaaWeightResultId id) {
		this.id = id;
	}

	@Column(name = "BOOK_AMT", precision = 18, scale = 0)
	public Long getBookAmt() {
		return this.bookAmt;
	}

	public void setBookAmt(Long bookAmt) {
		this.bookAmt = bookAmt;
	}

	@Column(name = "EVAL_AMT", precision = 18, scale = 0)
	public Long getEvalAmt() {
		return this.evalAmt;
	}

	public void setEvalAmt(Long evalAmt) {
		this.evalAmt = evalAmt;
	}

	@Column(name = "OPT_DTBN_BOOK_AMT", precision = 18, scale = 0)
	public Long getOptDtbnBookAmt() {
		return this.optDtbnBookAmt;
	}

	public void setOptDtbnBookAmt(Long optDtbnBookAmt) {
		this.optDtbnBookAmt = optDtbnBookAmt;
	}

	@Column(name = "BOOK_AMT_CHNG_RATE", precision = 10, scale = 4)
	public BigDecimal getBookAmtChngRate() {
		return this.bookAmtChngRate;
	}

	public void setBookAmtChngRate(BigDecimal bookAmtChngRate) {
		this.bookAmtChngRate = bookAmtChngRate;
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