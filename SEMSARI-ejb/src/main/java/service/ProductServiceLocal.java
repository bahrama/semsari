package service;

import java.util.List;

import javax.ejb.Local;

import entity.Product;
import entity.ProductEntity;

@Local
public interface ProductServiceLocal {

	void insertProductEntity(Product product);

	List<Product> findAllproductEntity();

	Product findProductEntityById(long productId) throws Exception;

	void updateProductEntity(Product product) throws Exception;

	void deleteProductEntity(Product product);



}
