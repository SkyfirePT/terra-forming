package org.bunny.skyfire.model.websocket.level2;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Changes {

	private String side;
	private BigDecimal price;
	private BigDecimal size;
	
	@JsonCreator
    public Changes(List<String> l2Changes) {
	 
        side =  new String(l2Changes.get(0));
        price = new BigDecimal(l2Changes.get(1));
        size = new BigDecimal(l2Changes.get(2));
        
    }
	
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getSize() {
		return size;
	}
	public void setSize(BigDecimal size) {
		this.size = size;
	}
	
	
	
}
