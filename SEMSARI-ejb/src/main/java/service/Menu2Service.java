package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.Menu2DaoLocal;
import entity.Menu1;
import entity.Menu2;

/**
 * Session Bean implementation class Menu2Service
 */
@Stateless
public class Menu2Service implements Menu2ServiceLocal {

    /**
     * Default constructor. 
     */
    public Menu2Service() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private Menu2DaoLocal menu2DaoLocal;
    
    @Override
    public void insertMenu2(Menu2 menu2) throws Exception{
            menu2DaoLocal.insertMenu2(menu2);
    	}
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<Menu2> findAllMenu2(){
    	return menu2DaoLocal.findAllMenu2();
    }
    
    @Override
    public Menu2 findMenu2ByItem(String item) throws Exception{
         return menu2DaoLocal.findMenu2ByItem(item);
    }
    
	@Override
    public List<Menu2> findMenu2ByMenu1(Menu1 menu1) throws Exception{
	return menu2DaoLocal.findMenu2ByMenu1(menu1);
	}
	

}
