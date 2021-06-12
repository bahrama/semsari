package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Blog;
import entity.Menu1;
import entity.Menu2;
import entity.Menu3;

/**
 * Session Bean implementation class Menu3Dao
 */
@Stateless
public class Menu3Dao implements Menu3DaoLocal {

    /**
     * Default constructor. 
     */
    public Menu3Dao() {
        // TODO Auto-generated constructor stub
    }

    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    
    @Override
    public void insertMenu3(Menu3 menu3) throws Exception{
    	try {
    	entityManager.persist(menu3);
    	}catch (Exception e) {
			throw new Exception("menu3 rollback............................");
		}
    	}
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<Menu3> findAllMenu3(){
    	return entityManager.createNamedQuery("Menu3.findAll").getResultList();
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Menu3> findMenu3ByMenu2(Menu2 menu2) throws Exception{
    	try {
    	return entityManager.createNamedQuery("Menu3.findByMenu2").setParameter("v_menu2", menu2).getResultList();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
}
