package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Menu1;
import entity.Menu2;
import entity.Product;

/**
 * Session Bean implementation class Menu1Dao
 */
@Stateless
public class Menu1Dao implements Menu1DaoLocal {

    /**
     * Default constructor. 
     */
    public Menu1Dao() {
        // TODO Auto-generated constructor stub
    }
    
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    
    @Override
    public void insertMenu1(Menu1 menu1) throws Exception{
    	try {
    	entityManager.persist(menu1);
    	}catch (Exception e) {
			throw new Exception("menu3 rollback............................");
		}
    	}
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<Menu1> findAllMenu1(){
    	return entityManager.createNamedQuery("Menu1.findAll").getResultList();
    }
    
    
    @Override
    public Menu1 findMenu1ByItem(String item) throws Exception{
    	try {
    	return (Menu1) entityManager.createNamedQuery("Menu1.findByItem").setParameter("v_item", item).getSingleResult();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }

}
