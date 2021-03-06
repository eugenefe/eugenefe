package com.eugenefe.saa.entity;

// Generated Sep 10, 2014 4:21:17 AM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Erba05tbId generated by hbm2java
 */
@Embeddable
public class DebtDurationId implements java.io.Serializable {

	private String basDt;
	private String portseg;

	public DebtDurationId() {
	}

	public DebtDurationId(String basDt, String portseg) {
		this.basDt = basDt;
		this.portseg = portseg;
	}

	@Column(name = "BAS_DT", nullable = false, length = 8)
	public String getBasDt() {
		return this.basDt;
	}

	public void setBasDt(String basDt) {
		this.basDt = basDt;
	}

	@Column(name = "PORTSEG", nullable = false, length = 20)
	public String getPortseg() {
		return this.portseg;
	}

	public void setPortseg(String portseg) {
		this.portseg = portseg;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DebtDurationId))
			return false;
		DebtDurationId castOther = (DebtDurationId) other;

		return ((this.getBasDt() == castOther.getBasDt()) || (this.getBasDt() != null && castOther.getBasDt() != null && this
				.getBasDt().equals(castOther.getBasDt())))
				&& ((this.getPortseg() == castOther.getPortseg()) || (this.getPortseg() != null
						&& castOther.getPortseg() != null && this.getPortseg().equals(castOther.getPortseg())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBasDt() == null ? 0 : this.getBasDt().hashCode());
		result = 37 * result + (getPortseg() == null ? 0 : this.getPortseg().hashCode());
		return result;
	}

}
