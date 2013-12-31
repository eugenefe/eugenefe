package com.eugenefe.entity;

// Generated Apr 10, 2013 4:09:22 PM by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.eugenefe.util.AnnoMethodTree;
import com.eugenefe.util.AnnoNavigationFilter;
import com.eugenefe.util.MarketVariableType;

/**
 * FuturesHis generated by hbm2java
 */
@Entity
@Table(name = "FUTURES_HIS")
@AnnoNavigationFilter
public class FuturesHis implements java.io.Serializable, IMarketVariableHis {

	private FuturesHisId id;
	private Futures futures;
	private Basedate basedate;
	private BigDecimal basePrice;
	private BigDecimal openPrice;
	private BigDecimal highPrice;
	private BigDecimal lowPrice;
	private BigDecimal closePrice;
	private BigDecimal volume;
	private BigDecimal volumeAmt;
	private BigDecimal delta;
	private BigDecimal gamma;
	private BigDecimal vega;
	private BigDecimal theta;
	private BigDecimal rho;

	public FuturesHis() {
	}

	public FuturesHis(FuturesHisId id, Futures futures, Basedate basedate) {
		this.id = id;
		this.futures = futures;
		this.basedate = basedate;
	}

	public FuturesHis(FuturesHisId id, Futures futures, Basedate basedate, BigDecimal basePrice, BigDecimal openPrice,
			BigDecimal highPrice, BigDecimal lowPrice, BigDecimal closePrice, BigDecimal volume, BigDecimal volumeAmt,
			BigDecimal delta, BigDecimal gamma, BigDecimal vega, BigDecimal theta, BigDecimal rho) {
		this.id = id;
		this.futures = futures;
		this.basedate = basedate;
		this.basePrice = basePrice;
		this.openPrice = openPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.closePrice = closePrice;
		this.volume = volume;
		this.volumeAmt = volumeAmt;
		this.delta = delta;
		this.gamma = gamma;
		this.vega = vega;
		this.theta = theta;
		this.rho = rho;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "bssd", column = @Column(name = "BSSD", nullable = false, length = 8)),
			@AttributeOverride(name = "futuresId", column = @Column(name = "FUTURES_ID", nullable = false, length = 20)) })
	@NotNull
	@AnnoMethodTree(order=10, init=true)
	public FuturesHisId getId() {
		return this.id;
	}

	public void setId(FuturesHisId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FUTURES_ID", nullable = false, insertable = false, updatable = false)
	@NotNull
	@AnnoMethodTree(order=20, init=false)
	public Futures getFutures() {
		return this.futures;
	}

	public void setFutures(Futures futures) {
		this.futures = futures;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BSSD", nullable = false, insertable = false, updatable = false)
	@NotNull
	@AnnoMethodTree(order=30, init=false)
	public Basedate getBasedate() {
		return this.basedate;
	}

	public void setBasedate(Basedate basedate) {
		this.basedate = basedate;
	}

	@Column(name = "BASE_PRICE", scale = 4)
	@AnnoMethodTree(order=40, init=true, align="right")
	public BigDecimal getBasePrice() {
		return this.basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	@Column(name = "OPEN_PRICE", scale = 4)
	@AnnoMethodTree(order=41, init=true, align="right")
	public BigDecimal getOpenPrice() {
		return this.openPrice;
	}

	public void setOpenPrice(BigDecimal openPrice) {
		this.openPrice = openPrice;
	}

	@Column(name = "HIGH_PRICE", scale = 4)
	@AnnoMethodTree(order=42, init=true, align="right")
	public BigDecimal getHighPrice() {
		return this.highPrice;
	}

	public void setHighPrice(BigDecimal highPrice) {
		this.highPrice = highPrice;
	}

	@Column(name = "LOW_PRICE", scale = 4)
	@AnnoMethodTree(order=43, init=true, align="right")
	public BigDecimal getLowPrice() {
		return this.lowPrice;
	}

	public void setLowPrice(BigDecimal lowPrice) {
		this.lowPrice = lowPrice;
	}

	@Column(name = "CLOSE_PRICE", scale = 4)
	@AnnoMethodTree(order=44, init=true, align="right")
	public BigDecimal getClosePrice() {
		return this.closePrice;
	}

	public void setClosePrice(BigDecimal closePrice) {
		this.closePrice = closePrice;
	}
	@Override
	@Column(name = "VOLUME", scale = 0)
	@AnnoMethodTree(order=50, init=true, align="right")
	public BigDecimal getVolume() {
		return this.volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}
	@Override
	@Column(name = "VOLUME_AMT", scale = 0)
	@AnnoMethodTree(order=51, init=true, align="right")
	public BigDecimal getVolumeAmt() {
		return this.volumeAmt;
	}

	public void setVolumeAmt(BigDecimal volumeAmt) {
		this.volumeAmt = volumeAmt;
	}

	@Column(name = "DELTA", scale = 4)
	@AnnoMethodTree(order=61, init=true, align="right")
	public BigDecimal getDelta() {
		return this.delta;
	}

	public void setDelta(BigDecimal delta) {
		this.delta = delta;
	}

	@Column(name = "GAMMA", scale = 4)
	public BigDecimal getGamma() {
		return this.gamma;
	}

	public void setGamma(BigDecimal gamma) {
		this.gamma = gamma;
	}

	@Column(name = "VEGA", scale = 4)
	public BigDecimal getVega() {
		return this.vega;
	}

	public void setVega(BigDecimal vega) {
		this.vega = vega;
	}

	@Column(name = "THETA", scale = 4)
	@AnnoMethodTree(order=64, init=true, align="right")
	public BigDecimal getTheta() {
		return this.theta;
	}

	public void setTheta(BigDecimal theta) {
		this.theta = theta;
	}

	@Column(name = "RHO", scale = 4)
	@AnnoMethodTree(order=65, init=true, align="right")
	public BigDecimal getRho() {
		return this.rho;
	}

	public void setRho(BigDecimal rho) {
		this.rho = rho;
	}
//	******************Override Method**********************
	@Override
	@Transient
	public String getBssd() {
		return getBasedate().getBssd();
	}

	@Override
	@Transient
	public String getMvId() {
		return getFutures().getFuturesId();
	}

	@Override
	@Transient
	public String getMvName() {
		return getFutures().getFuturesId();
	}
	@Override
	@Transient
	public String getMvType() {
		return MarketVariableType.FUTURES.getType();
	}
//	public ProductType getMvType() {
//		return ProductType.STOCK;
//	}
	@Override
	@Transient
	public double getCurrentPrice() {
		return getClosePrice().doubleValue();
	}

	@Override
	@Transient
	public double getBeforePrice() {
		return getBasePrice().doubleValue();
	}

	@Override
	@Transient
	public BigDecimal getAdjDuration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transient
	public BigDecimal getMdDuration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transient
	public BigDecimal getEffectDuration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transient
	public BigDecimal getAdjConvexity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transient
	public BigDecimal getEffectConvexity() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Transient
	public BigDecimal getStockBeta() {
		// TODO Auto-generated method stub
				return null;
	}
}
