package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Product;

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
    public Product findProductEntityByName(String productName) throws Exception{
    	try {
    	return (Product) entityManager.createNamedQuery("Product.findByProductName").setParameter("v_productName", productName).getSingleResult();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Product> findProductEntityByProductCat(String productCat1,String productCat2) throws Exception{
    	try {
    	return  entityManager.createNamedQuery("Product.findByProductCat").setParameter("v_productCat1", productCat1).setParameter("v_productCat2", productCat2).getResultList();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Product> findProductEntityByProductCat23(String productCat2,String productCat3) throws Exception{
    	try {
    	return  entityManager.createNamedQuery("Product.findByProductCat23").setParameter("v_productCat2", productCat2).setParameter("v_productCat3", productCat3).getResultList();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Product> findProductEntityByProductCat1(String productCat1) throws Exception{
    	try {
    	return  entityManager.createNamedQuery("Product.findByProductCat1").setParameter("v_productCat1", productCat1).getResultList();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Product> findProductEntityByProductCat2(String productCat2) throws Exception{
    	try {
    	return  entityManager.createNamedQuery("Product.findByProductCat2").setParameter("v_productCat2", productCat2).getResultList();
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
