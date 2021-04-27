package dao;

import java.util.List;

import javax.ejb.Local;

import entity.ViewProduct;

@Local
public interface ViewProductDaoLocal {

	void insertViewProduct(ViewProduct viewProduct);

	List<Object> findMaxViewProduct();

}
