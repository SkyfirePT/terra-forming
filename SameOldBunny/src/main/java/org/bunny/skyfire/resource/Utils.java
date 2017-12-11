package org.bunny.skyfire.resource;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.bunny.skyfire.controller.websocket.TickerService;
import org.bunny.skyfire.model.websocket.ticker.Ticker;
import org.omg.CORBA.TCKind;

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

	public String apiRestCon(String req, String met, String bod, boolean aut ) throws InvalidKeyException {
		
		Response response = null;
		
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target(basePath + req);
		Builder builder = target.request(MediaType.APPLICATION_JSON);
		
		if(aut == true) {
			MultivaluedMap<String, Object> queryParams = queryParamsHeader(req, met, bod);
			response = builder.headers(queryParams).get();
		}else
			response = builder.get();
		
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
	 
	 public void apiWebSocketCon (List<String> product_ids,List<String> channels) {
		 
		 String baseWebSocket = "{\"type\": \"subscribe\",";
		 String auxPid = "";
		 String auxChn = "";
		 TickerService tckrServ = new TickerService();
		 
		 try {
			 // open websocket
			 final WebSocketClient clientEndPoint = new WebSocketClient(new URI("wss://ws-feed.gdax.com"));

	         // add listener
			 clientEndPoint.addMessageHandler(new WebSocketClient.MessageHandler() {
				 public void handleMessage(String message) {
//					 System.out.println(message);
					 if(!message.contains("subscriptions")) {
						 if(message.contains("ticker")) {
							 try {
								tckrServ.TickerWebSocket(message);
							 } catch (IOException e) {
								 // TODO Auto-generated catch block
								 e.printStackTrace();
							 }
						 }else if(message.contains("heartbeat")) {
							 
						 }else if(message.contains("level2")) {
							 
						 }						 
					 }
                }
			 });

			 for(String pId:product_ids) {
				 if(auxPid.isEmpty()) {
					 auxPid = pId + "\"";	 
				 }else {
					 auxPid+= ",\"" + pId + "\""; 
				 }
			 }
			 
			 for(String chn:channels) {
				 if(auxChn.isEmpty()) {
					 auxChn = chn + "\"";	 
				 }else {
					 auxChn+= ",\"" + chn + "\""; 
				 }
			 }
            
            // send message to websocket	            
            clientEndPoint.sendMessage(baseWebSocket + "\"product_ids\": [\"" + auxPid + "],\"channels\": [\"" + auxChn + "]}");
            
//            clientEndPoint.sendMessage("{\"type\": \"subscribe\",\"product_ids\": [\"BTC-EUR\"],\"channels\": [\"level2\",{\r\n" + 
//            		"            \"name\": \"ticker\",\r\n" + 
//            		"            \"product_ids\": [\r\n" + 
//            		"                \"BTC-EUR\"" + 
//            		 
//            		"            ]\r\n" + 
//            		"        }]}");

            // wait 5 seconds for messages from websocket
            Thread.sleep(1000000000);

        } catch (InterruptedException ex) {
            System.err.println("InterruptedException exception: " + ex.getMessage());
        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        }
		 
	 }
	 
}
