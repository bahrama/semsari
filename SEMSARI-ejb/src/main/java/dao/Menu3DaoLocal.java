package dao;

import java.util.List;

import javax.ejb.Local;

import entity.Menu2;
import entity.Menu3;

@Local
public interface Menu3DaoLocal {

	void insertMenu3(Menu3 menu3) throws Exception;

	List<Menu3> findAllMenu3();

	List<Menu3> findMenu3ByMenu2(Menu2 menu2) throws Exception;

}
