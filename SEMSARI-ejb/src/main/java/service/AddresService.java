package service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.AddresDaoLocal;
import entity.User;
import entity.UserAddress;

/**
 * Session Bean implementation class AddresService
 */
@Stateless
public class AddresService implements AddresServiceLocal {

    /**
     * Default constructor. 
     */
    public AddresService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private AddresDaoLocal addresDaoLocal;
    
    @Override
    public void insertUserAddres(UserAddress userAdres) throws Exception{
    	try {
    		addresDaoLocal.insertUserAddres(userAdres);
    	}catch (Exception e) {
			throw new Exception();
		}
    	}

    
    @Override
    public User findAddresByUserId(User user) throws Exception{
    	try {
    	return (User) addresDaoLocal.findAddresByUserId(user);
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
}
