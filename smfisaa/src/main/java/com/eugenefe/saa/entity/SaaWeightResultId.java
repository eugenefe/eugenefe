package com.eugenefe.saa.entity;

// Generated Sep 10, 2014 4:21:17 AM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Erba29tbId generated by hbm2java
 */
@Embeddable
public class SaaWeightResultId implements java.io.Serializable {

	private String basDt;
	private String optMthdlId;
	private String segId;

	public SaaWeightResultId() {
	}

	public SaaWeightResultId(String basDt, String optMthdlId, String segId) {
		this.basDt = basDt;
		this.optMthdlId = optMthdlId;
		this.segId = segId;
	}

	@Column(name = "BAS_DT", nullable = false, length = 8)
	public String getBasDt() {
		return this.basDt;
	}

	public void setBasDt(String basDt) {
		this.basDt = basDt;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SaaWeightResultId))
			return false;
		SaaWeightResultId castOther = (SaaWeightResultId) other;

		return ((this.getBasDt() == castOther.getBasDt()) || (this.getBasDt() != null && castOther.getBasDt() != null && this
				.getBasDt().equals(castOther.getBasDt())))
				&& ((this.getOptMthdlId() == castOther.getOptMthdlId()) || (this.getOptMthdlId() != null
						&& castOther.getOptMthdlId() != null && this.getOptMthdlId().equals(castOther.getOptMthdlId())))
				&& ((this.getSegId() == castOther.getSegId()) || (this.getSegId() != null
						&& castOther.getSegId() != null && this.getSegId().equals(castOther.getSegId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBasDt() == null ? 0 : this.getBasDt().hashCode());
		result = 37 * result + (getOptMthdlId() == null ? 0 : this.getOptMthdlId().hashCode());
		result = 37 * result + (getSegId() == null ? 0 : this.getSegId().hashCode());
		return result;
	}

}
