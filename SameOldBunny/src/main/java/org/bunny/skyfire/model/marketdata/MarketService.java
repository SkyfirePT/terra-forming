package org.bunny.skyfire.model.marketdata;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.List;

import org.bunny.skyfire.resource.Utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.research.ws.wadl.HTTPMethods;

public class MarketService {
		
	String body = "";	
	
	Utils util = new Utils();
	
	//GET products
	public List<Product> getMarketDataProducts() throws InvalidKeyException, JsonParseException, JsonMappingException, IOException {
		
		String requestPath ="/products";
		
		ObjectMapper mapper = new ObjectMapper();

		String output = util.apiCon(requestPath, HTTPMethods.GET.toString(), body, false);
		
		List<Product> mrkProducts = mapper.readValue(output, new TypeReference<List<Product>>() {});
		
		return mrkProducts;

	}
	
	//GET marketData by product ID and desired level 1/2/3
	public MarketData getMarketDataProduct(String productId, int level) throws InvalidKeyException, JsonParseException, JsonMappingException, IOException {
		
		String requestPath ="/products/" + productId + "/book?level=" + level;
		
		ObjectMapper mapper = new ObjectMapper();

		String output = util.apiCon(requestPath, HTTPMethods.GET.toString(), body, false);
		
		MarketData mrkProdMarketData = mapper.readValue(output, MarketData.class);
		
		return mrkProdMarketData;

	}
	
	//GET Ticker by productID
	public Ticker getMarketDataTicker(String productId) throws InvalidKeyException, JsonParseException, JsonMappingException, IOException {
		
		String requestPath ="/products/" + productId + "/ticker";
		
		ObjectMapper mapper = new ObjectMapper();

		String output = util.apiCon(requestPath, HTTPMethods.GET.toString(), body, false);
		
		Ticker mrkTicker = mapper.readValue(output, Ticker.class);
		
		return mrkTicker;

	}
	
	//GET last trades by productID
	public List<Trade> getMarketDataTrade(String productId) throws InvalidKeyException, JsonParseException, JsonMappingException, IOException {
		
		String requestPath ="/products/" + productId + "/trades";
		
		ObjectMapper mapper = new ObjectMapper();

		String output = util.apiCon(requestPath, HTTPMethods.GET.toString(), body, false);
		
		List<Trade> mrkTrades = mapper.readValue(output, new TypeReference<List<Trade>>() {});
		
		return mrkTrades;

	}

}
