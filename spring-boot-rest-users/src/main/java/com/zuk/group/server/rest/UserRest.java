package com.zuk.group.server.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zuk.group.beans.view.UserResponse;
import com.zuk.group.server.controller.UserController;

@RestController
public class UserRest {

	@Autowired
	private UserController userController;
	
	@RequestMapping(method = RequestMethod.GET, value="/users/search/{lastname}")
	@ResponseBody
	public List<UserResponse> searchUsers(@PathVariable("lastname") String lastname){
		return userController.searchUsers(lastname);
	}
	
}
