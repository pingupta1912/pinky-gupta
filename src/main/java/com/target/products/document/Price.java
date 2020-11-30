package com.target.products.document;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Price {

	@NotNull
	private Float cost;

	@NotEmpty
	private String currency;

	public Price() {
		super();
	}
	public Price(Float cost, String currency) {
		super();
		this.cost = cost;
		this.currency = currency;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
