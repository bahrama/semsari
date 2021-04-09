package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Product;
import entity.ProductEntity;

/**
 * Session Bean implementation class ProductDao
 */
@Stateless
public class ProductDao implements ProductDaoLocal {

    /**
     * Default constructor. 
     */
    public ProductDao() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    
    @Override
    public void insertProductEntity(Product product){
    	entityManager.persist(product);
    }
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<Product> findAllproductEntity(){
    	return entityManager.createNamedQuery("Product.findAll").getResultList();
    }
    
    
    @Override
    public Product findProductEntityById(long productId) throws Exception{
    	try {
    	return (Product) entityManager.createNamedQuery("Product.findByProductId").setParameter("v_productId", productId).getSingleResult();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    
    @Override
    public void updateProductEntity(Product product) throws Exception{
    	try {
    	entityManager.merge(product);
    	}catch (Exception e) {
			throw new Exception();
		}
    }
    
    @Override
    public void deleteProductEntity(Product product){
    	Product homeEntity2=new Product();
    	homeEntity2=entityManager.merge(product);
    	entityManager.remove(homeEntity2);
    }
}
