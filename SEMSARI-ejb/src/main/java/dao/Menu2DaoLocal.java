package dao;

import java.util.List;

import javax.ejb.Local;

import entity.Menu1;
import entity.Menu2;

@Local
public interface Menu2DaoLocal {

	void insertMenu2(Menu2 menu2) throws Exception;

	List<Menu2> findAllMenu2();

	Menu2 findMenu2ByItem(String item) throws Exception;

	List<Menu2> findMenu2ByMenu1(Menu1 menu1) throws Exception;

}
