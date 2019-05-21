package intranet.naruka.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import intranet.naruka.domain.User;
import intranet.naruka.service.UserService;



@RestController
@RequestMapping("/user")
public class UserController {
	static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/getAllUsers")
	public List<User> getAllUsers(ModelMap modelMap)  {
		List<User> userList= new ArrayList<User>();
		try{
			 userList= userService.getAllUsers();
		}
		catch(Exception e)
		{
			System.out.println("inside exception");
		}
		return userList;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getUser/{id}")
	public User getUsers(@PathVariable("id") int id) {
		User user=null;
		
		try {
			user=userService.getUser(id);	
		}
		catch(Exception e)
		{
			
		}
	return user;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addUser")
	public boolean addUser(@RequestBody User user)
	{
		return userService.addUser(user);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/deleteUser/{id}")
	public boolean deleteUser(@PathVariable("id") int userId)
	{
		return userService.deleteUser(userId);
	}
}
