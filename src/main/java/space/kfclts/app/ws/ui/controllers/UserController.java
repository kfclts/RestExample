package space.kfclts.app.ws.ui.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import space.kfclts.app.ws.exceptions.UserServiceException;
import space.kfclts.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import space.kfclts.app.ws.ui.model.request.UserDetailsRequestModel;
import space.kfclts.app.ws.ui.model.response.UserRest;
import space.kfclts.app.ws.userservice.UserService;
import space.kfclts.app.ws.userservice.impl.UserServiceImpl;

@RestController
@RequestMapping("users") // http://localhost:8000/users
public class UserController {

	Map<String, UserRest> users;

	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "30") int limit,
			@RequestParam(value = "sort", required = false) String sort) {
		return "Get User was called w/ page = " + page + " and limit = " + limit + " and sort = " + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		if (true) throw new UserServiceException("A User Service Exception is thrown");
		
		// Make a exception
		String firstName = null;
		int length = firstName.length();
		
		
		if (users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		
		UserRest user = userService.createUser(userDetails);
		return new ResponseEntity<UserRest>(user, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
		UserRest storeUserDetails = users.get(userId);
		storeUserDetails.setFirstName(userDetails.getFirstName());
		storeUserDetails.setLastName(userDetails.getLastName());
		
		users.put(userId, storeUserDetails);
		
		return storeUserDetails;
	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		users.remove(userId);
		return ResponseEntity.noContent().build();
	}
}
