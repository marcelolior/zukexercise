package com.zuk.group.server.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.zuk.group.beans.view.UserResponse;

@Controller
public class UserController {

	public List<UserResponse> searchUsers(String lastname) {
		List<UserResponse> result = new ArrayList<>();
		
		//initialize the DB connection,
		MySQLConnect mySQLConnect = new MySQLConnect();

		//2.run query
		String sql = "SELECT name, lastname FROM users where lower(lastname) =\"" + lastname.toLowerCase() + "\" ORDER BY name" ;
		try {
		    Statement statement = mySQLConnect.connect().createStatement();
		    
			//3.get results
		    if (statement!=null) {
		    	ResultSet rs = statement.executeQuery(sql);
		    	UserResponse userResponse = null;
		    	while (rs.next()){
		    		userResponse = new UserResponse(rs.getString(1), rs.getString(2));
		    		result.add(userResponse);
		    	}
		    	
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
			mySQLConnect.disconnect();
		}
		       				
		return result;
	}
	

}
