package org.bunny.skyfire.model.accounts;

import java.math.BigDecimal;

public class AccountHistory {
	
	private String created_at;
	private Integer id;    
    private BigDecimal amount;
    private BigDecimal balance;
    private String type;
    private Detail details;

    public AccountHistory() {}

	public AccountHistory(String created_at, Integer id, BigDecimal amount, BigDecimal balance, String type,
			Detail details) {
		this.id = id;
		this.created_at = created_at;
		this.amount = amount;
		this.balance = balance;
		this.type = type;
		this.details = details;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Detail getDetails() {
		return details;
	}

	public void setDetails(Detail details) {
		this.details = details;
	}
    
}
