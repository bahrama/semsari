package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Menu1;
import entity.Menu2;
import entity.Menu3;

/**
 * Session Bean implementation class Menu2Dao
 */
@Stateless
public class Menu2Dao implements Menu2DaoLocal {

    /**
     * Default constructor. 
     */
    public Menu2Dao() {
        // TODO Auto-generated constructor stub
    }

    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertMenu2(Menu2 menu2) throws Exception{
    	try {
    	entityManager.persist(menu2);
    	}catch (Exception e) {
			throw new Exception("menu3 rollback............................");
		}
    	}
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<Menu2> findAllMenu2(){
    	return entityManager.createNamedQuery("Menu2.findAll").getResultList();
    }
    
    @Override
    public Menu2 findMenu2ByItem(String item) throws Exception{
    	try {
    	return (Menu2) entityManager.createNamedQuery("Menu2.findByItem").setParameter("v_item", item).getSingleResult();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Menu2> findMenu2ByMenu1(Menu1 menu1) throws Exception{
    	try {
    	return entityManager.createNamedQuery("Menu2.findByMenu1").setParameter("v_menu1", menu1).getResultList();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    
    
}
