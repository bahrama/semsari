package service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ViewProductDaoLocal;
import entity.ViewProduct;

/**
 * Session Bean implementation class ViewProductService
 */
@Stateless
public class ViewProductService implements ViewProductServiceLocal {

    /**
     * Default constructor. 
     */
    public ViewProductService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private ViewProductDaoLocal viewProductDaoLocal;
    
    @Override
    public void insertViewProduct(ViewProduct viewProduct){
    	 viewProductDaoLocal.insertViewProduct(viewProduct);
    }
    

}
