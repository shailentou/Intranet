package intranet.naruka.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;


public abstract class JPAUtil <T>  {
	@Autowired
	EntityManager entityManager;
	
	abstract public void jpaUtil ();

	private static EntityManagerFactory getSessionFactory()
	{
		return Persistence.createEntityManagerFactory("intranet");
	}
	
	public static EntityManager getEntityManager()
	{
		return  getSessionFactory().createEntityManager();
	}
	
	public static void closeSession(EntityManager entityManager)
	{
		entityManager.close();
	}

	public boolean add(T user) {
		try {
			entityManager.getTransaction().begin();
			
			/*System.out.println(t.getUserId());
			User dbUser = entityManager.find(User.class, user.getUserId());
			if(dbUser !=null){
				dbUser.setUserName(user.getUserName());
				dbUser.setEmailAddress(user.getEmailAddress());
				dbUser.setPassword(user.getPassword());
				dbUser.setIsActive(user.getIsActive());
				dbUser.setMobileNo(user.getMobileNo());
				dbUser.setRoleId(user.getRoleId());
			}
			else{*/
			entityManager.persist(user);
		//	}
			entityManager.getTransaction().commit();
			return true;

		} catch (Exception ex) {
			System.out.println("ddfdf"+ex.getMessage());
		
		}
		
		 finally {
		      if (entityManager.getTransaction().isActive())
		    	  entityManager.getTransaction().rollback();
			  }
		
		return false;
	}
	
	public static boolean add(){
		
		return false;
	}
	
	public static boolean update(){
		return false;
	}
	
	public static boolean delete(){
		
		return false;
	}
	
	public static boolean getAll() {
	
		return false;
	}
	
	public static boolean filterById(){
		return false;
	}
	
	
}
