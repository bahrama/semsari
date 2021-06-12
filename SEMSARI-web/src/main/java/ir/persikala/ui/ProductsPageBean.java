package ir.persikala.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Menu2;
import entity.Menu3;
import entity.Product;
import ir.persikala.req.FileConvert;
import service.Menu2ServiceLocal;
import service.Menu3ServiceLocal;
import service.ProductServiceLocal;

@Named
@ViewScoped
public class ProductsPageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductsPageBean() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	private ProductServiceLocal productServiceLocal;
	private FileConvert fileConvert;
	private String[] menu3Item;
	@Inject
	private Menu3ServiceLocal menu3ServiceLocal;
	@Inject
	private Menu2ServiceLocal menu2ServiceLocal;
	private List<Product> products = new ArrayList<Product>();
	private boolean enble = true;
	private String productCat2;

	public boolean isEnble() {
		return enble;
	}

	public void setEnble(boolean enble) {
		this.enble = enble;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String[] getMenu3Item() {
		return menu3Item;
	}

	public void setMenu3Item(String[] menu3Item) {
		this.menu3Item = menu3Item;
	}

	public String getProductCat2() {
		return productCat2;
	}

	public void setProductCat2(String productCat2) {
		this.productCat2 = productCat2;
	}

	public List<Product> findProductsPage(String productCat1, String productCat2) {
		try {
			return productServiceLocal.findProductEntityByProductCat(productCat1, productCat2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<Product> findProductsByProductCat2(String productCat2) {
		try {
			return productServiceLocal.findProductEntityByProductCat2(productCat2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public byte[] findPic(long productId) {
		fileConvert = new FileConvert();
		try {
			System.err.println(productServiceLocal.findProductEntityById(productId).getProductCat1());
			return fileConvert.findPic(productServiceLocal.findProductEntityById(productId).getPic1());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<Product> findProductsByFilter(String... args) {
		try {
			this.productCat2 = args[0];
			return productServiceLocal.findProductEntityByProductCat2(args[0]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * public void itemSelected() {
	 * FacesContext.getCurrentInstance().addMessage(null, new
	 * FacesMessage(this.menu3Item[0])); }
	 */

	public List<Menu3> findMenu3ByMenu2Item(String item) {
		return findMenu3ByMenu2(this.findMenu2ByItem(item));
	}

	public Menu2 findMenu2ByItem(String item) {
		try {
			return menu2ServiceLocal.findMenu2ByItem(item);
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	public List<Menu3> findMenu3ByMenu2(Menu2 menu2) {
		try {
			return menu3ServiceLocal.findMenu3ByMenu2(menu2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void itemSelected(AjaxBehaviorEvent event) {
		System.err.println("AAAAAAAAAAAAAAJJJJJJJJAAAAAAAAAAAX");
		this.products.clear();
		this.enble = false;

		// this.productDetails.clear();
		// this.pageBrand="";
		// try {
		try {
		 for (int i = 0; i <
		 event.getFacesContext().getExternalContext().getRequestParameterValuesMap().get("smc").length;
		 i++) {
				String prc3=event.getFacesContext().getExternalContext().getRequestParameterValuesMap().get("smc")[i].toString();
				
					this.products.addAll(productServiceLocal.findProductEntityByProductCat23(this.productCat2,prc3));

		 }				} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			 this.products.addAll(this.findProductsByFilter(this.productCat2));
			}
		// }catch (Exception e) {
		// //for (int i = 0; i < BrandHa.values().length; i++) {
		// // this.pageBrand+=BrandHa.values()[i].toString()+"-";
		// //}
		// }
		// try {
		// String daste = (String)
		// FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("daste");
		// // findProductIndexByDasteMultiBrand("9", "0", "1",daste);
		// }catch (Exception e) {
		// System.err.println("doc is little");
		// }

	}
}
