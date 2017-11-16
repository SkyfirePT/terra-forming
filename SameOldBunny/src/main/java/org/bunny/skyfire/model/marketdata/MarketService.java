package org.bunny.skyfire.model.marketdata;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.List;

import org.bunny.skyfire.model.accounts.Account;
import org.bunny.skyfire.resource.Utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.research.ws.wadl.HTTPMethods;

public class MarketService {
	
//	[{
//		"id": "LTC-EUR",
//		"base_min_size": "0.01",
//		"base_max_size": "1000000",
//		"quote_increment": "0.01",
//	}, {
//		"id": "LTC-BTC",
//		"base_min_size": "0.01",
//		"base_max_size": "1000000",
//		"quote_increment": "0.00001",
//	}, {
//		"id": "LTC-USD",
//		"base_min_size": "0.01",
//		"base_max_size": "1000000",
//		"quote_increment": "0.01",
//	}, {
//		"id": "ETH-USD",
//		"base_min_size": "0.01",
//		"base_max_size": "5000",
//		"quote_increment": "0.01",
//	}, {
//		"id": "ETH-EUR",
//		"base_min_size": "0.01",
//		"base_max_size": "5000",
//		"quote_increment": "0.01",
//	}, {
//		"id": "ETH-BTC",
//		"base_min_size": "0.01",
//		"base_max_size": "5000",
//		"quote_increment": "0.00001",
//	}, {
//		"id": "BTC-USD",
//		"base_min_size": "0.01",
//		"base_max_size": "250",
//		"quote_increment": "0.01",
//	}, {
//		"id": "BTC-EUR",
//		"base_min_size": "0.01",
//		"base_max_size": "250",
//		"quote_increment": "0.01",
//	}, {
//		"id": "BTC-GBP",
//		"base_min_size": "0.01",
//		"base_max_size": "250",
//		"quote_increment": "0.01",
//	}
//]
	
	String body = "";	
	
	Utils util = new Utils();
	
	//GET products
	public List<MarketData> getProducts() throws InvalidKeyException, JsonParseException, JsonMappingException, IOException {
		
		String requestPath ="/products";
		
		ObjectMapper mapper = new ObjectMapper();

		String output = util.apiCon(requestPath, HTTPMethods.GET.toString(), body, false);
		
		List<MarketData> mrkData = mapper.readValue(output, new TypeReference<List<MarketData>>() {});
		
		return mrkData;

	}

}
