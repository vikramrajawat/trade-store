package com.vsr.trade.store;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.vsr.trade.store.rest.TradeController;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TradeStoreApplicationTests {

	@Autowired
	private TradeController tradeController;
	
	@Test
	void applicationLoadTest() {
		assertThat(tradeController).isNotNull();
	}

}
