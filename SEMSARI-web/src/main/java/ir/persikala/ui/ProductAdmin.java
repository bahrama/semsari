package ir.persikala.ui;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;

import org.primefaces.model.file.UploadedFile;

import entity.Product;
import ir.persikala.req.FileConvert;
import service.ProductServiceLocal;

@Named
@ViewScoped
public class ProductAdmin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductAdmin() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private ProductServiceLocal productServiceLocal;
	
	private String productName;
	private String productCat1;
	private String productCat2;
	private String productSummary;
	private String productDescription;
	private UploadedFile pic1;
	private UploadedFile pic2;
	private UploadedFile pic3;
	private UploadedFile pic4;
	private UploadedFile pic5;
	private UploadedFile pic6;
	private FileConvert fileConvert;
	private long price;
	private String metaDescription;
	private String metaKeyword;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSummary() {
		return productSummary;
	}
	public void setProductSummary(String productSummary) {
		this.productSummary = productSummary;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	
	public UploadedFile getPic1() {
		return pic1;
	}
	public void setPic1(UploadedFile pic1) {
		this.pic1 = pic1;
	}
	public UploadedFile getPic2() {
		return pic2;
	}
	public void setPic2(UploadedFile pic2) {
		this.pic2 = pic2;
	}
	public UploadedFile getPic3() {
		return pic3;
	}
	public void setPic3(UploadedFile pic3) {
		this.pic3 = pic3;
	}
	public UploadedFile getPic4() {
		return pic4;
	}
	public void setPic4(UploadedFile pic4) {
		this.pic4 = pic4;
	}
	public UploadedFile getPic5() {
		return pic5;
	}
	public void setPic5(UploadedFile pic5) {
		this.pic5 = pic5;
	}
	public UploadedFile getPic6() {
		return pic6;
	}
	public void setPic6(UploadedFile pic6) {
		this.pic6 = pic6;
	}
	
	
	
	public String getProductCat1() {
		return productCat1;
	}
	public void setProductCat1(String productCat1) {
		this.productCat1 = productCat1;
	}
	public String getProductCat2() {
		return productCat2;
	}
	public void setProductCat2(String productCat2) {
		this.productCat2 = productCat2;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	public String getMetaDescription() {
		return metaDescription;
	}
	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
	public String getMetaKeyword() {
		return metaKeyword;
	}
	public void setMetaKeyword(String metaKeyword) {
		this.metaKeyword = metaKeyword;
	}
	public void insertToProduct() {
		Product productEntity=new Product();
		fileConvert=new FileConvert();
		try {
			String s=pic1.getFileName();
			productEntity.setPic1(fileConvert.convertPicture(pic1));
			productEntity.setPic2(fileConvert.convertPicture(pic2));
			productEntity.setPic3(fileConvert.convertPicture(pic3));
			productEntity.setPic4(fileConvert.convertPicture(pic4));
			productEntity.setPic5(fileConvert.convertPicture(pic5));
			productEntity.setPic6(fileConvert.convertPicture(pic6));
			productEntity.setProductCat1(productCat1);
			productEntity.setProductCat2(productCat2);
			productEntity.setPrice(price);
			productEntity.setProductDescription(fileConvert.convertString(productDescription));
			productEntity.setProductName(productName);
			productEntity.setProductSummary(productSummary);
			productEntity.setInputDate(new Date());
			productEntity.setMetaDescription(metaDescription);
			productEntity.setMetaKeyword(metaKeyword);
			productServiceLocal.insertProductEntity(productEntity);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("***با موفقیت وارد گردید***"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Product> findAllProduct(){
		return productServiceLocal.findAllproductEntity();
	}

}
