package service;

import java.util.List;

import javax.ejb.Local;

import entity.ViewProduct;

@Local
public interface ViewProductServiceLocal {

	void insertViewProduct(ViewProduct viewProduct);

	List<Object> findMaxViewProduct();

}
