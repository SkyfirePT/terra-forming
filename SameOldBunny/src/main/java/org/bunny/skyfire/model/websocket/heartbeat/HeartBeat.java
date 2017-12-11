package org.bunny.skyfire.model.websocket.heartbeat;

import java.util.Date;

public class HeartBeat {

	private String type;
    private Integer sequence;
    private Integer last_trade_id;
    private String product_id;
    private Date time;
    
    public HeartBeat() {}
    
	public HeartBeat(String type, Integer sequence, Integer last_trade_id, String product_id, Date time) {
		super();
		this.type = type;
		this.sequence = sequence;
		this.last_trade_id = last_trade_id;
		this.product_id = product_id;
		this.time = time;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public Integer getLast_trade_id() {
		return last_trade_id;
	}
	public void setLast_trade_id(Integer last_trade_id) {
		this.last_trade_id = last_trade_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
