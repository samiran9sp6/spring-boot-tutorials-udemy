package com.hateoas.model.controller;

import java.util.List;

//import static org.springframework.hateoas.EntityModel.of;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hateoas.model.User;
import com.hateoas.model.exception.UserNotFoundException;
import com.hateoas.service.UserService;

@RestController
@Component
@RequestMapping(path = "/api")
public class UserController {
	@Autowired
	public UserService userService;
	
	@GetMapping(path = "/users")
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/users/{id}")
	public EntityModel<User> getUser(@PathVariable int id) throws UserNotFoundException{
		User user = userService.getUser(id);
		if(null == user) {
			throw new UserNotFoundException("Not Found");
		}
		EntityModel<User> model = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers());
		WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).getUser(id));
		model.add(link.withRel("lists"));
		model.add(link2.withRel("details"));
		return model;
	}
	
}
