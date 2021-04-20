package dao;

import javax.ejb.Local;

import entity.ViewProduct;

@Local
public interface ViewProductDaoLocal {

	void insertViewProduct(ViewProduct viewProduct);

}
