package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ProductDaoLocal;
import entity.Product;

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
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Product> findProductEntityByProductCat(String productCat1,String productCat2) throws Exception{
    	return productDaoLocal.findProductEntityByProductCat(productCat1, productCat2);
    }
    
	@Override
    public List<Product> findProductEntityByProductCat1(String productCat1) throws Exception{
		return productDaoLocal.findProductEntityByProductCat1(productCat1);
	}
	
    @Override
    public Product findProductEntityByName(String productName) throws Exception{
    	return productDaoLocal.findProductEntityByName(productName);
    }
    
	@Override
    public List<Product> findProductEntityByProductCat2(String productCat2) throws Exception{
		return productDaoLocal.findProductEntityByProductCat2(productCat2);
	}
	
	@Override
    public List<Product> findProductEntityByProductCat23(String productCat2,String productCat3) throws Exception{
	return productDaoLocal.findProductEntityByProductCat23(productCat2, productCat3);
	}
	

}
