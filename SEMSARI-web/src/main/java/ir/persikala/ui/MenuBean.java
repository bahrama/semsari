package ir.persikala.ui;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Menu1;
import entity.Menu2;
import entity.Menu3;
import service.Menu1ServiceLocal;
import service.Menu2ServiceLocal;
import service.Menu3ServiceLocal;

@Named
@ViewScoped
public class MenuBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuBean() {
		// TODO Auto-generated constructor stub
	}
	
	private String menu1Item;
	private String menu2Item;
	private String menu3Item;
	private String selectedMenu1Item;
	@Inject
	private Menu1ServiceLocal menu1ServiceLocal;
	@Inject
	private Menu2ServiceLocal menu2ServiceLocal;
	@Inject
	private Menu3ServiceLocal menu3ServiceLocal;
	private String selectedMenu2Item;
	public String getMenu1Item() {
		return menu1Item;
	}
	public void setMenu1Item(String menu1Item) {
		this.menu1Item = menu1Item;
	}
	public String getMenu2Item() {
		return menu2Item;
	}
	public void setMenu2Item(String menu2Item) {
		this.menu2Item = menu2Item;
	}
	public String getMenu3Item() {
		return menu3Item;
	}
	public void setMenu3Item(String menu3Item) {
		this.menu3Item = menu3Item;
	}
	
	public String getSelectedMenu1Item() {
		return selectedMenu1Item;
	}
	public void setSelectedMenu1Item(String selectedMenu1Item) {
		this.selectedMenu1Item = selectedMenu1Item;
	}
	
	
	public String getSelectedMenu2Item() {
		return selectedMenu2Item;
	}
	public void setSelectedMenu2Item(String selectedMenu2Item) {
		this.selectedMenu2Item = selectedMenu2Item;
	}
	public void insertToMenu1() {
		Menu1 menu1=new Menu1();
		menu1.setItem(menu1Item);
		try {
			menu1ServiceLocal.insertMenu1(menu1);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("***با موفقیت وارد گردید***"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Menu1> findAllMenu1(){
		return menu1ServiceLocal.findAllMenu1();
	}
	
	public Menu1 findMenu1ByItem(String item) {
		try {
			return menu1ServiceLocal.findMenu1ByItem(item);
		} catch (Exception e) {
			
			e.printStackTrace();
		return null;
		}
	}
	
	public void insertToMenu2() {
		Menu2 menu2=new Menu2();
		menu2.setItem(menu2Item);
		menu2.setMenu1(this.findMenu1ByItem(selectedMenu1Item));
		try {
			menu2ServiceLocal.insertMenu2(menu2);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("***با موفقیت وارد گردید***"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Menu2> findAllMenu2(){
		return menu2ServiceLocal.findAllMenu2();
	}
	
	public Menu2 findMenu2ByItem(String item) {
		try {
			return menu2ServiceLocal.findMenu2ByItem(item);
		} catch (Exception e) {
			
			e.printStackTrace();
		return null;
		}
	}
	
	public void insertToMenu3() {
		Menu3 menu3=new Menu3();
		menu3.setItem(menu3Item);
		menu3.setMenu2(this.findMenu2ByItem(selectedMenu2Item));
		try {
			menu3ServiceLocal.insertMenu3(menu3);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("***با موفقیت وارد گردید***"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Menu3> findAllMenu3(){
		return menu3ServiceLocal.findAllMenu3();
	}
	
	public List<Menu2> findMenu2ByMenu1(Menu1 menu1){
		try {
			return menu2ServiceLocal.findMenu2ByMenu1(menu1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Menu3> findMenu3ByMenu2(Menu2 menu2){
		try {
			return menu3ServiceLocal.findMenu3ByMenu2(menu2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Menu3> findMenu3ByMenu2Item(String item){
		return findMenu3ByMenu2(this.findMenu2ByItem(item));
	}

}
