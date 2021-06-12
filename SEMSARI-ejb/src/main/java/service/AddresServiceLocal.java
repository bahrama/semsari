package service;

import javax.ejb.Local;

import entity.User;
import entity.UserAddress;

@Local
public interface AddresServiceLocal {

	void insertUserAddres(UserAddress userAdres) throws Exception;

	User findAddresByUserId(User user) throws Exception;

}
