package com.vsr.trade.store.domain;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vsr.trade.store.utils.BOOLEAN_VALUE;

public class Trade {

	private String tradeId;
	private Integer version;
	private String counterPartyId;
	private String bookId;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private String maturityDate;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private String createdDate;
	@JsonFormat(shape = JsonFormat.Shape.ANY)
	private BOOLEAN_VALUE exipired;
	
	public Trade(String tradeId, Integer version, String counterPartyId, String bookId, String maturityDate, String createdDate,
			BOOLEAN_VALUE exipired) {
		super();
		this.tradeId = tradeId;
		this.version = version;
		this.counterPartyId = counterPartyId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.exipired = exipired;
	}
	/**
	 * @return the tradeId
	 */
	public String getTradeId() {
		return tradeId;
	}
	/**
	 * @param tradeId the tradeId to set
	 */
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
	}
	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * @return the counterPartyId
	 */
	public String getCounterPartyId() {
		return counterPartyId;
	}
	/**
	 * @param counterPartyId the counterPartyId to set
	 */
	public void setCounterPartyId(String counterPartyId) {
		this.counterPartyId = counterPartyId;
	}
	/**
	 * @return the bookId
	 */
	public String getBookId() {
		return bookId;
	}
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return the maturityDate
	 */
	public String getMaturityDate() {
		return maturityDate;
	}
	/**
	 * @param maturityDate the maturityDate to set
	 */
	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}
	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the exipired
	 */
	public BOOLEAN_VALUE isExipired() {
		return exipired;
	}
	/**
	 * @param exipired the exipired to set
	 */
	public void setExipired(BOOLEAN_VALUE exipired) {
		this.exipired = exipired;
	}
	@Override
	public int hashCode() {
		return Objects.hash(tradeId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		return Objects.equals(tradeId, other.tradeId);
	}
	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", version=" + version + ", counterPartyId=" + counterPartyId + ", bookId="
				+ bookId + ", maturityDate=" + maturityDate + ", createdDate=" + createdDate + ", exipired=" + exipired
				+ "]";
	}

}
