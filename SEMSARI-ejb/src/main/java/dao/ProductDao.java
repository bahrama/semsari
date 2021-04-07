package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public void insertProductEntity(ProductEntity productEntity){
    	entityManager.persist(productEntity);
    }
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<ProductEntity> findAllproductEntity(){
    	return entityManager.createNamedQuery("ProductEntity.findAll").getResultList();
    }
    
    
    @Override
    public ProductEntity findProductEntityById(long productId) throws Exception{
    	try {
    	return (ProductEntity) entityManager.createNamedQuery("ProductEntity.findByProductId").setParameter("v_productId", productId).getSingleResult();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    
    @Override
    public void updateProductEntity(ProductEntity productEntity) throws Exception{
    	try {
    	entityManager.merge(productEntity);
    	}catch (Exception e) {
			throw new Exception();
		}
    }
    
    @Override
    public void deleteProductEntity(ProductEntity productEntity){
    	ProductEntity homeEntity2=new ProductEntity();
    	homeEntity2=entityManager.merge(productEntity);
    	entityManager.remove(homeEntity2);
    }
}
