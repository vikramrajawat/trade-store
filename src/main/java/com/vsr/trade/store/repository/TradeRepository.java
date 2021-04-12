package com.vsr.trade.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsr.trade.store.entity.Trade;
import com.vsr.trade.store.entity.TradeIdKey;


public interface TradeRepository extends JpaRepository<Trade, TradeIdKey> {

}
