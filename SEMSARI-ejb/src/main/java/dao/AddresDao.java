package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.User;
import entity.UserAddress;

/**
 * Session Bean implementation class AddresDao
 */
@Stateless
public class AddresDao implements AddresDaoLocal {

    /**
     * Default constructor. 
     */
    public AddresDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    
    @Override
    public void insertUserAddres(UserAddress userAdres) throws Exception{
    	try {
    	entityManager.persist(userAdres);
    	}catch (Exception e) {
			throw new Exception();
		}
    	}

    
    @Override
    public User findAddresByUserId(User user) throws Exception{
    	try {
    	return (User) entityManager.createNamedQuery("UserAddress.findByUser").setParameter("v_user", user).getSingleResult();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }

}
