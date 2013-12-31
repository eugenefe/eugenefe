package com.eugenefe.entity;

// Generated Apr 16, 2013 7:33:55 PM by Hibernate Tools 4.0.0

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.eugenefe.util.AnnoMethodTree;
import com.eugenefe.util.EColumnType;
import com.eugenefe.util.AnnoNavigationFilter;

/**
 * Bizunit generated by hbm2java
 */
@Entity
@Table(name = "BIZUNIT")
@AnnoNavigationFilter
public class Bizunit implements java.io.Serializable {

	private String orgId;
	private Bizunit parentBizunit;
	private String orgName;
//	private Set<Employee> employees = new HashSet<Employee>(0);
	private List<Employee> employees = new ArrayList<Employee>();
	private List<Bizunit> childBizunits = new ArrayList<Bizunit>();

	public Bizunit() {
	}

	public Bizunit(String orgId) {
		this.orgId = orgId;
	}

	public Bizunit(String orgId, Bizunit parentBizunit, String orgName, List<Employee> employees,
			List<Bizunit> childBizunits) {
		this.orgId = orgId;
		this.parentBizunit = parentBizunit;
		this.orgName = orgName;
		this.employees = employees;
		this.childBizunits = childBizunits;
	}

	@Id
	@Column(name = "ORG_ID", nullable = false, length = 20)
	@AnnoMethodTree(order =10, init=true)
	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ORG_ID")
	@AnnoMethodTree(order =30, init=false)
	public Bizunit getParentBizunit() {
		return this.parentBizunit;
	}

	public void setParentBizunit(Bizunit parentBizunit) {
		this.parentBizunit = parentBizunit;
	}

	@Column(name = "ORG_NAME", length = 50)
	@AnnoMethodTree(order =20, init=true)
	public String getOrgName() {
		return this.orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bizunit")
	@AnnoMethodTree(order =40, init=false, type=EColumnType.List)
	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parentBizunit")
	@AnnoMethodTree(order =50, init=false, type=EColumnType.List)
	public List<Bizunit> getChildBizunits() {
		return this.childBizunits;
	}

	public void setChildBizunits(List<Bizunit> childBizunits) {
		this.childBizunits = childBizunits;
	}

}
