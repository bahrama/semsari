package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;
@Entity
@Table(name="Product")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
@NamedQuery(name="ProductEntity.findAll", query="SELECT m FROM ProductEntity m ORDER BY m.productId ASC"),
@NamedQuery(name="ProductEntity.findByProductId", query="SELECT m FROM ProductEntity m WHERE m.productId=:v_productId")
})
public class ProductEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ProductId")
	private int productId;
	@Column(name="ProductName" , length=200,nullable=true)
	private String productName;
	@Column(name="ProductCat" , length=200,nullable=true)
	private String productCat;
	@Column(name="ProductSummary" , length=2000,nullable=true)
	private String productSummary;
	@Column(name="ProductDescription" , length=100,nullable=true)
	private String productDescription;
	@Column(name="Pic1" , length=100,nullable=true)
	private String pic1;
	@Column(name="Pic2" , length=100,nullable=true)
	private String pic2;
	@Column(name="Pic3" , length=100,nullable=true)
	private String pic3;
	@Column(name="Pic4" , length=100,nullable=true)
	private String pic4;
	@Column(name="Pic5" , length=100,nullable=true)
	private String pic5;
	@Column(name="Pic6" , length=100,nullable=true)
	private String pic6;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCat() {
		return productCat;
	}
	public void setProductCat(String productCat) {
		this.productCat = productCat;
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
	public String getPic1() {
		return pic1;
	}
	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}
	public String getPic2() {
		return pic2;
	}
	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}
	public String getPic3() {
		return pic3;
	}
	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}
	public String getPic4() {
		return pic4;
	}
	public void setPic4(String pic4) {
		this.pic4 = pic4;
	}
	public String getPic5() {
		return pic5;
	}
	public void setPic5(String pic5) {
		this.pic5 = pic5;
	}
	public String getPic6() {
		return pic6;
	}
	public void setPic6(String pic6) {
		this.pic6 = pic6;
	}
	
	
}
