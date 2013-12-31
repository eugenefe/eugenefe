package com.eugenefe.entity;

// Generated Apr 16, 2013 7:33:55 PM by Hibernate Tools 4.0.0


import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Position generated by hbm2java
 */
@Entity
@Table(name = "POSITION")
public class Position implements IPortfolio, Serializable {

	private String posId;
	private String posName;
	private MarketVariable product;
	private Counterparty counterparty;
	private String initTxDate;
	private String lastTxDate;
	private BigDecimal initTxPrice;
	private BigDecimal initFeeAmt;
	private BigDecimal initTxAmt;
	private BigDecimal holdingQty;
	private BigDecimal posAmt;

	public Position() {
		System.out.println("In the Position Creation");
	}

	public Position(String posId) {
		this.posId = posId;
	}

	public Position(String posId, String posName, String initTxDate, String lastTxDate, BigDecimal initTxPrice,
			BigDecimal initFeeAmt, BigDecimal initTxAmt, BigDecimal holdingQty) {
		this.posId = posId;
		this.posName = posName;
		this.initTxDate = initTxDate;
		this.lastTxDate = lastTxDate;
		this.initTxPrice = initTxPrice;
		this.initFeeAmt = initFeeAmt;
		this.initTxAmt = initTxAmt;
		this.holdingQty = holdingQty;
	}

	@Id
	@Column(name = "POS_ID", nullable = false, length = 50)
	public String getPosId() {
		return this.posId;
	}

	public void setPosId(String posId) {
		this.posId = posId;
	}

	@Column(name = "POS_NAME", length = 50)
	public String getPosName() {
		return this.posName;
	}

	public void setPosName(String posName) {
		this.posName = posName;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROD_ID")
	public MarketVariable getProduct() {
//		System.out.println("In the GetProduct");
		return product;
	}

	public void setProduct(MarketVariable product) {
		this.product = product;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "COUNTERTPARTY_ID")
	@JoinColumn(name = "COUNTERPARTY_ID")
	public Counterparty getCounterparty() {
		return counterparty;
	}

	public void setCounterparty(Counterparty counterparty) {
		this.counterparty = counterparty;
	}

	@Column(name = "INIT_TX_DATE", length = 8)
	public String getInitTxDate() {
		return this.initTxDate;
	}

	public void setInitTxDate(String initTxDate) {
		this.initTxDate = initTxDate;
	}

	@Column(name = "LAST_TX_DATE", length = 8)
	public String getLastTxDate() {
		return this.lastTxDate;
	}

	public void setLastTxDate(String lastTxDate) {
		this.lastTxDate = lastTxDate;
	}

	@Column(name = "INIT_TX_PRICE", scale = 4)
	public BigDecimal getInitTxPrice() {
		return this.initTxPrice;
	}

	public void setInitTxPrice(BigDecimal initTxPrice) {
		this.initTxPrice = initTxPrice;
	}

	@Column(name = "INIT_FEE_AMT", scale = 4)
	public BigDecimal getInitFeeAmt() {
		return this.initFeeAmt;
	}

	public void setInitFeeAmt(BigDecimal initFeeAmt) {
		this.initFeeAmt = initFeeAmt;
	}

	@Column(name = "INIT_TX_AMT", scale = 4)
	public BigDecimal getInitTxAmt() {
		return this.initTxAmt;
	}

	public void setInitTxAmt(BigDecimal initTxAmt) {
		this.initTxAmt = initTxAmt;
	}

	@Column(name = "HOLDING_QTY", scale = 4)
	public BigDecimal getHoldingQty() {
		return this.holdingQty;
	}

	public void setHoldingQty(BigDecimal holdingQty) {
		this.holdingQty = holdingQty;
	}
	
	@Column(name = "POS_AMT", scale = 4)
//	@Transient
	public BigDecimal getPosAmt() {
		return posAmt;
	}

	public void setPosAmt(BigDecimal posAmt) {
		this.posAmt = posAmt;
	}

	//**************************************	
	@Override
	@Transient
	public String getStringId() {
		return getPosId();
	}

	@Override
	@Transient
	public String getName() {
		return getPosName();
	}

	@Override
	@Transient
	public void add(IPortfolio port) {
		
	}

	@Override
	@Transient
	public void remove(IPortfolio port) {
		
	}

	@Override
	@Transient
	public List<IPortfolio> getChildren() {
		return new ArrayList<IPortfolio>();
	}

	@Override
	@Transient
	public IPortfolio getChildren(String portId) {
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
		return 0;
	}

	@Override
	@Transient
	public double getDailyReturn() {
		return 0;
	}


}
