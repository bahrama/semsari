package ir.persikala.ui;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.ViewProduct;
import ir.persikala.req.FileConvert;
import service.ProductServiceLocal;
import service.ViewProductServiceLocal;

@Named
@ViewScoped
public class ProductPageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductPageBean() {
		// TODO Auto-generated constructor stub
	}
	
	@Inject
	private ProductServiceLocal productServiceLocal;
	@Inject
	private ViewProductServiceLocal viewProductServiceLocal;
	
	@Inject
	private HomeBean homeBean;
	
	private FileConvert fileConvert;
	private entity.Product product=new entity.Product();
	
	public entity.Product getProduct() {
		return product;
	}

	public void setProduct(entity.Product product) {
		this.product = product;
	}

	public byte[] findPic1(long productId) {
		fileConvert =new FileConvert();
		
		try {
			this.product=productServiceLocal.findProductEntityById(productId);
			return fileConvert.findPic(product.getPic1());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public byte[] findPic2() {
		fileConvert =new FileConvert();
		try {

			return fileConvert.findPic(product.getPic2());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public byte[] findPic3() {
		fileConvert =new FileConvert();
		try {
			return fileConvert.findPic(product.getPic3());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public byte[] findPic4() {
		fileConvert =new FileConvert();
		try {
			return fileConvert.findPic(product.getPic4());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public byte[] findPic5() {
		fileConvert =new FileConvert();
		try {
			return fileConvert.findPic(product.getPic5());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public byte[] findPic6() {
		fileConvert =new FileConvert();
		try {
			return fileConvert.findPic(product.getPic6());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public String blog() {
		fileConvert =new FileConvert();
		try {
			ViewProduct viewProduct=new ViewProduct();
			viewProduct.setProduct(product);
			viewProduct.setUser(homeBean.getUser());
			viewProduct.setViewDate(new Date());
			viewProductServiceLocal.insertViewProduct(viewProduct);
			return fileConvert.convertBlogHead(product.getProductDescription());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

}
