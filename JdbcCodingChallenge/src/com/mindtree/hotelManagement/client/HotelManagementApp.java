package com.mindtree.hotelManagement.client;

import java.util.List;
import java.util.Scanner;

import com.mindtree.hotelManagement.entity.Hotel;
import com.mindtree.hotelManagement.entity.Room;
import com.mindtree.hotelManagement.exception.serviceException.HotelManagementServiceException;
import com.mindtree.hotelManagement.service.HotelService;
import com.mindtree.hotelManagement.service.RoomService;
import com.mindtree.hotelManagement.service.Implementation.HotelServiceImpl;
import com.mindtree.hotelManagement.service.Implementation.RoomServiceImpl;

public class HotelManagementApp {
	private static Scanner sc=new Scanner(System.in);
	private static HotelService hotelService=new HotelServiceImpl();
	private static RoomService roomService = new RoomServiceImpl();
	public static void main(String[] args) {
	boolean exitMenu=false;
	String message="";
	do {
		displayMenu();
		int choice=sc.nextInt();
		sc.nextLine();
		switch(choice)
		{
		case 1:
			try {
				message= hotelService.addHotel(getHotelData());
			} catch (HotelManagementServiceException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(message);
			break;
		case 2:
			try {
				message=roomService.addRoom(getRoomData());
			} catch (HotelManagementServiceException e) {
				System.out.println(e.getMessage());
			}
		break;
		case 3:
			System.out.println("Enter city");
			String city=sc.nextLine();
			try {
				hotelService.validateCity(city);
			} catch (HotelManagementServiceException e) {
				System.out.println(e.getMessage());
			}
			try {
				List<Hotel> hotels = hotelService.getHotelsByCity(city);
				displayHotels(hotels);
			} catch (HotelManagementServiceException e) {
				System.out.println(e);
			}
			break;
		case 4:
			exitMenu=true;
			break;
		default:
			System.out.println("Wrong choice, choose again");
		}
		
	}while(!exitMenu);
	
}
	private static void displayHotels(List<Hotel> hotels) {
		for(Hotel hotel : hotels)
		{
			System.out.println("Hotel Id - " +hotel.getHotelId());
			System.out.println("Hotel City - " + hotel.getCity());
			System.out.println("Hotel Name - " + hotel.getName());
		}
		
	}
	public static void displayMenu()
	{
		System.out.println("1. Create Hotel");
		System.out.println("2. Create Room");
		System.out.println("3. Show Hotel Info by city");
		System.out.println("Exit the menu");
	}
	public static Hotel getHotelData()
	{
		System.out.println("Enter hotel id");
		int id= sc.nextInt();
		sc.nextLine();
		System.out.println("ENter hotel name");
		String name=sc.nextLine();
		System.out.println("Enter hotel city");
		String city=sc.nextLine();
		Hotel hotel=new Hotel(id, name, city);
		return hotel;
	}
	public static Room getRoomData()
	{	Room room=null;
		System.out.println("Enter room id");
		int id=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter room type");
		String type=sc.nextLine();
		System.out.println("Enter room cost");
		int cost=sc.nextInt();
		System.out.println("Enter hotel id");
		int hotel_id=sc.nextInt();
		try {
			Hotel hotel= hotelService.getHotel(hotel_id);
			room=new Room(id, type, cost, hotel);
		} catch (HotelManagementServiceException e) {
			System.out.println(e.getMessage());
		}
		return room;
		
	}
}
