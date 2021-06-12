package dao;

import java.util.List;

import javax.ejb.Local;

import entity.Product;

@Local
public interface ProductDaoLocal {

	void insertProductEntity(Product product);

	List<Product> findAllproductEntity();

	Product findProductEntityById(long productId) throws Exception;

	void updateProductEntity(Product product) throws Exception;

	void deleteProductEntity(Product product);

	List<Product> findProductEntityByProductCat(String productCat1, String productCat2) throws Exception;

	List<Product> findProductEntityByProductCat1(String productCat1) throws Exception;

	Product findProductEntityByName(String productName) throws Exception;

	List<Product> findProductEntityByProductCat2(String productCat2) throws Exception;

	List<Product> findProductEntityByProductCat23(String productCat2, String productCat3) throws Exception;



}
