package com.vsr.trade.store.service;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsr.trade.store.domain.Trade;
import com.vsr.trade.store.exceptions.TradeValidationFailureException;
import com.vsr.trade.store.repository.TradeRepository;
import com.vsr.trade.store.utils.ObjectBuilder;
import com.vsr.trade.store.utils.Utils;

/**
 * Adds/Update required trades in trade store
 *
 */

@Service
public class TradeService {

	@Autowired
	private TradeRepository tradeRepository;

	public List<Trade> findAll() {
		return getSortedTrades(tradeRepository.findAll());	
	}
	
	public Trade add(Trade trade) {
		validate(trade, findAll());
		return ObjectBuilder.buildDomainObject(tradeRepository.save(ObjectBuilder.buildEntityObject(trade)));
	}
	
	public void addAll(List<Trade> trades) {
		tradeRepository.saveAll(ObjectBuilder.buildEntityObjectList(trades));
	}
	
	
	public void validate(Trade trade, List<Trade> listOfTrades) {

		// Validation 1 - check if maturity date is of past. if so then it should not be allowed
		
		if(trade.getMaturityDate()!=null 
				&& Utils.formatDate(trade.getMaturityDate()).before(Calendar.getInstance().getTime())) {
			throw new TradeValidationFailureException("Trade with empty or past date not allowed ", trade.getTradeId(), trade.getVersion());
		}
		
		// Validation 2 - check if new trade with lower version then throw exception, if same version then update record.
		Optional<Trade> tradeWithSameId = 
		listOfTrades.stream().filter(t -> t.equals(trade)).findFirst();
		if(tradeWithSameId.isPresent()) {
			if(tradeWithSameId.get().getVersion().equals(trade.getVersion())) {
				// over right the existing data - this is achieved by having composite primary key using fields tradeId & version in entity 
			} else if (tradeWithSameId.get().getVersion() > trade.getVersion()) {
				throw new TradeValidationFailureException("Trade with lower version not allowed ", trade.getTradeId(), trade.getVersion());
			}
		}
	}

	private List<Trade> getSortedTrades(List<com.vsr.trade.store.entity.Trade> trades) {
		return trades.stream()
				.map(t -> ObjectBuilder.buildDomainObject(t))
				.sorted(Comparator.comparing(Trade::getTradeId).reversed()
						.thenComparing(Trade::getVersion).reversed())
				.collect(Collectors.toList());
	}
	
}
