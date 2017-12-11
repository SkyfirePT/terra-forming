package org.bunny.skyfire.model.rest.marketdata;

import java.math.BigDecimal;
import java.util.Date;

public class Trade {

	private Date time; 
	private String trade_id;
    private BigDecimal price;
    private BigDecimal size;
    private String side;
    
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getTrade_id() {
		return trade_id;
	}
	public void setTrade_id(String trade_id) {
		this.trade_id = trade_id;
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
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
    
    
}
