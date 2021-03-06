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
 * Erba26tb generated by hbm2java
 */
@Entity
@Table(name = "ERBA26TB")
public class OverallConstraints implements java.io.Serializable {

	private OverallConstraintsId id;
	private String calcExprCd;
	private BigDecimal leftHandVal;
	private BigDecimal rightHandVal;
	private BigDecimal applVal;
	private String useYn;
//	private String procClerkNo;
//	private Serializable dbChngDttm;

	public OverallConstraints() {
	}

	public OverallConstraints(OverallConstraintsId id) {
		this.id = id;
	}

	public OverallConstraints(OverallConstraintsId id, String calcExprCd, BigDecimal leftHandVal, BigDecimal rightHandVal,
			BigDecimal applVal, String useYn, String procClerkNo, Serializable dbChngDttm) {
		this.id = id;
		this.calcExprCd = calcExprCd;
		this.leftHandVal = leftHandVal;
		this.rightHandVal = rightHandVal;
		this.applVal = applVal;
		this.useYn = useYn;
//		this.procClerkNo = procClerkNo;
//		this.dbChngDttm = dbChngDttm;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "optMthdlId", column = @Column(name = "OPT_MTHDL_ID", nullable = false, length = 20)),
			@AttributeOverride(name = "lmtExprCd", column = @Column(name = "LMT_EXPR_CD", nullable = false, length = 10)) })
	public OverallConstraintsId getId() {
		return this.id;
	}

	public void setId(OverallConstraintsId id) {
		this.id = id;
	}

	@Column(name = "CALC_EXPR_CD", length = 10)
	public String getCalcExprCd() {
		return this.calcExprCd;
	}

	public void setCalcExprCd(String calcExprCd) {
		this.calcExprCd = calcExprCd;
	}

	@Column(name = "LEFT_HAND_VAL", precision = 20, scale = 6)
	public BigDecimal getLeftHandVal() {
		return this.leftHandVal;
	}

	public void setLeftHandVal(BigDecimal leftHandVal) {
		this.leftHandVal = leftHandVal;
	}

	@Column(name = "RIGHT_HAND_VAL", precision = 20, scale = 6)
	public BigDecimal getRightHandVal() {
		return this.rightHandVal;
	}

	public void setRightHandVal(BigDecimal rightHandVal) {
		this.rightHandVal = rightHandVal;
	}

	@Column(name = "APPL_VAL", precision = 20, scale = 6)
	public BigDecimal getApplVal() {
		return this.applVal;
	}

	public void setApplVal(BigDecimal applVal) {
		this.applVal = applVal;
	}

	@Column(name = "USE_YN", length = 1)
	public String getUseYn() {
		return this.useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
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
