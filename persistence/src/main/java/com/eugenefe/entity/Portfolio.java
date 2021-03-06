package com.eugenefe.entity;

// Generated Apr 16, 2013 7:33:55 PM by Hibernate Tools 4.0.0


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

//import org.jboss.seam.annotations.Logger;
//import org.jboss.seam.log.Log;

import com.eugenefe.util.AnnoMethodTree;
import com.eugenefe.util.AnnoNavigationFilter;
import com.eugenefe.util.EColumnType;

import sun.util.logging.resources.logging;

/**
 * Portfolio generated by hbm2java
 */
@Entity
@Table(name = "PORTFOLIO")
@AnnoNavigationFilter
public class Portfolio implements IPortfolio, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String portId;
	private Portfolio parentPortfolio;
	private String portName;
	private String groupId;
	private String level1;
	private String level2;
	private String level3;
	private String level4;
	private String level5;
	// private Set<Portfolio> childPortfolios = new HashSet<Portfolio>(0);
	// private Set<IPortfolio> childPortfolios = new HashSet<IPortfolio>(0);
	private List<Portfolio> childPortfolios = new ArrayList<Portfolio>(0);

	private List<PortfolioReturn> portfolioReturns = new ArrayList<PortfolioReturn>();

	// private List<PositionReturn> positions = new ArrayList<PositionReturn>();

	public Portfolio() {
	}

	public Portfolio(String portId, String portName) {
		this.portId = portId;
		this.portName = portName;
	}

	// public Portfolio(String portId, Portfolio parentPortfolio, String
	// portName, String groupId, String level1,
	// String level2, String level3, String levle4, String level5,
	// Set<Portfolio> childPortfolios) {
	// this.portId = portId;
	// this.parentPortfolio = parentPortfolio;
	// this.portName = portName;
	// this.groupId = groupId;
	// this.level1 = level1;
	// this.level2 = level2;
	// this.level3 = level3;
	// this.levle4 = levle4;
	// this.level5 = level5;
	// this.childPortfolios = childPortfolios;
	// }

	@Id
	@Column(name = "PORT_ID", nullable = false, length = 50)
	@AnnoMethodTree(order=10, init=true)
	public String getPortId() {
		return this.portId;
	}

	public void setPortId(String portId) {
		this.portId = portId;
	}

	// @ManyToOne(fetch = FetchType.LAZY, targetEntity=Portfolio.class)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_PORT_ID")
	@AnnoMethodTree(order=30, init=false)
	public Portfolio getParentPortfolio() {
		return this.parentPortfolio;
	}

	public void setParentPortfolio(Portfolio parentPortfolio) {
		this.parentPortfolio = parentPortfolio;
	}

	@Column(name = "PORT_NAME", length = 50)
	@AnnoMethodTree(order=20, init=true)
	public String getPortName() {
		return this.portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	@Column(name = "GROUP_ID", length = 20)
	@AnnoMethodTree(order=40, init=true)
	public String getGroupId() {
		return this.groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Column(name = "LEVEL1", length = 20)
	@AnnoMethodTree(order=50, init=true)
	public String getLevel1() {
		return this.level1;
	}

	public void setLevel1(String level1) {
		this.level1 = level1;
	}

	@Column(name = "LEVEL2", length = 20)
	@AnnoMethodTree(order=51, init=true)
	public String getLevel2() {
		return this.level2;
	}

	public void setLevel2(String level2) {
		this.level2 = level2;
	}

	@Column(name = "LEVEL3", length = 20)
	@AnnoMethodTree(order=52, init=true)
	public String getLevel3() {
		return this.level3;
	}

	public void setLevel3(String level3) {
		this.level3 = level3;
	}

	@Column(name = "LEVEL4", length = 20)
	@AnnoMethodTree(order=53, init=true)
	public String getLevel4() {
		return this.level4;
	}

	public void setLevel4(String level4) {
		this.level4 = level4;
	}

	@Column(name = "LEVEL5", length = 20)
	@AnnoMethodTree(order=54, init=true)
	public String getLevel5() {
		return this.level5;
	}

	public void setLevel5(String level5) {
		this.level5 = level5;
	}

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentPortfolio",
	// targetEntity=Portfolio.class)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parentPortfolio")
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "parentPortfolio")
	@AnnoMethodTree(order=60, init=false, type=EColumnType.List)
	public List<Portfolio> getChildPortfolios() {
//		System.out.println("Call DB");
		return this.childPortfolios;
	}

	public void setChildPortfolios(List<Portfolio> childPortfolios) {
		this.childPortfolios = childPortfolios;
	}

	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentPortfolio",
	// targetEntity=Portfolio.class)
	// public Set<IPortfolio> getChildPortfolios() {
	// return this.childPortfolios;
	// }
	//
	// public void setChildPortfolios(Set<IPortfolio> childPortfolios) {
	// this.childPortfolios = childPortfolios;
	// }

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "portfolio")
	@AnnoMethodTree(order=70, init=false, type= EColumnType.List)
	public List<PortfolioReturn> getPortfolioReturns() {
		return portfolioReturns;
	}

	public void setPortfolioReturns(List<PortfolioReturn> portfolioReturns) {
		this.portfolioReturns = portfolioReturns;
	}

	// @ManyToMany(fetch = FetchType.LAZY)
	// @FilterJoinTable(name= "filterCurrentDatePortfolioDetail", condition
	// ="BSSD = :currentDate")
	// @JoinTable( name="PORTFOLIO_DETAIL"
	// ,joinColumns={@JoinColumn(name="PORT_ID")}
	// ,inverseJoinColumns={@JoinColumn(name="BSSD",
	// referencedColumnName="BSSD"),
	// @JoinColumn(name="POS_ID", referencedColumnName="POS_ID")
	// })
	// public Set<PositionReturn> getPositions() {
	// return positions;
	// }
	//
	// public void setPositions(Set<PositionReturn> positions) {
	// this.positions = positions;
	// }

	@Override
	@Transient
	public void add(IPortfolio port) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transient
	public void remove(IPortfolio port) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transient
	public List<IPortfolio> getChildren() {
		List<IPortfolio> rst = new ArrayList<IPortfolio>();
		// temp = getChildren();
		// temp.addAll(this.getpo
		return rst;
	}

	@Override
	@Transient
	public IPortfolio getChildren(String portId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transient
	public double getPresValue() {
		return 0;
	}

	@Override
	@Transient
	public double getCalcuatedPv() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transient
	public String getStringId() {
		return getPortId();
	}

	@Override
	@Transient
	public String getName() {
		return getPortName() + "AAA";
	}

	// @Override
	// @Transient
	// public Set<IPortfolio> getReturnInfo() {
	// return getPortfolioReturns();
	// }
	
	
	@Override
	@Transient
	public double getDailyReturn() {
		if (getPortfolioReturns().size() != 0) {
			return getPortfolioReturns().get(0).getDailyReturn().doubleValue();
		}
		return 0;
	}

	@Override
	@Transient
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		}
		if (obj == this) {
			return true;
		}
		if(obj.getClass().toString().endsWith("String")){
			System.out.println("Check 1: " + obj);
			return this.getPortId().equals(obj);
		}
		System.out.println("Check : " + obj.getClass().toString() + obj.getClass());
		Portfolio guest = (Portfolio) obj;
		return this.getPortId().equals(guest.getPortId());
	}

	@Override
	@Transient
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((portId == null) ? 0 : portId.hashCode());
		result = prime * result + ((portName == null) ? 0 : portName.hashCode());
		return result;
	}

}
