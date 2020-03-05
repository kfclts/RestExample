package space.kfclts.app.ws.ui.controller;

import javax.validation.Valid;

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

import space.kfclts.app.ws.ui.controller.ui.model.request.UserDetailRequestModel;
import space.kfclts.app.ws.ui.controller.ui.model.response.UserRest;

@RestController
@RequestMapping("users") // http://localhost:8000/users
public class UserController {

	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "30") int limit,
			@RequestParam(value = "sort", required = false) String sort) {
		return "Get User was called w/ page = " + page + " and limit = " + limit + " and sort = " + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		UserRest user = new UserRest();
		user.setFirstName("K");
		user.setLastName("FC");
		user.setEmail("kf@gm.co");
		user.setUserId("3393");

		return new ResponseEntity<UserRest>(user, HttpStatus.OK);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailRequestModel userDetails) {
		UserRest user = new UserRest();
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
//		user.setUserId(userDetails.getPassword());
		
		return new ResponseEntity<UserRest>(user, HttpStatus.CREATED);
	}

	@PutMapping
	public String updateUser() {
		return "Update User was called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "Delete User was called";
	}
}
