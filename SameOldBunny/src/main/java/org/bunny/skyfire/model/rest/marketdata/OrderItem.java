package org.bunny.skyfire.model.rest.marketdata;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

public class OrderItem {
	private BigDecimal price;
    private BigDecimal size;
    private String orderId;
    private BigDecimal num;
    
    @JsonCreator
    public OrderItem(List<String> limitOrders) {
        price =  new BigDecimal(limitOrders.get(0));
        size = new BigDecimal(limitOrders.get(1));
        
        if (limitOrders.get(2).length() > 10) {
            orderId = limitOrders.get(2);
            num = new BigDecimal(1);
        } else {
            num = new BigDecimal(limitOrders.get(2));
        }
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
