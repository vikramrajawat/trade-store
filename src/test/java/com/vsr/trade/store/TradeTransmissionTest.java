package com.vsr.trade.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import com.vsr.trade.store.domain.Trade;
import com.vsr.trade.store.utils.BOOLEAN_VALUE;
import com.vsr.trade.store.utils.Utils;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TradeTransmissionTest {

	@Autowired
    private TestRestTemplate restTemplate;
     
    @LocalServerPort
    int randomServerPort;
 
    @Test
    public void testPostTrade() throws URISyntaxException
    {
        final String baseUrl = "http://localhost:"+randomServerPort+"/trades/";
        URI uri = new URI(baseUrl);
        
        // Scenario - 1 | Test Trade record creation
        Trade trade = new Trade("T11", 1, "CP-11", "B1", Utils.convertToUtilDateStr(Utils.tomorrow()) , Utils.convertToUtilDateStr(Utils.today()), BOOLEAN_VALUE.N);
        
        HttpEntity<Trade> request = new HttpEntity<>(trade);
         
        ResponseEntity<Trade> result = this.restTemplate.postForEntity(uri, request, Trade.class);
        
        assertEquals(201, result.getStatusCodeValue());
        
    }
    
    @Test
    public void testPostTradeSameVersion() throws URISyntaxException
    {
        final String baseUrl = "http://localhost:"+randomServerPort+"/trades/";
        URI uri = new URI(baseUrl);
        
        // Scenario - 1 | Test Trade record creation
        Trade trade = new Trade("T11", 1, "CP-11", "B1", Utils.convertToUtilDateStr(Utils.tomorrow()) , Utils.convertToUtilDateStr(Utils.today()), BOOLEAN_VALUE.N);
        
        HttpEntity<Trade> request = new HttpEntity<>(trade);
         
        ResponseEntity<Trade> result = this.restTemplate.postForEntity(uri, request, Trade.class);
        
        assertEquals(201, result.getStatusCodeValue());
        
        // Scenario - 2 | Test trade record creation with same version. It should update records instead of new
        
        trade = new Trade("T11", 1, "CP-12", "B1", Utils.convertToUtilDateStr(Utils.tomorrow()) , Utils.convertToUtilDateStr(Utils.today()), BOOLEAN_VALUE.N);
        
        request = new HttpEntity<>(trade);
         
        result = this.restTemplate.postForEntity(uri, request, Trade.class);
        
        assertEquals(201, result.getStatusCodeValue());
        assertEquals("T11", result.getBody().getTradeId());
        assertEquals("CP-12", result.getBody().getCounterPartyId());
        
    }
	

    @Test
    public void testPostTradeWithLowerVersion() throws URISyntaxException
    {
        final String baseUrl = "http://localhost:"+randomServerPort+"/trades/";
        URI uri = new URI(baseUrl);
        
        // Scenario - 1 | Test Trade record creation
        Trade trade = new Trade("T11", 2, "CP-11", "B1", Utils.convertToUtilDateStr(Utils.tomorrow()) , Utils.convertToUtilDateStr(Utils.today()), BOOLEAN_VALUE.N);
        
        HttpEntity<Trade> request = new HttpEntity<>(trade);
         
        ResponseEntity<Trade> result = this.restTemplate.postForEntity(uri, request, Trade.class);
        
        assertEquals(201, result.getStatusCodeValue());
        
        // Scenario - 2 | Test trade record creation with lower version. It should throw exception
        
        trade = new Trade("T11", 1, "CP-12", "B1", Utils.convertToUtilDateStr(Utils.tomorrow()) , Utils.convertToUtilDateStr(Utils.today()), BOOLEAN_VALUE.N);
        
        request = new HttpEntity<>(trade);
         
        result = this.restTemplate.postForEntity(uri, request, Trade.class);

        assertTrue(result.getStatusCodeValue()==500);
        
    }
    
    @Test
    public void testAllTradeRetrieval() throws URISyntaxException
    {
        final String baseUrl = "http://localhost:"+randomServerPort+"/trades/";
        URI uri = new URI(baseUrl);
        
        Trade trade = new Trade("T11", 1, "CP-11", "B1", Utils.convertToUtilDateStr(Utils.tomorrow()) , Utils.convertToUtilDateStr(Utils.today()), BOOLEAN_VALUE.N);
        
        HttpEntity<Trade> request = new HttpEntity<>(trade);
         
        this.restTemplate.postForEntity(uri, request, Trade.class);
        
        trade = new Trade("T12", 1, "CP-12", "B1", Utils.convertToUtilDateStr(Utils.tomorrow()) , Utils.convertToUtilDateStr(Utils.today()), BOOLEAN_VALUE.N);
        
        request = new HttpEntity<>(trade);
         
        this.restTemplate.postForEntity(uri, request, Trade.class);
        
        ResponseEntity<List> tradeEntitiesResponse = this.restTemplate.getForEntity(uri,List.class);
        
        assertTrue(tradeEntitiesResponse.getBody().size() >= 2);
        
    }
    
}
