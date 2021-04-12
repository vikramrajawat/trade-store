/**
 * 
 */
package com.vsr.trade.store.entity;

import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *         Entity holds trade information 
 */
@Entity
public class Trade {

	@EmbeddedId
	private TradeIdKey tradeIdKey;
	
	private String counterPartyId;
	private String bookId;
	private Date maturityDate;
	private Date createdDate;
	private boolean exipired;
	
	public Trade() {
	}

	public Trade(TradeIdKey tradeIdKey, String counterPartyId, String bookId, Date maturityDate, Date createdDate,
			boolean exipired) {
		super();
		this.tradeIdKey=tradeIdKey;
		this.counterPartyId = counterPartyId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.exipired = exipired;
	}

	/**
	 * @return the tradeIdKey
	 */
	public TradeIdKey getTradeIdKey() {
		return tradeIdKey;
	}

	/**
	 * @param tradeIdKey the tradeIdKey to set
	 */
	public void setTradeIdKey(TradeIdKey tradeIdKey) {
		this.tradeIdKey = tradeIdKey;
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
	public Date getMaturityDate() {
		return maturityDate;
	}

	/**
	 * @param maturityDate the maturityDate to set
	 */
	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the exipired
	 */
	public boolean isExipired() {
		return exipired;
	}

	/**
	 * @param exipired the exipired to set
	 */
	public void setExipired(boolean exipired) {
		this.exipired = exipired;
	}


}
