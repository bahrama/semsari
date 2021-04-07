package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ProductDaoLocal;
import entity.ProductEntity;

/**
 * Session Bean implementation class ProductService
 */
@Stateless
public class ProductService implements ProductServiceLocal {

    /**
     * Default constructor. 
     */
    public ProductService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private ProductDaoLocal productDaoLocal;
    
    @Override
    public void insertProductEntity(ProductEntity productEntity){
    	productDaoLocal.insertProductEntity(productEntity);
    }
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<ProductEntity> findAllproductEntity(){
    	return productDaoLocal.findAllproductEntity();
    }
    
    
    @Override
    public ProductEntity findProductEntityById(long productId) throws Exception{
    	return productDaoLocal.findProductEntityById(productId);
    }
    
    
    @Override
    public void updateProductEntity(ProductEntity productEntity) throws Exception{
    	productDaoLocal.updateProductEntity(productEntity);
    }
    
    @Override
    public void deleteProductEntity(ProductEntity productEntity){
    	productDaoLocal.deleteProductEntity(productEntity);
    }

}
