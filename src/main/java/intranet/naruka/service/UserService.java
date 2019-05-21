package intranet.naruka.service;

import java.util.List;

import intranet.naruka.domain.User;

public interface UserService {

	public boolean addUser(User user);

	public boolean deleteUser(int userId);

	public List<User> getAllUsers()  throws Exception;

	public User getUser(int id)throws Exception;
	
	public User doLogin(String userName, String password)throws Exception;

}
