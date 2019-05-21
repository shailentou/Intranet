package intranet.test.config;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import intranet.naruka.domain.User;
import intranet.naruka.service.UserService;
 

@ContextConfiguration({"/PersistenceConfiguration.xml"})
@SpringJUnitConfig(InfrastructureContextConfiguration.class)
public class InfrastructureContextConfiguration {

	@Autowired
	UserService userService;
   
    @Test 
    public void main() throws Exception {
    	List <User> user2;
    	for(int i = 1; i<50; i++) {
    	User user1= new User();
    	user1.setUserId(i);
    	user1.setUserName("User " + i);
    	
    	userService.addUser(user1);
    	}
    	user2=userService.getAllUsers();
    	for(int i = 30; i<40; i++) {
        	
        	userService.deleteUser(i);
        	}
    	user2=userService.getAllUsers();
    	
    	System.out.println("test"+ user2.toString());
    	
    	
     }

}
