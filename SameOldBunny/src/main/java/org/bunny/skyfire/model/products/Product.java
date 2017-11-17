package org.bunny.skyfire.model.products;

public class Product {
	
	private String id;
	private String base_currency;
	private String quote_currency;
	private double base_min_size;
	private Integer base_max_size;
	private double quote_increment;
	private String display_name;
	private String status;
	private boolean margin_enabled;
	private String status_message;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBase_currency() {
		return base_currency;
	}
	public void setBase_currency(String base_currency) {
		this.base_currency = base_currency;
	}
	public String getQuote_currency() {
		return quote_currency;
	}
	public void setQuote_currency(String quote_currency) {
		this.quote_currency = quote_currency;
	}
	public double getBase_min_size() {
		return base_min_size;
	}
	public void setBase_min_size(double base_min_size) {
		this.base_min_size = base_min_size;
	}
	public int getBase_max_size() {
		return base_max_size;
	}
	public void setBase_max_size(int base_max_size) {
		this.base_max_size = base_max_size;
	}
	public double getQuote_increment() {
		return quote_increment;
	}
	public void setQuote_increment(double quote_increment) {
		this.quote_increment = quote_increment;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isMargin_enabled() {
		return margin_enabled;
	}
	public void setMargin_enabled(boolean margin_enabled) {
		this.margin_enabled = margin_enabled;
	}
	public String getStatus_message() {
		return status_message;
	}
	public void setStatus_message(String status_message) {
		this.status_message = status_message;
	}	

}
