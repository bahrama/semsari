package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.UserDaoLocal;
import entity.User;

/**
 * Session Bean implementation class UserService
 */
@Stateless
public class UserService implements UserServiceLocal {

    /**
     * Default constructor. 
     */
    public UserService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private UserDaoLocal userDaoLocal;
    
    @Override
    public void insertUser(User user) throws Exception{
    	userDaoLocal.insertUser(user);
    }
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<User> findAllUser(){
    	return userDaoLocal.findAllUser();
    }
    
    
    @Override
    public User findUserById(long userId) throws Exception{
    	return userDaoLocal.findUserById(userId);
    }
    
    
    @Override
    public void updateUser(User user) throws Exception{
    	userDaoLocal.updateUser(user);
    }
    
    @Override
    public void deleteUser(User user){
    	userDaoLocal.deleteUser(user);
    }

}
