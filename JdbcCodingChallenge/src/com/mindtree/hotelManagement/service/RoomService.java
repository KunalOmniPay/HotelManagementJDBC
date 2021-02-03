package com.mindtree.hotelManagement.service;

import com.mindtree.hotelManagement.entity.Room;
import com.mindtree.hotelManagement.exception.serviceException.HotelManagementServiceException;

public interface RoomService {

	String addRoom(Room roomData) throws HotelManagementServiceException;

}
