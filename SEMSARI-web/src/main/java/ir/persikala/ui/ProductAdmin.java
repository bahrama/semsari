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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	@Size(min=3 ,  max=200 , message="max size is 200")
	@NotNull
	@NotEmpty
	private String productName;
	@Size(min=2 ,  max=50 , message="max size is 50")
	@NotNull
	@NotEmpty
	private String productCat1;
	@Size(min=2 ,  max=50 , message="max size is 50")
	@NotNull
	@NotEmpty
	private String productCat2;
	@Size(min=2 ,  max=50 , message="max size is 50")
	@NotNull
	@NotEmpty
	private String productCat3;
	@Size(min=2 ,  max=50 , message="max size is 50")
	@NotNull
	@NotEmpty
	private String color;
	@Size(min=2 ,  max=200 , message="max size is 200")
	@NotNull
	@NotEmpty
	private String title;
	@Size(min=2 ,  max=2000 , message="max size is 2000")
	@NotNull
	@NotEmpty
	private String productSummary;
	private String productDescription;
	private UploadedFile pic1;
	private UploadedFile pic2;
	private UploadedFile pic3;
	private UploadedFile pic4;
	private UploadedFile pic5;
	private UploadedFile pic6;
	private FileConvert fileConvert;
	@Min(10) @Max(999999999)
	private long price;
	@Size(min=3 ,  max=200 , message="max size is 200")
	@NotNull
	@NotEmpty
	private String metaDescription;
	@Size(min=3 ,  max=200 , message="max size is 200")
	@NotNull
	@NotEmpty
	private String metaKeyword;
	@Size(min=2 ,  max=50 , message="max size is 50")
	@NotNull
	@NotEmpty
	private String altimg1;
	@Size(min=2 ,  max=50 , message="max size is 50")
	@NotNull
	@NotEmpty
	private String altimg2;
	@Size(min=2 ,  max=50 , message="max size is 50")
	@NotNull
	@NotEmpty
	private String altimg3;
	@Size(min=2 ,  max=50 , message="max size is 50")
	@NotNull
	@NotEmpty
	private String altimg4;
	@Size(min=2 ,  max=50 , message="max size is 50")
	@NotNull
	@NotEmpty
	private String altimg5;
	@Size(min=2 ,  max=50 , message="max size is 50")
	@NotNull
	@NotEmpty
	private String altimg6;
	private String specification;
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

	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getProductCat3() {
		return productCat3;
	}
	public void setProductCat3(String productCat3) {
		this.productCat3 = productCat3;
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
	
	public String getAltimg1() {
		return altimg1;
	}
	public void setAltimg1(String altimg1) {
		this.altimg1 = altimg1;
	}
	public String getAltimg2() {
		return altimg2;
	}
	public void setAltimg2(String altimg2) {
		this.altimg2 = altimg2;
	}
	public String getAltimg3() {
		return altimg3;
	}
	public void setAltimg3(String altimg3) {
		this.altimg3 = altimg3;
	}
	public String getAltimg4() {
		return altimg4;
	}
	public void setAltimg4(String altimg4) {
		this.altimg4 = altimg4;
	}
	public String getAltimg5() {
		return altimg5;
	}
	public void setAltimg5(String altimg5) {
		this.altimg5 = altimg5;
	}
	public String getAltimg6() {
		return altimg6;
	}
	public void setAltimg6(String altimg6) {
		this.altimg6 = altimg6;
	}
	
	
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
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
			productEntity.setProductCat3(productCat3);
			productEntity.setPrice(price);
			productEntity.setProductDescription(fileConvert.convertString(productDescription));
			productEntity.setProductName(productName);
			productEntity.setProductSummary(productSummary);
			productEntity.setInputDate(new Date());
			productEntity.setMetaDescription(metaDescription);
			productEntity.setMetaKeyword(metaKeyword);
			productEntity.setAltimg1(altimg1);
			productEntity.setAltimg2(altimg2);
			productEntity.setAltimg3(altimg3);
			productEntity.setAltimg4(altimg4);
			productEntity.setAltimg5(altimg5);
			productEntity.setAltimg6(altimg6);
			productEntity.setSpecification(specification);
			productEntity.setColor(color);
			productEntity.setTitle(title);
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
	
	public void deleteProduct(Product product) {
		productServiceLocal.deleteProductEntity(product);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("***با موفقیت حذف گردید***"));
	}

}
