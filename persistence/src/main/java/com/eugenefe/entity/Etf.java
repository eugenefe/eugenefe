package com.eugenefe.entity;

// Generated Apr 10, 2013 4:09:22 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.eugenefe.util.AnnoMethodTree;
import com.eugenefe.util.AnnoNavigationFilter;

/**
 * Etf generated by hbm2java
 */
@Entity
@Table(name = "ETF")
@AnnoNavigationFilter
public class Etf implements java.io.Serializable {

	private String etfId;
	private MarketVariable marketVariable;
//	private StockIndex stockIndex;
	private String etfName;
	private String isinCd;
	private BigDecimal bmCoefficient;
	private Long numPerCu;
	private Long numShares;
	private BigDecimal totAmt;
	private String sourceTable;
	private String userName;
	private String lastUpdated;
	private BigDecimal versionNo;
//	private Set<EtfHis> etfHises = new HashSet<EtfHis>(0);
//	private Set<EtfPdf> etfPdfs = new HashSet<EtfPdf>(0);

	public Etf() {
	}

//	public Etf(MarketVariable marketVariable) {
//		this.marketVariable = marketVariable;
//	}
//
//	public Etf(MarketVariable marketVariable, StockIndex stockIndex, String etfName, String isinCd,
//			BigDecimal bmCoefficient, Long numPerCu, Long numShares, BigDecimal totAmt, String sourceTable,
//			String userName, String lastUpdated, BigDecimal versionNo, Set<EtfHis> etfHises, Set<EtfPdf> etfPdfs) {
//		this.marketVariable = marketVariable;
//		this.stockIndex = stockIndex;
//		this.etfName = etfName;
//		this.isinCd = isinCd;
//		this.bmCoefficient = bmCoefficient;
//		this.numPerCu = numPerCu;
//		this.numShares = numShares;
//		this.totAmt = totAmt;
//		this.sourceTable = sourceTable;
//		this.userName = userName;
//		this.lastUpdated = lastUpdated;
//		this.versionNo = versionNo;
//		this.etfHises = etfHises;
//		this.etfPdfs = etfPdfs;
//	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "marketVariable"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ETF_ID", unique = true, nullable = false, length = 20)
	@Size(max = 20)
	@AnnoMethodTree(order=10, init=true)
	public String getEtfId() {
		return this.etfId;
	}

	public void setEtfId(String etfId) {
		this.etfId = etfId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@NotNull
	@Size(max = 20)
	@AnnoMethodTree(order=20, init=false)
	public MarketVariable getMarketVariable() {
		return this.marketVariable;
	}

	public void setMarketVariable(MarketVariable marketVariable) {
		this.marketVariable = marketVariable;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "BM_ID")
//	public StockIndex getStockIndex() {
//		return this.stockIndex;
//	}
//
//	public void setStockIndex(StockIndex stockIndex) {
//		this.stockIndex = stockIndex;
//	}

	@Column(name = "ETF_NAME", length = 50)
	@Size(max = 50)
	@AnnoMethodTree(order=11, init=true)
	public String getEtfName() {
		return this.etfName;
	}

	public void setEtfName(String etfName) {
		this.etfName = etfName;
	}

	@Column(name = "ISIN_CD", length = 20)
	@Size(max = 20)
	@AnnoMethodTree(order=15, init=true)
	public String getIsinCd() {
		return this.isinCd;
	}

	public void setIsinCd(String isinCd) {
		this.isinCd = isinCd;
	}

	@Column(name = "BM_COEFFICIENT", precision = 10, scale = 4)
	@AnnoMethodTree(order=30, init=true, align="right")
	public BigDecimal getBmCoefficient() {
		return this.bmCoefficient;
	}

	public void setBmCoefficient(BigDecimal bmCoefficient) {
		this.bmCoefficient = bmCoefficient;
	}

	@Column(name = "NUM_PER_CU", precision = 10, scale = 0)
	@AnnoMethodTree(order=31, init=true, align="right")
	public Long getNumPerCu() {
		return this.numPerCu;
	}

	public void setNumPerCu(Long numPerCu) {
		this.numPerCu = numPerCu;
	}

	@Column(name = "NUM_SHARES", precision = 10, scale = 0)
	@AnnoMethodTree(order=35, init=true, align="right")
	public Long getNumShares() {
		return this.numShares;
	}

	public void setNumShares(Long numShares) {
		this.numShares = numShares;
	}

	@Column(name = "TOT_AMT", scale = 0)
	@AnnoMethodTree(order=40, init=true, align="right")
	public BigDecimal getTotAmt() {
		return this.totAmt;
	}

	public void setTotAmt(BigDecimal totAmt) {
		this.totAmt = totAmt;
	}

	@Column(name = "SOURCE_TABLE", length = 50)
	@Size(max = 50)
	public String getSourceTable() {
		return this.sourceTable;
	}

	public void setSourceTable(String sourceTable) {
		this.sourceTable = sourceTable;
	}

	@Column(name = "USER_NAME", length = 20)
	@Size(max = 20)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "LAST_UPDATED", length = 8)
	@Size(max = 8)
	public String getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Column(name = "VERSION_NO", precision = 22, scale = 0)
	public BigDecimal getVersionNo() {
		return this.versionNo;
	}

	public void setVersionNo(BigDecimal versionNo) {
		this.versionNo = versionNo;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etf")
//	public Set<EtfHis> getEtfHises() {
//		return this.etfHises;
//	}
//
//	public void setEtfHises(Set<EtfHis> etfHises) {
//		this.etfHises = etfHises;
//	}
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etf")
//	public Set<EtfPdf> getEtfPdfs() {
//		return this.etfPdfs;
//	}
//
//	public void setEtfPdfs(Set<EtfPdf> etfPdfs) {
//		this.etfPdfs = etfPdfs;
//	}

}
