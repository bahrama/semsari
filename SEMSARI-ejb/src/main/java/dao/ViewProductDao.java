package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Product;
import entity.ViewProduct;

/**
 * Session Bean implementation class ViewProductDao
 */
@Stateless
public class ViewProductDao implements ViewProductDaoLocal {

    /**
     * Default constructor. 
     */
    public ViewProductDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertViewProduct(ViewProduct viewProduct){
    	entityManager.persist(viewProduct);
    }

}
