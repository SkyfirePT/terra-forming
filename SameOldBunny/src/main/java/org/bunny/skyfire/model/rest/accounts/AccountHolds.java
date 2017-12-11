package org.bunny.skyfire.model.rest.accounts;

public class AccountHolds {

	private String id;
    private String account_id;
    private String created_at;
    private String updated_at;
    private double amount;
    private String type;
    private String ref;
    
    public AccountHolds() {}
    
	public AccountHolds(String id, String account_id, String created_at, String updated_at, double amount, String type,
			String ref) {
		this.id = id;
		this.account_id = account_id;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.amount = amount;
		this.type = type;
		this.ref = ref;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
    
}
