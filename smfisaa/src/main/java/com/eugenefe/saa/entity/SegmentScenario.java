package com.eugenefe.saa.entity;

// Generated Sep 10, 2014 4:21:17 AM by Hibernate Tools 4.0.0

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Erba11tb generated by hbm2java
 */
@Entity
@Table(name = "ERBA11TB" )
public class SegmentScenario implements java.io.Serializable {

	private SegmentScenarioId id;
	private Long snroEvalAmt;
	private Long evalAmt;
	private Long snroChngAmt;
//	private String procClerkNo;
//	private Serializable dbChngDttm;

	public SegmentScenario() {
	}

	public SegmentScenario(SegmentScenarioId id) {
		this.id = id;
	}

	public SegmentScenario(SegmentScenarioId id, Long snroEvalAmt, Long evalAmt, Long snroChngAmt, String procClerkNo,
			Serializable dbChngDttm) {
		this.id = id;
		this.snroEvalAmt = snroEvalAmt;
		this.evalAmt = evalAmt;
		this.snroChngAmt = snroChngAmt;
//		this.procClerkNo = procClerkNo;
//		this.dbChngDttm = dbChngDttm;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "basDt", column = @Column(name = "BAS_DT", nullable = false, length = 8)),
			@AttributeOverride(name = "segId", column = @Column(name = "SEG_ID", nullable = false, length = 20)),
			@AttributeOverride(name = "riskTypeCd", column = @Column(name = "RISK_TYPE_CD", nullable = false, length = 2)),
			@AttributeOverride(name = "snroNo", column = @Column(name = "SNRO_NO", nullable = false, precision = 10, scale = 0)) })
	public SegmentScenarioId getId() {
		return this.id;
	}

	public void setId(SegmentScenarioId id) {
		this.id = id;
	}

	@Column(name = "SNRO_EVAL_AMT", precision = 18, scale = 0)
	public Long getSnroEvalAmt() {
		return this.snroEvalAmt;
	}

	public void setSnroEvalAmt(Long snroEvalAmt) {
		this.snroEvalAmt = snroEvalAmt;
	}

	@Column(name = "EVAL_AMT", precision = 18, scale = 0)
	public Long getEvalAmt() {
		return this.evalAmt;
	}

	public void setEvalAmt(Long evalAmt) {
		this.evalAmt = evalAmt;
	}

	@Column(name = "SNRO_CHNG_AMT", precision = 18, scale = 0)
	public Long getSnroChngAmt() {
		return this.snroChngAmt;
	}

	public void setSnroChngAmt(Long snroChngAmt) {
		this.snroChngAmt = snroChngAmt;
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