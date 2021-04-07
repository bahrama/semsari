package dao;

import java.util.List;

import javax.ejb.Local;

import entity.ProductEntity;

@Local
public interface ProductDaoLocal {

	void insertProductEntity(ProductEntity productEntity);

	List<ProductEntity> findAllproductEntity();

	ProductEntity findProductEntityById(long productId) throws Exception;

	void updateProductEntity(ProductEntity productEntity) throws Exception;

	void deleteProductEntity(ProductEntity productEntity);

}
