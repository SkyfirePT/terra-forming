package org.bunny.skyfire.model.accounts;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.List;

import org.bunny.skyfire.resource.Utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.research.ws.wadl.HTTPMethods;

public class AccountService {
	
	String body = "";	
	
	Utils util = new Utils();
	
	//GET all accounts
	public List<Account> getAccounts() throws InvalidKeyException, JsonParseException, JsonMappingException, IOException {
		
		String requestPath ="/accounts";
		
		ObjectMapper mapper = new ObjectMapper();

		String output = util.apiCon(requestPath, HTTPMethods.GET.toString(), body);
		
		List<Account> acc = mapper.readValue(output, new TypeReference<List<Account>>() {});
		
		return acc;

	}
	
	//GET one account by account ID
	public Account getAccount(String accId) throws InvalidKeyException, JsonParseException, JsonMappingException, IOException {
		
		String requestPath ="/accounts/" +accId;
		
		ObjectMapper mapper = new ObjectMapper();
		
		String output = util.apiCon(requestPath, HTTPMethods.GET.toString(), body);
		Account acc = mapper.readValue(output,Account.class);
			
		return acc;
	}

}
