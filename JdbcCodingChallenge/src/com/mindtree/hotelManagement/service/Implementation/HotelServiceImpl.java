package com.mindtree.hotelManagement.service.Implementation;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.hotelManagement.dao.HotelDao;
import com.mindtree.hotelManagement.dao.Implementation.HotelDaoImpl;
import com.mindtree.hotelManagement.entity.Hotel;
import com.mindtree.hotelManagement.exception.daoException.HotelManagementDaoException;
import com.mindtree.hotelManagement.exception.serviceException.CityNotFoundException;
import com.mindtree.hotelManagement.exception.serviceException.HotelManagementServiceException;
import com.mindtree.hotelManagement.exception.serviceException.HotelServiceException;
import com.mindtree.hotelManagement.service.HotelService;

public class HotelServiceImpl implements HotelService {
	private static HotelDao hotelDao = new HotelDaoImpl();
	@Override
	public String addHotel(Hotel hotelData) throws HotelManagementServiceException {
		
		String message ="";
		try {
			message = hotelDao.addHotel(hotelData);
		} catch (HotelManagementDaoException e) {
			throw new HotelServiceException(e.getMessage());
		}
		return message;
	}
	@Override
	public Hotel getHotel(int hotel_id) throws HotelServiceException {
		Hotel hotel=null;
		try {
			hotel=hotelDao.getHotel(hotel_id);
		} catch (HotelManagementDaoException e) {
			throw new HotelServiceException(e.getMessage());
		}
		return hotel;
	}
	@Override
	public void validateCity(String city) throws HotelManagementServiceException {
		try {
			boolean isPresent=hotelDao.isCityPresent(city);
			if(!isPresent)
				throw new CityNotFoundException("City is not available");
		} catch (HotelManagementDaoException e) {
			throw new HotelServiceException(e.getMessage());
		}
		
	}
	@Override
	public List<Hotel> getHotelsByCity(String city) throws HotelManagementServiceException {
		List<Hotel> hotels=null;
		try {
			hotels = hotelDao.getHotelByCity(city);
		} catch (HotelManagementDaoException e) {
			throw new HotelServiceException(e.getMessage());
		}
		return hotels;
		
	}

	
}
