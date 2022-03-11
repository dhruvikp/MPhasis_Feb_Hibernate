package com.simplilearn.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address extends Object {

	private String street;

	private String city;

	private String state;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return this.street+", "+this.city+", "+this.state;
	}
}
