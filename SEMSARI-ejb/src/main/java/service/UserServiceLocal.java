package service;

import java.util.List;

import javax.ejb.Local;

import entity.User;

@Local
public interface UserServiceLocal {

	void insertUser(User user) throws Exception;

	List<User> findAllUser();

	User findUserById(long userId) throws Exception;

	void updateUser(User user) throws Exception;

	void deleteUser(User user);

	User findUserByEmail(String email) throws Exception;

}
