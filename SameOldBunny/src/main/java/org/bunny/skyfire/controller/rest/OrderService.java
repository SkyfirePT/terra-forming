package org.bunny.skyfire.controller.rest;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.List;

import org.bunny.skyfire.model.rest.orders.Order;
import org.bunny.skyfire.resource.Utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.research.ws.wadl.HTTPMethods;

public class OrderService {

	String body = "";	
	
	String requestPath ="/orders";
	
	Utils util = new Utils();
	
	ObjectMapper mapper = new ObjectMapper();
	
	//GET orders Parameters status -> open,pending,active / product_id
	
	public List<Order> getOrders() throws InvalidKeyException, JsonParseException, JsonMappingException, IOException {

		String output = util.apiRestCon(requestPath, HTTPMethods.GET.toString(), body, true);
		
		List<Order> orders = mapper.readValue(output, new TypeReference<List<Order>>() {});
		
		return orders;

	}
	
	public List<Order> getOrders(List<String> status, String productId) throws InvalidKeyException, JsonParseException, JsonMappingException, IOException {
		
		if(!status.isEmpty() ) {
			int s = status.size();
			for(String stt : status) {
				requestPath += "?status=" + stt;
				if(s > 1) {
					requestPath += "&";
					s--;
				}
			}
		}
		
		if(!productId.isEmpty()) {
			requestPath += "?product_id=" + productId;
		}		
		
		String output = util.apiRestCon(requestPath, HTTPMethods.GET.toString(), body, true);
		
		List<Order> orders = mapper.readValue(output, new TypeReference<List<Order>>() {});
		
		return orders;

	}
	
	//GET order by ID
	public Order getOrder(String orderId) throws InvalidKeyException, JsonParseException, JsonMappingException, IOException {
		
		requestPath +="/" + orderId;

		String output = util.apiRestCon(requestPath, HTTPMethods.GET.toString(), body, true);
		
		Order order = mapper.readValue(output, Order.class);
		
		return order;

	}
	
}
