package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.Menu1DaoLocal;
import entity.Menu1;

/**
 * Session Bean implementation class Menu1Service
 */
@Stateless
public class Menu1Service implements Menu1ServiceLocal {

    /**
     * Default constructor. 
     */
    public Menu1Service() {
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private Menu1DaoLocal menu1DaoLocal;
    
    @Override
    public void insertMenu1(Menu1 menu1) throws Exception{
            menu1DaoLocal.insertMenu1(menu1);
    	}
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<Menu1> findAllMenu1(){
    	return menu1DaoLocal.findAllMenu1();
    }
    
    @Override
    public Menu1 findMenu1ByItem(String item) throws Exception{
         return menu1DaoLocal.findMenu1ByItem(item);
    }
    

}
