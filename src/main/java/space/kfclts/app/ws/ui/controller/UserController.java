package space.kfclts.app.ws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") 	// http://localhost:8000/users
public class UserController {

	@GetMapping
	public String getUsers(@RequestParam(value="page") int page,
			@RequestParam(value="limit") int limit) {
		return "Get User was called w/ page = " + page + " and limit = " + limit;
	}
	
	@GetMapping(path = "/{userId}")
	public String getUser(@PathVariable String userId) {
		return "Get User was called w/ userId = " + userId;
	}
	
	@PostMapping
	public String createUser () {
		return "Create User was called";
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
