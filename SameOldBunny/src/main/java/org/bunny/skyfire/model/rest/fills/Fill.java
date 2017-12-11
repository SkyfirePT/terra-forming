package org.bunny.skyfire.model.rest.fills;

import java.math.BigDecimal;

public class Fill {

	private Integer trade_id;
    private String product_id;
    private BigDecimal size;
    private String order_id;
    private String created_at;
    private String liquidity;
    private BigDecimal fee;
    private Boolean settled;
    private String side;
    private String user_id;
    
    public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	private String profile_id;
    private double price;
    
	public Integer getTrade_id() {
		return trade_id;
	}
	public void setTrade_id(Integer trade_id) {
		this.trade_id = trade_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public BigDecimal getSize() {
		return size;
	}
	public void setSize(BigDecimal size) {
		this.size = size;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getLiquidity() {
		return liquidity;
	}
	public void setLiquidity(String liquidity) {
		this.liquidity = liquidity;
	}
	public BigDecimal getFee() {
		return fee;
	}
	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}
	public Boolean getSettled() {
		return settled;
	}
	public void setSettled(Boolean settled) {
		this.settled = settled;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
    
}
