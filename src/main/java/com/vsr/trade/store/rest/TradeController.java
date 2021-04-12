package com.vsr.trade.store.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vsr.trade.store.domain.Trade;
import com.vsr.trade.store.service.TradeService;

@RestController
public class TradeController {

	@Autowired
	private TradeService service;
	
	@GetMapping("/trades")
	private List<Trade> getAllTrade() {
		return service.findAll();
	}
	
	@PostMapping("/trades")
	private ResponseEntity<Trade> addTrade(@RequestBody Trade trade) {
		return new ResponseEntity<>(service.add(trade), HttpStatus.CREATED);
	}
	
}
