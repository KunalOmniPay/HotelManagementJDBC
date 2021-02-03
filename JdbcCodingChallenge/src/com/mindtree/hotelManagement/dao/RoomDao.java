package com.mindtree.hotelManagement.dao;

import com.mindtree.hotelManagement.entity.Room;
import com.mindtree.hotelManagement.exception.daoException.HotelManagementDaoException;

public interface RoomDao {

	String addRoom(Room roomData) throws HotelManagementDaoException;
	

}
