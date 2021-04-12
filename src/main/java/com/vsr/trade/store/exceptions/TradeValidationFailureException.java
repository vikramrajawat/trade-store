package com.vsr.trade.store.exceptions;

public class TradeValidationFailureException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TradeValidationFailureException(String message, String tradeId, Integer version) {
		super(message + tradeId + " " + version);
	}
}