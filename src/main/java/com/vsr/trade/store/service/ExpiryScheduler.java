package com.vsr.trade.store.service;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.vsr.trade.store.domain.Trade;
import com.vsr.trade.store.utils.BOOLEAN_VALUE;
import com.vsr.trade.store.utils.Utils;

@Component
public class ExpiryScheduler {

	@Autowired
	private TradeService tradeService;

	@Scheduled(fixedDelay = 5000)
	private void expiryFlagUpdateScheduler() {
		
		List<Trade> expiredTrades = tradeService.findAll()
				.stream()
				.filter(t -> Utils.formatDate(t.getMaturityDate()).before(Calendar.getInstance().getTime()))
				.collect(Collectors.toList());
		
		tradeService.addAll(expiredTrades.stream()
				.map(t-> {
					t.setExipired(BOOLEAN_VALUE.Y);
					return t;}
				).collect(Collectors.toList()));
	}

}
