package intranet.naruka.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import intranet.naruka.controller.UserController;
import intranet.naruka.domain.User;
import intranet.naruka.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	static Logger logger = Logger.getLogger(UserController.class);
	
	
	@Autowired
	EntityManager entityManager;


	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() throws Exception {
		return entityManager.createQuery("from User").getResultList() ;//		entityManager.getTransaction().commit();
	}

	public boolean deleteUser(int userId) {
		try {
			entityManager.getTransaction().begin();
			User dbUser = entityManager.find(User.class, userId);
			if(dbUser!= null)
			{entityManager.remove(dbUser);
			entityManager.getTransaction().commit();
			return true;
			}

		} catch (Exception ex) {
			logger.error(ex);
		}
		return false;
	}

	public boolean addUser(User user) {
		try {
			entityManager.getTransaction().begin();
			System.out.println(user.getUserId());
			User dbUser = entityManager.find(User.class, user.getUserId());
			if(dbUser !=null){
				dbUser.setUserName(user.getUserName());
				dbUser.setEmailAddress(user.getEmailAddress());
				dbUser.setPassword(user.getPassword());
				dbUser.setIsActive(user.getIsActive());
				dbUser.setMobileNo(user.getMobileNo());
				dbUser.setRoleId(user.getRoleId());
			}
			else{
			entityManager.merge(user);
			}
			entityManager.getTransaction().commit();
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		
		}
		
		 finally {
		      if (entityManager.getTransaction().isActive())
		    	  entityManager.getTransaction().rollback();
			  }
		
		return false;
	}

	public UserServiceImpl() {
		super();
	}

	public User doLogin(String userName, String password )throws Exception{
		Query query = entityManager.createQuery(
				"SELECT e FROM User e WHERE e.userName = '" + userName + "' AND " + "e.password = '" + password + "'");
		return  (User) query.getSingleResult();
				    
	}
	
	
	public User getUser(int id) throws Exception {
		
		User dbUser = entityManager.find(User.class, id);
		if(dbUser!= null)
		return dbUser;
		return null;
	
	}

}
