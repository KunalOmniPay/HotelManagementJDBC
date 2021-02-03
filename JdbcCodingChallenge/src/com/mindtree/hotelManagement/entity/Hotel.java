package com.mindtree.hotelManagement.entity;

public class Hotel {

	private int hotelId;
	private String name, city;

	public Hotel() {
		super();
	}

	public Hotel(int hotelId, String name, String city) {
		super();
		this.hotelId = hotelId;
		this.name = name;
		this.city = city;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
