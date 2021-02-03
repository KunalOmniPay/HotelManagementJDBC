package com.mindtree.hotelManagement.dao.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.hotelManagement.dao.HotelDao;
import com.mindtree.hotelManagement.entity.Hotel;
import com.mindtree.hotelManagement.exception.daoException.ConnectionFailedException;
import com.mindtree.hotelManagement.exception.daoException.HotelDaoException;
import com.mindtree.hotelManagement.exception.daoException.HotelManagementDaoException;
import com.mindtree.hotelManagement.utility.JdbcConnection;

public class HotelDaoImpl implements HotelDao {

	@Override
	public String addHotel(Hotel hotelData) throws HotelManagementDaoException {
		String message = "";
		Connection con = null;
		try {
			con = JdbcConnection.getConnection();
		} catch (ConnectionFailedException e) {
			throw new HotelDaoException(e.getMessage());

		}
		String query = "insert into hotel values(?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, hotelData.getHotelId());
			ps.setString(2, hotelData.getName());
			ps.setString(3, hotelData.getCity());
			ps.executeUpdate();
			message = "Hotel updated successfully";

		} catch (SQLException e) {
			throw new HotelDaoException(e.getMessage());
		}
		return message;
	}

	@Override
	public Hotel getHotel(int hotel_id) throws HotelManagementDaoException {
		Hotel hotel = null;

		Connection con = null;
		try {
			con = JdbcConnection.getConnection();
		} catch (ConnectionFailedException e) {
			throw new HotelDaoException(e.getMessage());

		}
		String query = "select * from hotel where id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, hotel_id);
			rs = ps.executeQuery();
			rs.next();
			hotel = new Hotel(rs.getInt(1), rs.getString(2), rs.getString(2));

		} catch (SQLException e) {
			throw new HotelDaoException(e.getMessage());
		}
		return hotel;
	}

	@Override
	public boolean isCityPresent(String city) throws HotelManagementDaoException {

		Connection con = null;
		try {
			con = JdbcConnection.getConnection();
		} catch (ConnectionFailedException e) {
			throw new HotelDaoException(e.getMessage());

		}
		String query = "select * from hotel where city=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, city);
			rs = ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			

		} catch (SQLException e) {
			throw new HotelDaoException(e.getMessage());
		}
		return false;
		
	}

	@Override
	public List<Hotel> getHotelByCity(String city) throws HotelManagementDaoException {
		List<Hotel> hotels = new ArrayList<>();
		Connection con = null;
		try {
			con = JdbcConnection.getConnection();
		} catch (ConnectionFailedException e) {
			throw new HotelDaoException(e.getMessage());

		}
		String query = "select * from hotel where city=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, city);
			rs = ps.executeQuery();
			while(rs.next())
			{
				hotels.add(new Hotel(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}

		} catch (SQLException e) {
			throw new HotelDaoException(e.getMessage());
		}
		return hotels;
		
		
	}



}
