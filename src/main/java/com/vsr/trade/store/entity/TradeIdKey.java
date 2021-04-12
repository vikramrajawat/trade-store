package com.vsr.trade.store.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TradeIdKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String tradeId;
	private int version;
	
	public TradeIdKey() {}
	
	public TradeIdKey(String tradeId, int version) {
		super();
		this.tradeId = tradeId;
		this.version = version;
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
	public int getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}
	
}
