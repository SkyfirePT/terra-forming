package org.bunny.skyfire.model.websocket.ticker;

import java.math.BigDecimal;
import java.util.Date;

public class Ticker {

	private String type;
    private Integer trade_id;
    private BigDecimal sequence;
    private Date time;
    private String product_id;
    private Double price;
    private String side;
    private BigDecimal last_size;
    private BigDecimal best_bid;
    private BigDecimal best_ask;
    private BigDecimal open_24h;
    private BigDecimal volume_24h;
	private BigDecimal low_24h;
    private BigDecimal high_24h;
    private BigDecimal volume_30d;
    
//    7 known properties: "size", "trade_id", "price", "volume", "bid", "ask", "time"
    
    public Ticker() {}  
    
	public Ticker(String type, Integer trade_id, BigDecimal sequence, Date time, String product_id, Double price,
			String side, BigDecimal last_size, BigDecimal best_bid, BigDecimal best_ask, BigDecimal open_24h,
			BigDecimal volume_24h, BigDecimal low_24h, BigDecimal high_24h, BigDecimal volume_30d) {
		super();
		this.type = type;
		this.trade_id = trade_id;
		this.sequence = sequence;
		this.time = time;
		this.product_id = product_id;
		this.price = price;
		this.side = side;
		this.last_size = last_size;
		this.best_bid = best_bid;
		this.best_ask = best_ask;
		this.open_24h = open_24h;
		this.volume_24h = volume_24h;
		this.low_24h = low_24h;
		this.high_24h = high_24h;
		this.volume_30d = volume_30d;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getTrade_id() {
		return trade_id;
	}
	public void setTrade_id(Integer trade_id) {
		this.trade_id = trade_id;
	}
	public BigDecimal getSequence() {
		return sequence;
	}
	public void setSequence(BigDecimal sequence) {
		this.sequence = sequence;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public BigDecimal getLast_size() {
		return last_size;
	}
	public void setLast_size(BigDecimal last_size) {
		this.last_size = last_size;
	}
	public BigDecimal getBest_bid() {
		return best_bid;
	}
	public void setBest_bid(BigDecimal best_bid) {
		this.best_bid = best_bid;
	}
	public BigDecimal getBest_ask() {
		return best_ask;
	}
	public void setBest_ask(BigDecimal best_ask) {
		this.best_ask = best_ask;
	}
	public BigDecimal getOpen_24h() {
		return open_24h;
	}
	public void setOpen_24h(BigDecimal open_24h) {
		this.open_24h = open_24h;
	}
	public BigDecimal getVolume_24h() {
		return volume_24h;
	}
	public void setVolume_24h(BigDecimal volume_24h) {
		this.volume_24h = volume_24h;
	}
	public BigDecimal getLow_24h() {
		return low_24h;
	}
	public void setLow_24h(BigDecimal low_24h) {
		this.low_24h = low_24h;
	}
	public BigDecimal getHigh_24h() {
		return high_24h;
	}
	public void setHigh_24h(BigDecimal high_24h) {
		this.high_24h = high_24h;
	}
	public BigDecimal getVolume_30d() {
		return volume_30d;
	}
	public void setVolume_30d(BigDecimal volume_30d) {
		this.volume_30d = volume_30d;
	}
	
}
