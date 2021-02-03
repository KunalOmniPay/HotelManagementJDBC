package com.mindtree.hotelManagement.dao;

import java.util.List;

import com.mindtree.hotelManagement.entity.Hotel;
import com.mindtree.hotelManagement.exception.daoException.HotelManagementDaoException;

public interface HotelDao {

	String addHotel(Hotel hotelData) throws HotelManagementDaoException;

	Hotel getHotel(int hotel_id) throws HotelManagementDaoException;

	boolean isCityPresent(String city)  throws HotelManagementDaoException;

	List<Hotel> getHotelByCity(String city) throws HotelManagementDaoException;

	

}
