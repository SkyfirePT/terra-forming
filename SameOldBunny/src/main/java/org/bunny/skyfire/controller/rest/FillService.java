package org.bunny.skyfire.controller.rest;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.List;

import org.bunny.skyfire.model.rest.fills.Fill;
//import org.bunny.skyfire.model.accounts.Account;
import org.bunny.skyfire.resource.Utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.research.ws.wadl.HTTPMethods;

public class FillService {
	
	String body = "";	
	
	Utils util = new Utils();
	
	//GET all fills
	public List<Fill> getFills() throws InvalidKeyException, JsonParseException, JsonMappingException, IOException {
		
		String requestPath ="/fills";
		
		ObjectMapper mapper = new ObjectMapper();

		String output = util.apiRestCon(requestPath, HTTPMethods.GET.toString(), body, true);
		
		List<Fill> fill = mapper.readValue(output, new TypeReference<List<Fill>>() {});
		
		return fill;

	}
	

}
