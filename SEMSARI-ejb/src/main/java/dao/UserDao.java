package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Product;
import entity.User;

/**
 * Session Bean implementation class UserDao
 */
@Stateless
public class UserDao implements UserDaoLocal {

    /**
     * Default constructor. 
     */
    public UserDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    
    @Override
    public void insertUser(User user) throws Exception{
    	try {
    	entityManager.persist(user);
    	}catch (Exception e) {
			throw new Exception();
		}
    	}
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<User> findAllUser(){
    	return entityManager.createNamedQuery("User.findAll").getResultList();
    }
    
    
    @Override
    public User findUserById(long userId) throws Exception{
    	try {
    	return (User) entityManager.createNamedQuery("User.findById").setParameter("v_userId", userId).getSingleResult();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    @Override
    public User findUserByEmail(String email) throws Exception{
    	try {
    	return (User) entityManager.createNamedQuery("User.findByEmail").setParameter("v_email", email).getSingleResult();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    
    @Override
    public void updateUser(User user) throws Exception{
    	try {
    	entityManager.merge(user);
    	}catch (Exception e) {
			throw new Exception();
		}
    }
    
    @Override
    public void deleteUser(User user){
    	User homeEntity2=new User();
    	homeEntity2=entityManager.merge(user);
    	entityManager.remove(homeEntity2);
    }
    
    @Override
    public User findUserByUserToken(String userToken) throws Exception{
    	try {
    	return (User) entityManager.createNamedQuery("User.findByUserToken").setParameter("v_userToken", userToken).getSingleResult();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }

}
