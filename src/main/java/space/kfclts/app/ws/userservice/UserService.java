package space.kfclts.app.ws.userservice;

import space.kfclts.app.ws.ui.model.request.UserDetailsRequestModel;
import space.kfclts.app.ws.ui.model.response.UserRest;

public interface UserService {
	UserRest createUser(UserDetailsRequestModel userDetails);
}
