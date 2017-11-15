package org.bunny.skyfire.resource;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import java.time.Instant;

import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class Utils {
	
	private static String basePath = "https://api.gdax.com";
	
//	public Map<String, String> httpMethod = fillMethods(); 
//	
//	public static Map<String,String> fillMethods(){
//		
//		Map<String, String> methods = new HashMap<String,String>();
//		
//		methods.put("GET", "GET");
//		methods.put("PUT", "PUT");
//		methods.put("DELETE", "DELETE");
//		
//		return methods;
//		
//	}	

	public  String apiCon(String req, String met, String bod ) throws InvalidKeyException {
		
		MultivaluedMap<String, Object> queryParams = queryParamsHeader(req, met, bod);
		
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target(basePath + req);
		Builder builder = target.request(MediaType.APPLICATION_JSON);
		Response response = builder.headers(queryParams).get();
		
		return response.readEntity(String.class);
		
	}

	public MultivaluedMap<String, Object> queryParamsHeader(String requestPath, String method, String body) throws InvalidKeyException {
		
		MultivaluedMap<String, Object> queryParams = new MultivaluedHashMap<String, Object>();
		
		String timeStamp = Instant.now().getEpochSecond() + "";
		String signature = generate(requestPath, method, body , timeStamp);
		
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
