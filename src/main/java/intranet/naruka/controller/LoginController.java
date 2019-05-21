package intranet.naruka.controller;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import intranet.naruka.domain.User;
import intranet.naruka.service.UserService;

@RestController
@RequestMapping("/login")
public class LoginController {
	static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/doLogin")
	public User doLogin(@RequestBody User user)
	{
		User dbuser =null ;
		try {
			 dbuser=userService.doLogin(user.getUserName() ,user.getPassword() );
		} catch (NoResultException e) {
			System.out.println("user not found");
		}
		catch(Exception e)
		{
			
		}
		return dbuser;
	}

	public String doLogout()
	{
		return "false";
	}
}
