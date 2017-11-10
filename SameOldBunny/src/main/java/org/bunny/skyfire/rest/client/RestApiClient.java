package org.bunny.skyfire.rest.client;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Invocation.Builder;

import org.bunny.skyfire.resource.DataStorage;

public class RestApiClient {
	
	public static void main(String[] args) throws InvalidKeyException {
		// TODO Auto-generated method stub
		
		RestApiClient res = new RestApiClient();
		
		String timeStamp = Instant.now().getEpochSecond() + "";
		
		String signature = res.generate("/accounts", "GET", "", timeStamp);
		
		MultivaluedMap<String, Object> queryParams = new MultivaluedHashMap<String, Object>();
		
	    queryParams.add("accept", "application/json");
	    queryParams.add("content-type", "application/json");
		queryParams.add("CB-ACCESS-KEY", DataStorage.getApikey());
		queryParams.add("CB-ACCESS-SIGN", signature);
		queryParams.add("CB-ACCESS-TIMESTAMP", timeStamp);
		queryParams.add("CB-ACCESS-PASSPHRASE", DataStorage.getPassphrase());
		
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("https://api.gdax.com/accounts");
		Builder builder = target.request(MediaType.APPLICATION_JSON);
		
		Response response = builder.headers(queryParams).get();
		
		System.out.print(response.readEntity(String.class));
		
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
