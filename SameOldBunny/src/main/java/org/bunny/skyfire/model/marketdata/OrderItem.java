package org.bunny.skyfire.model.marketdata;

import java.math.BigDecimal;

public class OrderItem {
	private BigDecimal price;
    private BigDecimal size;
    private String orderId;
    private BigDecimal num;
    
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
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public BigDecimal getNum() {
		return num;
	}
	public void setNum(BigDecimal num) {
		this.num = num;
	}
    
    
}
