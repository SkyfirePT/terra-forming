package org.bunny.skyfire.controller.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bunny.skyfire.model.websocket.ticker.Ticker;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TickerService {
	
	public static List<Ticker> tckMessage = new ArrayList<>();
	
	public List<Ticker> getTckMessage() {
		return tckMessage;
	}

	public void setTckMessage(List<Ticker> tckMessage) {
		this.tckMessage = tckMessage;
	}

	public void TickerWebSocket(String message) throws JsonParseException, JsonMappingException, IOException {
	
		ObjectMapper mapper = new ObjectMapper();
		
		Ticker tck = mapper.readValue(message, Ticker.class);
		
		tckMessage.add(tck);
		
		setTckMessage(tckMessage);
		
	}

	

}
