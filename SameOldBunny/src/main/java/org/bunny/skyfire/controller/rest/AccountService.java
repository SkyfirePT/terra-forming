package org.bunny.skyfire.controller.rest;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.List;

import org.bunny.skyfire.model.rest.accounts.Account;
import org.bunny.skyfire.model.rest.accounts.AccountHistory;
import org.bunny.skyfire.model.rest.accounts.AccountHolds;
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

		String output = util.apiRestCon(requestPath, HTTPMethods.GET.toString(), body, true);
		
		List<Account> acc = mapper.readValue(output, new TypeReference<List<Account>>() {});
		
		return acc;

	}
	
	//GET one account by account ID
	public Account getAccount(String accId) throws InvalidKeyException, JsonParseException, JsonMappingException, IOException {
		
		String requestPath ="/accounts/" +accId;
		
		ObjectMapper mapper = new ObjectMapper();
		
		String output = util.apiRestCon(requestPath, HTTPMethods.GET.toString(), body, true);
		Account acc = mapper.readValue(output,Account.class);
			
		return acc;
	}
	
	//GET account History by account ID
	public List<AccountHistory> getAccountLedger(String accId) throws InvalidKeyException, JsonParseException, JsonMappingException, IOException {
		
		String requestPath ="/accounts/" + accId + "/ledger";
		
		ObjectMapper mapper = new ObjectMapper();
		
		String output = util.apiRestCon(requestPath, HTTPMethods.GET.toString(), body, true);
		List<AccountHistory> accHist = mapper.readValue(output,new TypeReference<List<AccountHistory>>() {});
			
		return accHist;
	}
	
	//GET account Holds by account ID
	public List<AccountHolds> getAccountHolds(String accId) throws InvalidKeyException, JsonParseException, JsonMappingException, IOException{
		
		String requestPath ="/accounts/" + accId + "/holds";
		
		ObjectMapper mapper = new ObjectMapper();
		
		String output = util.apiRestCon(requestPath, HTTPMethods.GET.toString(), body, true);
		List<AccountHolds> accHold = mapper.readValue(output,new TypeReference<List<AccountHolds>>() {});
		
		return accHold;
	}
	
	
	
//	 * /accounts/<account_id>/holds
	
	

}
