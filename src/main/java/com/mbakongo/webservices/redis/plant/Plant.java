package com.mbakongo.webservices.redis.plant;

import java.math.BigDecimal;

import javax.validation.constraints.Size;

public class Plant {

	private Integer id;
	
	@Size(min = 2, max = 80, message = "Name should have at least 2 characters and a maximum of 80")
	private String name;
	
	private String sun;
	
	private String light;
	
	private String water;
	
	private BigDecimal price;
	
	

	public Plant(Integer id, String name, String sun, String light, String water, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.sun = sun;
		this.light = light;
		this.water = water;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSun() {
		return sun;
	}

	public void setSun(String sun) {
		this.sun = sun;
	}

	public String getLight() {
		return light;
	}

	public void setLight(String light) {
		this.light = light;
	}

	public String getWater() {
		return water;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Plant [id=" + id + ", name=" + name + ", sun=" + sun + ", light=" + light + ", water=" + water
				+ ", price=" + price + "]";
	}
	
	
}
