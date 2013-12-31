package com.eugenefe.entity;

// Generated Nov 25, 2013 6:47:59 PM by Hibernate Tools 4.0.0


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

import com.eugenefe.util.AnnoMethodTree;
import com.eugenefe.util.AnnoNavigationFilter;

/**
 * HifiveStrike generated by hbm2java
 */
@Entity
@Table(name = "HIFIVE_STRIKE")
@AnnoNavigationFilter
public class HifiveStrike implements java.io.Serializable {

	private HifiveStrikeId id;
	private Hifive hifive;
	private String strikeDate;
	private String paymentDate;
	private BigDecimal strikePrice;
	private BigDecimal dblJumpStrike;
	private BigDecimal tplJumpStrike;
	private BigDecimal payoffAmt;
	private BigDecimal dblJumpPayoff;
	private BigDecimal tplJumpPayoff;
	private BigDecimal couponRate;
	private BigDecimal upBarrier;

	public HifiveStrike() {
	}

	public HifiveStrike(HifiveStrikeId id, Hifive hifive, BigDecimal strikePrice) {
		this.id = id;
		this.hifive = hifive;
		this.strikePrice = strikePrice;
	}

	public HifiveStrike(HifiveStrikeId id, Hifive hifive, String strikeDate, String paymentDate,
			BigDecimal strikePrice, BigDecimal dblJumpStrike, BigDecimal tplJumpStrike, BigDecimal payoffAmt,
			BigDecimal dblJumpPayoff, BigDecimal tplJumpPayoff, BigDecimal couponRate, BigDecimal upBarrier) {
		this.id = id;
		this.hifive = hifive;
		this.strikeDate = strikeDate;
		this.paymentDate = paymentDate;
		this.strikePrice = strikePrice;
		this.dblJumpStrike = dblJumpStrike;
		this.tplJumpStrike = tplJumpStrike;
		this.payoffAmt = payoffAmt;
		this.dblJumpPayoff = dblJumpPayoff;
		this.tplJumpPayoff = tplJumpPayoff;
		this.couponRate = couponRate;
		this.upBarrier = upBarrier;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "prodId", column = @Column(name = "PROD_ID", nullable = false, length = 20)),
			@AttributeOverride(name = "strikeSerial", column = @Column(name = "STRIKE_SERIAL", nullable = false, precision = 10, scale = 0)) })
	@AnnoMethodTree(order=10, init=true)
	public HifiveStrikeId getId() {
		return this.id;
	}

	public void setId(HifiveStrikeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROD_ID", nullable = false, insertable = false, updatable = false)
	@AnnoMethodTree(order=20, init=true)
	public Hifive getHifive() {
		return this.hifive;
	}

	public void setHifive(Hifive hifive) {
		this.hifive = hifive;
	}

	@Column(name = "STRIKE_DATE", length = 8)
	@AnnoMethodTree(order=21, init=true)
	public String getStrikeDate() {
		return this.strikeDate;
	}

	public void setStrikeDate(String strikeDate) {
		this.strikeDate = strikeDate;
	}

	@Column(name = "PAYMENT_DATE", length = 8)
	@AnnoMethodTree(order=22, init=true)
	public String getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Column(name = "STRIKE_PRICE", nullable = false, precision = 10, scale = 4)
	@AnnoMethodTree(order=30, init=true)
	public BigDecimal getStrikePrice() {
		return this.strikePrice;
	}

	public void setStrikePrice(BigDecimal strikePrice) {
		this.strikePrice = strikePrice;
	}

	@Column(name = "DBL_JUMP_STRIKE", precision = 10, scale = 4)
	@AnnoMethodTree(order=31, init=true)
	public BigDecimal getDblJumpStrike() {
		return this.dblJumpStrike;
	}

	public void setDblJumpStrike(BigDecimal dblJumpStrike) {
		this.dblJumpStrike = dblJumpStrike;
	}

	@Column(name = "TPL_JUMP_STRIKE", precision = 10, scale = 4)
	@AnnoMethodTree(order=32, init=true)
	public BigDecimal getTplJumpStrike() {
		return this.tplJumpStrike;
	}

	public void setTplJumpStrike(BigDecimal tplJumpStrike) {
		this.tplJumpStrike = tplJumpStrike;
	}

	@Column(name = "PAYOFF_AMT", precision = 10, scale = 4)
	@AnnoMethodTree(order=40, init=true)
	public BigDecimal getPayoffAmt() {
		return this.payoffAmt;
	}

	public void setPayoffAmt(BigDecimal payoffAmt) {
		this.payoffAmt = payoffAmt;
	}

	@Column(name = "DBL_JUMP_PAYOFF", precision = 10, scale = 4)
	@AnnoMethodTree(order=41, init=true)
	public BigDecimal getDblJumpPayoff() {
		return this.dblJumpPayoff;
	}

	public void setDblJumpPayoff(BigDecimal dblJumpPayoff) {
		this.dblJumpPayoff = dblJumpPayoff;
	}

	@Column(name = "TPL_JUMP_PAYOFF", precision = 10, scale = 4)
	@AnnoMethodTree(order=42, init=true)
	public BigDecimal getTplJumpPayoff() {
		return this.tplJumpPayoff;
	}

	public void setTplJumpPayoff(BigDecimal tplJumpPayoff) {
		this.tplJumpPayoff = tplJumpPayoff;
	}

	@Column(name = "COUPON_RATE", precision = 10, scale = 4)
	@AnnoMethodTree(order=50, init=true)
	public BigDecimal getCouponRate() {
		return this.couponRate;
	}

	public void setCouponRate(BigDecimal couponRate) {
		this.couponRate = couponRate;
	}

	@Column(name = "UP_BARRIER", precision = 10, scale = 4)
	@AnnoMethodTree(order=60, init=true)
	public BigDecimal getUpBarrier() {
		return this.upBarrier;
	}

	public void setUpBarrier(BigDecimal upBarrier) {
		this.upBarrier = upBarrier;
	}

}
