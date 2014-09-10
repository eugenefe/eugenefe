package com.eugenefe.saa.entity;

// Generated Sep 10, 2014 4:21:17 AM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Erba27tbId generated by hbm2java
 */
@Embeddable
public class SegmentConstraintsId implements java.io.Serializable {

	private String optMthdlId;
	private String segId;
	private String lmtExprCd;

	public SegmentConstraintsId() {
	}

	public SegmentConstraintsId(String optMthdlId, String segId, String lmtExprCd) {
		this.optMthdlId = optMthdlId;
		this.segId = segId;
		this.lmtExprCd = lmtExprCd;
	}

	@Column(name = "OPT_MTHDL_ID", nullable = false, length = 20)
	public String getOptMthdlId() {
		return this.optMthdlId;
	}

	public void setOptMthdlId(String optMthdlId) {
		this.optMthdlId = optMthdlId;
	}

	@Column(name = "SEG_ID", nullable = false, length = 20)
	public String getSegId() {
		return this.segId;
	}

	public void setSegId(String segId) {
		this.segId = segId;
	}

	@Column(name = "LMT_EXPR_CD", nullable = false, length = 10)
	public String getLmtExprCd() {
		return this.lmtExprCd;
	}

	public void setLmtExprCd(String lmtExprCd) {
		this.lmtExprCd = lmtExprCd;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SegmentConstraintsId))
			return false;
		SegmentConstraintsId castOther = (SegmentConstraintsId) other;

		return ((this.getOptMthdlId() == castOther.getOptMthdlId()) || (this.getOptMthdlId() != null
				&& castOther.getOptMthdlId() != null && this.getOptMthdlId().equals(castOther.getOptMthdlId())))
				&& ((this.getSegId() == castOther.getSegId()) || (this.getSegId() != null
						&& castOther.getSegId() != null && this.getSegId().equals(castOther.getSegId())))
				&& ((this.getLmtExprCd() == castOther.getLmtExprCd()) || (this.getLmtExprCd() != null
						&& castOther.getLmtExprCd() != null && this.getLmtExprCd().equals(castOther.getLmtExprCd())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getOptMthdlId() == null ? 0 : this.getOptMthdlId().hashCode());
		result = 37 * result + (getSegId() == null ? 0 : this.getSegId().hashCode());
		result = 37 * result + (getLmtExprCd() == null ? 0 : this.getLmtExprCd().hashCode());
		return result;
	}

}
