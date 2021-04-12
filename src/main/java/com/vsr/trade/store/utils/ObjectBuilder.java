package com.vsr.trade.store.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.vsr.trade.store.domain.Trade;
import com.vsr.trade.store.entity.TradeIdKey;

public class ObjectBuilder {
	
	public static Trade buildDomainObject(com.vsr.trade.store.entity.Trade tradeBE) {
		return new Trade(tradeBE.getTradeIdKey().getTradeId(), 
				tradeBE.getTradeIdKey().getVersion(),
				tradeBE.getCounterPartyId(),
				tradeBE.getBookId(),
				Utils.convertToUtilDateStr(tradeBE.getMaturityDate()),
				Utils.convertToUtilDateStr(tradeBE.getCreatedDate()),
				tradeBE.isExipired()==true?BOOLEAN_VALUE.Y:BOOLEAN_VALUE.N
				);
	}
	
	public static com.vsr.trade.store.entity.Trade buildEntityObject(Trade trade) {
		return new com.vsr.trade.store.entity.Trade(new TradeIdKey(trade.getTradeId(), trade.getVersion()),
				trade.getCounterPartyId(),
				trade.getBookId(),
				Utils.convertToSQLDate(Utils.formatDate(trade.getMaturityDate())),
				Utils.convertToSQLDate(Utils.formatDate(trade.getCreatedDate())),
				trade.isExipired().equals(BOOLEAN_VALUE.Y)?true:false
				);
	}
	
	public static List<com.vsr.trade.store.entity.Trade> buildEntityObjectList(List<Trade> trades) {
		return trades.stream().map(trade -> buildEntityObject(trade)).collect(Collectors.toList());		
	}

	private ObjectBuilder() {}
}
