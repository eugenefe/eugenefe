package com.eugenefe.saa.entity;

// Generated Sep 10, 2014 4:21:17 AM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Erba09tbId generated by hbm2java
 */
@Embeddable
public class BenchmarkExpectedReturnId implements java.io.Serializable {

	private String bmkId;
	private String applyStartDt;

	public BenchmarkExpectedReturnId() {
	}

	public BenchmarkExpectedReturnId(String bmkId, String applyStartDt) {
		this.bmkId = bmkId;
		this.applyStartDt = applyStartDt;
	}

	@Column(name = "BMK_ID", nullable = false, length = 20)
	public String getBmkId() {
		return this.bmkId;
	}

	public void setBmkId(String bmkId) {
		this.bmkId = bmkId;
	}

	@Column(name = "APPLY_START_DT", nullable = false, length = 8)
	public String getApplyStartDt() {
		return this.applyStartDt;
	}

	public void setApplyStartDt(String applyStartDt) {
		this.applyStartDt = applyStartDt;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BenchmarkExpectedReturnId))
			return false;
		BenchmarkExpectedReturnId castOther = (BenchmarkExpectedReturnId) other;

		return ((this.getBmkId() == castOther.getBmkId()) || (this.getBmkId() != null && castOther.getBmkId() != null && this
				.getBmkId().equals(castOther.getBmkId())))
				&& ((this.getApplyStartDt() == castOther.getApplyStartDt()) || (this.getApplyStartDt() != null
						&& castOther.getApplyStartDt() != null && this.getApplyStartDt().equals(
						castOther.getApplyStartDt())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBmkId() == null ? 0 : this.getBmkId().hashCode());
		result = 37 * result + (getApplyStartDt() == null ? 0 : this.getApplyStartDt().hashCode());
		return result;
	}

}