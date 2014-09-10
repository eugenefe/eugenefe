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

@Entity
@Table(name = "ERBA06TB")
public class AlmAssetDuration implements java.io.Serializable {

	private AlmAssetDurationId id;
	private String assetNm;
	private Long bookAmt;
	private Long evalAmt;
	private BigDecimal evalYield;
	private BigDecimal durt;
//	private String procClerkNo;
//	private Serializable dbChngDttm;

	public AlmAssetDuration() {
	}

	public AlmAssetDuration(AlmAssetDurationId id) {
		this.id = id;
	}

	public AlmAssetDuration(AlmAssetDurationId id, String assetNm, Long bookAmt, Long evalAmt, BigDecimal evalYield, BigDecimal durt) {
		this.id = id;
		this.assetNm = assetNm;
		this.bookAmt = bookAmt;
		this.evalAmt = evalAmt;
		this.evalYield = evalYield;
		this.durt = durt;
//		this.procClerkNo = procClerkNo;
//		this.dbChngDttm = dbChngDttm;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "basDt", column = @Column(name = "BAS_DT", nullable = false, length = 8)),
			@AttributeOverride(name = "acntLcls", column = @Column(name = "ACNT_LCLS", nullable = false, length = 20)),
			@AttributeOverride(name = "acntMcls", column = @Column(name = "ACNT_MCLS", nullable = false, length = 20)),
			@AttributeOverride(name = "acntScls", column = @Column(name = "ACNT_SCLS", nullable = false, length = 20)),
			@AttributeOverride(name = "portseg", column = @Column(name = "PORTSEG", nullable = false, length = 20)),
			@AttributeOverride(name = "assetId", column = @Column(name = "ASSET_ID", nullable = false, length = 50)) })
	public AlmAssetDurationId getId() {
		return this.id;
	}

	public void setId(AlmAssetDurationId id) {
		this.id = id;
	}

	@Column(name = "ASSET_NM", length = 100)
	public String getAssetNm() {
		return this.assetNm;
	}

	public void setAssetNm(String assetNm) {
		this.assetNm = assetNm;
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

	@Column(name = "EVAL_YIELD", precision = 10, scale = 4)
	public BigDecimal getEvalYield() {
		return this.evalYield;
	}

	public void setEvalYield(BigDecimal evalYield) {
		this.evalYield = evalYield;
	}

	@Column(name = "DURT", precision = 10, scale = 4)
	public BigDecimal getDurt() {
		return this.durt;
	}

	public void setDurt(BigDecimal durt) {
		this.durt = durt;
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
