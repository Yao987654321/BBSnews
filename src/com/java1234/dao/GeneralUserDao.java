package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java1234.model.GeneralUser;

public class GeneralUserDao {
	
	public int addUser(Connection con,GeneralUser generalUser) throws SQLException{
		String sql="insert into general_user values(?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, generalUser.getGeneralusername());
		pstmt.setString(2, generalUser.getGeneraluserpassword());
		pstmt.setString(3, generalUser.getGeneraluseremil());
		return pstmt.executeUpdate();
	}
	
	public GeneralUser loginUser(Connection con,GeneralUser generalUser) throws SQLException {
		GeneralUser resultUser=null;
		String sql="select * from general_user where user_name=? and user_password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, generalUser.getGeneralusername());
		pstmt.setString(2, generalUser.getGeneraluserpassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			resultUser=new GeneralUser();
			resultUser.setGeneralusername(rs.getString("user_name"));
			resultUser.setGeneraluserpassword(rs.getString("user_password"));
		}
		return resultUser;
	}
	/*public GeneralUser CheikUsername(Connection con,GeneralUser generalUser) throws SQLException {
		GeneralUser resultUser=null;
		String sql = "select * from general_user where user_name";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, generalUser.getGeneralusername());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			resultUser=new GeneralUser();
			resultUser.setGeneralusername(rs.getString("user_name"));
		}
		return resultUser;
	}*/
	
}