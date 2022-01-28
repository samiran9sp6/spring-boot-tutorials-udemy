package com.hateoas.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hateoas.model.User;

@Component
public class UserService {
	static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(1,"Samiran","25",new Date()));
		users.add(new User(2,"Priyanka","26",new Date()));
		users.add(new User(3,"Souvik","23",new Date()));
	}

	public List<User> getUsers(){
		return users;
	}
	
	public User getUser(int id) {
		for (Iterator iterator = users.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
