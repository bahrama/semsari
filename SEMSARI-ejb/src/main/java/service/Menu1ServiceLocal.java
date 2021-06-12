package service;

import java.util.List;

import javax.ejb.Local;

import entity.Menu1;

@Local
public interface Menu1ServiceLocal {

	void insertMenu1(Menu1 menu1) throws Exception;

	List<Menu1> findAllMenu1();

	Menu1 findMenu1ByItem(String item) throws Exception;

}
