package com.vsr.trade.store;

import java.sql.Date;
import java.util.GregorianCalendar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vsr.trade.store.entity.Trade;
import com.vsr.trade.store.entity.TradeIdKey;
import com.vsr.trade.store.repository.TradeRepository;

@Configuration
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(TradeRepository repository) {
	  
    return args -> {
      /*
    	repository.save(new Trade(new TradeIdKey("T1",1), "CP-1","B1", new Date(new GregorianCalendar(2020,05,20).getTimeInMillis()) , new Date(System.currentTimeMillis()),false));
      	repository.save(new Trade(new TradeIdKey("T2",2), "CP-2","B1", new Date(new GregorianCalendar(2021,05,20).getTimeInMillis()), new Date(System.currentTimeMillis()),false));
      	repository.save(new Trade(new TradeIdKey("T2",1), "CP-1","B1", new Date(new GregorianCalendar(2021,05,20).getTimeInMillis()), new Date(new GregorianCalendar(2015,03,14).getTimeInMillis()),false));
      	repository.save(new Trade(new TradeIdKey("T3",3), "CP-3","B2", new Date(new GregorianCalendar(2014,05,20).getTimeInMillis()), new Date(System.currentTimeMillis()),true));
      */
    };
  }
}