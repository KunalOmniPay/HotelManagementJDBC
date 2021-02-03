package com.mindtree.hotelManagement.entity;

public class Room {

	private int roomNumber;
	private String roomType;
	private int cost;
	private Hotel hotel;

	public Room(int roomNumber, String roomType, int cost, Hotel hotel) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.cost = cost;
		this.hotel=hotel;
		
	}
	

	public Room() {
		super();
	}

	
	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
