package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ProductDaoLocal;
import entity.Product;
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
    public void insertProductEntity(Product product){
    	productDaoLocal.insertProductEntity(product);
    }
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<Product> findAllproductEntity(){
    	return productDaoLocal.findAllproductEntity();
    }
    
    
    @Override
    public Product findProductEntityById(long productId) throws Exception{
    	return productDaoLocal.findProductEntityById(productId);
    }
    
    
    @Override
    public void updateProductEntity(Product product) throws Exception{
    	productDaoLocal.updateProductEntity(product);
    }
    
    @Override
    public void deleteProductEntity(Product product){
    	productDaoLocal.deleteProductEntity(product);
    }

}
