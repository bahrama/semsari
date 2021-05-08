package service;

import java.util.List;

import javax.ejb.Local;

import entity.Product;

@Local
public interface ProductServiceLocal {

	void insertProductEntity(Product product);

	List<Product> findAllproductEntity();

	Product findProductEntityById(long productId) throws Exception;

	void updateProductEntity(Product product) throws Exception;

	void deleteProductEntity(Product product);

	List<Product> findProductEntityByProductCat(String productCat1, String productCat2) throws Exception;

	List<Product> findProductEntityByProductCat1(String productCat1) throws Exception;

	Product findProductEntityByName(String productName) throws Exception;



}
