package space.kfclts.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import space.kfclts.app.ws.ui.model.request.UserDetailsRequestModel;
import space.kfclts.app.ws.ui.model.response.UserRest;
import space.kfclts.app.ws.userservice.UserService;

@Service
public class UserServiceImpl implements UserService {

	Map<String, UserRest> users;
	
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		// TODO Auto-generated method stub
		UserRest user = new UserRest();
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setEmail(userDetails.getEmail());
//		user.setUserId(userDetails.getPassword());

		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		if (users == null)
			users = new HashMap<>();
		users.put(userId, user);
		
		return user;
	}

}
