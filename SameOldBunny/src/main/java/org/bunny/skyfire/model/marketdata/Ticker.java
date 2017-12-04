package org.bunny.skyfire.model.marketdata;

import java.math.BigDecimal;
import java.util.Date;

public class Ticker {
	
	private String trade_id;
	private BigDecimal price;
	private BigDecimal size;
	private BigDecimal bid;
	private BigDecimal ask;
	private BigDecimal volume;
	private Date time;
	
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
	public BigDecimal getBid() {
		return bid;
	}
	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}
	public BigDecimal getAsk() {
		return ask;
	}
	public void setAsk(BigDecimal ask) {
		this.ask = ask;
	}
	public BigDecimal getVolume() {
		return volume;
	}
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

}
