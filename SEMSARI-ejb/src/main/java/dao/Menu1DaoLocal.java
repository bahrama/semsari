package dao;

import java.util.List;

import javax.ejb.Local;

import entity.Menu1;

@Local
public interface Menu1DaoLocal {

	List<Menu1> findAllMenu1();

	void insertMenu1(Menu1 menu1) throws Exception;

	Menu1 findMenu1ByItem(String item) throws Exception;

}
