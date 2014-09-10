package com.eugenefe.saa.entity;

// Generated Sep 10, 2014 4:21:17 AM by Hibernate Tools 4.0.0

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Erba01tb generated by hbm2java
 */
@Entity
@Table(name = "ERBA01TB")
public class SaaSegment implements java.io.Serializable {

	private String segId;
	private String segNm;
	private String segGroupId;
	private String segMouCd;
	private String leafYn;
	private String bmkId;
	private BigDecimal bmkSpread;
	private String exprCls;
	private String crdtOrdCd;
	private String exprSctnCd;
	private String crdtGrdSctnCd;
	private String preordYn;
	private BigDecimal exstInvWght;

	// private String procClerkNo;
	// private Serializable dbChngDttm;

	public SaaSegment() {
	}

	public SaaSegment(String segId) {
		this.segId = segId;
	}

	public SaaSegment(String segId, String segNm, String segGroupId, String segMouCd, String leafYn, String bmkId,
			BigDecimal bmkSpread, String exprCls, String crdtOrdCd, String exprSctnCd, String crdtGrdSctnCd,
			String preordYn, BigDecimal exstInvWght, String procClerkNo) {
		this.segId = segId;
		this.segNm = segNm;
		this.segGroupId = segGroupId;
		this.segMouCd = segMouCd;
		this.leafYn = leafYn;
		this.bmkId = bmkId;
		this.bmkSpread = bmkSpread;
		this.exprCls = exprCls;
		this.crdtOrdCd = crdtOrdCd;
		this.exprSctnCd = exprSctnCd;
		this.crdtGrdSctnCd = crdtGrdSctnCd;
		this.preordYn = preordYn;
		this.exstInvWght = exstInvWght;
		// this.procClerkNo = procClerkNo;
		// this.dbChngDttm = dbChngDttm;
	}

	@Id
	@Column(name = "SEG_ID", unique = true, nullable = false, length = 20)
	public String getSegId() {
		return this.segId;
	}

	public void setSegId(String segId) {
		this.segId = segId;
	}

	@Column(name = "SEG_NM", length = 100)
	public String getSegNm() {
		return this.segNm;
	}

	public void setSegNm(String segNm) {
		this.segNm = segNm;
	}

	@Column(name = "SEG_GROUP_ID", length = 20)
	public String getSegGroupId() {
		return this.segGroupId;
	}

	public void setSegGroupId(String segGroupId) {
		this.segGroupId = segGroupId;
	}

	@Column(name = "SEG_MOU_CD", length = 10)
	public String getSegMouCd() {
		return this.segMouCd;
	}

	public void setSegMouCd(String segMouCd) {
		this.segMouCd = segMouCd;
	}

	@Column(name = "LEAF_YN", length = 1)
	public String getLeafYn() {
		return this.leafYn;
	}

	public void setLeafYn(String leafYn) {
		this.leafYn = leafYn;
	}

	@Column(name = "BMK_ID", length = 20)
	public String getBmkId() {
		return this.bmkId;
	}

	public void setBmkId(String bmkId) {
		this.bmkId = bmkId;
	}

	@Column(name = "BMK_SPREAD", precision = 8, scale = 4)
	public BigDecimal getBmkSpread() {
		return this.bmkSpread;
	}

	public void setBmkSpread(BigDecimal bmkSpread) {
		this.bmkSpread = bmkSpread;
	}

	@Column(name = "EXPR_CLS", length = 10)
	public String getExprCls() {
		return this.exprCls;
	}

	public void setExprCls(String exprCls) {
		this.exprCls = exprCls;
	}

	@Column(name = "CRDT_ORD_CD", length = 10)
	public String getCrdtOrdCd() {
		return this.crdtOrdCd;
	}

	public void setCrdtOrdCd(String crdtOrdCd) {
		this.crdtOrdCd = crdtOrdCd;
	}

	@Column(name = "EXPR_SCTN_CD", length = 10)
	public String getExprSctnCd() {
		return this.exprSctnCd;
	}

	public void setExprSctnCd(String exprSctnCd) {
		this.exprSctnCd = exprSctnCd;
	}

	@Column(name = "CRDT_GRD_SCTN_CD", length = 10)
	public String getCrdtGrdSctnCd() {
		return this.crdtGrdSctnCd;
	}

	public void setCrdtGrdSctnCd(String crdtGrdSctnCd) {
		this.crdtGrdSctnCd = crdtGrdSctnCd;
	}

	@Column(name = "PREORD_YN", length = 1)
	public String getPreordYn() {
		return this.preordYn;
	}

	public void setPreordYn(String preordYn) {
		this.preordYn = preordYn;
	}

	@Column(name = "EXST_INV_WGHT", precision = 10, scale = 4)
	public BigDecimal getExstInvWght() {
		return this.exstInvWght;
	}

	public void setExstInvWght(BigDecimal exstInvWght) {
		this.exstInvWght = exstInvWght;
	}
	// @Column(name = "PROC_CLERK_NO", length = 10)
	// public String getProcClerkNo() {
	// return this.procClerkNo;
	// }
	// public void setProcClerkNo(String procClerkNo) {
	// this.procClerkNo = procClerkNo;
	// }
	// @Column(name = "DB_CHNG_DTTM")
	// public Serializable getDbChngDttm() {
	// return this.dbChngDttm;
	// }
	//
	// public void setDbChngDttm(Serializable dbChngDttm) {
	// this.dbChngDttm = dbChngDttm;
	// }

}
