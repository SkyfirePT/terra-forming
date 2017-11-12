package org.bunny.skyfire.rest.client;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Invocation.Builder;

import org.bunny.skyfire.model.accounts.Account;
import org.bunny.skyfire.resource.DataStorage;

public class RestApiClient {
	
	/*
	 * GET
	 * /accounts
	 * /accounts/<account-id>
	 * /accounts/<account-id>/ledger
	 * /accounts/<account_id>/holds
	 * /orders
	 * /orders/<order-id>
	 * /fills
	 * /funding
	 * /position
	 * /payment-methods
	 * /coinbase-accounts
	 * /reports/:report_id
	 * /users/self/trailing-volume
	 * /products
	 * /products/<product-id>/book
	 * /products/<product-id>/ticker
	 * /products/<product-id>/trades
	 * /products/<product-id>/candles
	 * /products/<product-id>/stats
	 * /currencies
	 * /time
	 * 
	 * POST
	 * /orders
	 * /funding/repay
	 * /profiles/margin-transfer
	 * /position/close
	 * /deposits/payment-method
	 * /deposits/coinbase-account
	 * /withdrawals/payment-method
	 * /withdrawals/coinbase-account
	 * /withdrawals/crypto
	 * /reports
	 * 
	 * DELETE
	 * /orders/<order-id>
	 * /orders
	 * 
	 */
	
	
	
	
	public static void main(String[] args) throws InvalidKeyException  {
		// TODO Auto-generated method stub
		
		String basePath = "https://api.gdax.com";
		String requestPath ="/accounts/139ed7d5-445f-4440-a366-33b05b3fea43";
				
		List<String> method = new ArrayList<String>();
		
		method.add("GET");
		method.add("POST");
		method.add("DELETE");
		
		String body = "";		
		
		MultivaluedMap<String, Object> queryParams = queryParamsHeader(requestPath, method.get(0), body);
		
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target(basePath + requestPath);
		Builder builder = target.request(MediaType.APPLICATION_JSON);
		
		Account response = (Account) builder.headers(queryParams).get(new GenericType(Account.class));
//		Account acc = response.readEntity(Account.class);
			
		System.out.println(response.getCurrency());
//		System.out.print(response.readEntity(new GenericType<List<Account>>() {}));
		
	}

	public static MultivaluedMap<String, Object> queryParamsHeader(String requestPath, String method, String body) throws InvalidKeyException {
		
		MultivaluedMap<String, Object> queryParams = new MultivaluedHashMap<String, Object>();
		RestApiClient res = new RestApiClient();
		
		String timeStamp = Instant.now().getEpochSecond() + "";
		String signature = res.generate(requestPath, method, body , timeStamp);
		
	    queryParams.add("accept", "application/json");
	    queryParams.add("content-type", "application/json");
		queryParams.add("CB-ACCESS-KEY", DataStorage.getApikey());
		queryParams.add("CB-ACCESS-SIGN", signature);
		queryParams.add("CB-ACCESS-TIMESTAMP", timeStamp);
		queryParams.add("CB-ACCESS-PASSPHRASE", DataStorage.getPassphrase());
		
		return queryParams;
		
	}	
	
	 public String generate(String requestPath, String method, String body, String timestamp) throws InvalidKeyException {
		 
		 Mac sha256 = null;
		 String prehash = "";
		 
		 try{
			 prehash = timestamp + method.toUpperCase() + requestPath + body;
			 byte[] secretDecoded = Base64.getDecoder().decode(DataStorage.getApisecret());
			 SecretKeySpec keyspec = new SecretKeySpec(secretDecoded, "HmacSHA256");
			 
			 sha256 = Mac.getInstance("HmacSHA256");
			 sha256.init(keyspec);
    
		 }catch (NoSuchAlgorithmException ex){
			 ex.printStackTrace();
		 }
		 return Base64.getEncoder().encodeToString(sha256.doFinal(prehash.getBytes()));		            
	        
	 }
	 
}
