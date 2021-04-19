package dao;

import java.util.List;

import javax.ejb.Local;

import entity.User;

@Local
public interface UserDaoLocal {

	void insertUser(User user) throws Exception;

	List<User> findAllUser();

	User findUserById(long userId) throws Exception;

	void updateUser(User user) throws Exception;

	void deleteUser(User user);

	User findUserByEmail(String email) throws Exception;

	User findUserByUserToken(String userToken) throws Exception;

	User findUserByUserToken2(String userToken2) throws Exception;

}
