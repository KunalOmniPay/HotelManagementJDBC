package com.mindtree.hotelManagement.dao.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mindtree.hotelManagement.dao.RoomDao;
import com.mindtree.hotelManagement.entity.Room;
import com.mindtree.hotelManagement.exception.daoException.ConnectionFailedException;
import com.mindtree.hotelManagement.exception.daoException.HotelDaoException;
import com.mindtree.hotelManagement.exception.daoException.HotelManagementDaoException;
import com.mindtree.hotelManagement.exception.daoException.RoomDaoException;
import com.mindtree.hotelManagement.utility.JdbcConnection;

public class RoomDaoImpl implements RoomDao {

	@Override
	public String addRoom(Room roomData) throws HotelManagementDaoException {
		String message = "";
		Connection con = null;
		try {
			con = JdbcConnection.getConnection();
		} catch (ConnectionFailedException e) {
			throw new RoomDaoException(e.getMessage());

		}
		String query = "insert into room values(?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, roomData.getRoomNumber());
			ps.setString(2, roomData.getRoomType());
			ps.setInt(3, roomData.getCost());
			ps.setInt(4,roomData.getHotel().getHotelId());
			ps.executeUpdate();
			message = "Room Added successfully";

		} catch (SQLException e) {
			throw new HotelDaoException(e.getMessage());
		}
		return message;
	}

}
