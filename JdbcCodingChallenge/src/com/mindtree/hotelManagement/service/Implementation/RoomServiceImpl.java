package com.mindtree.hotelManagement.service.Implementation;

import com.mindtree.hotelManagement.dao.RoomDao;
import com.mindtree.hotelManagement.dao.Implementation.RoomDaoImpl;
import com.mindtree.hotelManagement.entity.Room;
import com.mindtree.hotelManagement.exception.daoException.HotelManagementDaoException;
import com.mindtree.hotelManagement.exception.serviceException.HotelManagementServiceException;
import com.mindtree.hotelManagement.exception.serviceException.RoomServiceException;
import com.mindtree.hotelManagement.service.RoomService;

public class RoomServiceImpl implements RoomService {
 private static RoomDao roomDao = new RoomDaoImpl();
	@Override
	public String addRoom(Room roomData) throws HotelManagementServiceException {
		String message="";
		try {
			message=roomDao.addRoom(roomData);
		} catch (HotelManagementDaoException e) {
			throw new RoomServiceException(e.getMessage());
		}
		return message;
		
	}

	

}
