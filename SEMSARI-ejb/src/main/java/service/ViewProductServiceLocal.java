package service;

import javax.ejb.Local;

import entity.ViewProduct;

@Local
public interface ViewProductServiceLocal {

	void insertViewProduct(ViewProduct viewProduct);

}
