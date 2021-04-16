package ir.persikala.ui;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Product;
import ir.persikala.req.FileConvert;
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
	
	public List<Product> findProductsPage(String productCat1,String productCat2){
		try {
			return productServiceLocal.findProductEntityByProductCat(productCat1, productCat2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public byte[] findPic(long productId) {
		fileConvert =new FileConvert();
		try {
			System.err.println(productServiceLocal.findProductEntityById(productId).getProductCat1());
			return fileConvert.findPic(productServiceLocal.findProductEntityById(productId).getPic1());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
}
