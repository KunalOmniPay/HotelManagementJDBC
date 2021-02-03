package com.mindtree.hotelManagement.service;

import java.util.List;

import com.mindtree.hotelManagement.entity.Hotel;
import com.mindtree.hotelManagement.exception.serviceException.HotelManagementServiceException;

public interface HotelService {

	String addHotel(Hotel hotelData) throws HotelManagementServiceException;

	Hotel getHotel(int hotel_id) throws HotelManagementServiceException;

	void validateCity(String city) throws HotelManagementServiceException;

	List<Hotel> getHotelsByCity(String city) throws HotelManagementServiceException;;

}
