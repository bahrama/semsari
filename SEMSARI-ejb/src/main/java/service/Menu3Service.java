package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.Menu3DaoLocal;
import entity.Menu2;
import entity.Menu3;

/**
 * Session Bean implementation class Menu3Service
 */
@Stateless
public class Menu3Service implements Menu3ServiceLocal {

    /**
     * Default constructor. 
     */
    public Menu3Service() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private Menu3DaoLocal menu3DaoLocal;
    
    @Override
    public void insertMenu3(Menu3 menu3) throws Exception{
            menu3DaoLocal.insertMenu3(menu3);
    	}
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<Menu3> findAllMenu3(){
    	return menu3DaoLocal.findAllMenu3();
    }
    
	@Override
    public List<Menu3> findMenu3ByMenu2(Menu2 menu2) throws Exception{
	return menu3DaoLocal.findMenu3ByMenu2(menu2);
	}
	

}
