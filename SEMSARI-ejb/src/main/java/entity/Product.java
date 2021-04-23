package entity;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name="product")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p"),
	@NamedQuery(name="Product.findByProductId", query="SELECT m FROM Product m WHERE m.productId=:v_productId"),
	@NamedQuery(name="Product.findByProductCat", query="SELECT m FROM Product m WHERE (m.productCat1=:v_productCat1 AND m.productCat2=:v_productCat2)"),
	@NamedQuery(name="Product.findByProductCat1", query="SELECT m FROM Product m WHERE m.productCat1=:v_productCat1")
})
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCT_PRODUCTID_GENERATOR", sequenceName="PRODUCT_PRODUCTID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_PRODUCTID_GENERATOR")
	@Column(name="productid")
	private long productId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="inputdate")
	private Date inputDate;
	@Column(name="pic1" , length=100,nullable=false)
	private String pic1;
	@Column(name="pic2" , length=100,nullable=false)
	private String pic2;
	@Column(name="pic3" , length=100,nullable=false)
	private String pic3;
	@Column(name="pic4" , length=100,nullable=false)
	private String pic4;
	@Column(name="pic5" , length=100,nullable=false)
	private String pic5;
	@Column(name="pic6" , length=100,nullable=false)
	private String pic6;
	@Column(name="price")
	private long price;
	@Column(name="productcat1" , length=50,nullable=false)
	private String productCat1;
	@Column(name="productcat2" , length=50,nullable=false)
	private String productCat2;
	@Column(name="productdescription" , length=100,nullable=false)
	private String productDescription;
	@Column(name="productname" , length=200,nullable=false)
	private String productName;
	@Column(name="productsummary" , length=2000,nullable=false)
	private String productSummary;

	//bi-directional many-to-one association to OrderProduct
	@OneToMany(mappedBy="product", cascade={CascadeType.ALL})
	private Set<OrderProduct> orderProducts;

	//bi-directional many-to-one association to ViewProduct
	@OneToMany(mappedBy="product",cascade={CascadeType.ALL})
	private Set<ViewProduct> viewProducts;

	public Product() {
	}

	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public Date getInputDate() {
		return this.inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public String getPic1() {
		return this.pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public String getPic2() {
		return this.pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}

	public String getPic3() {
		return this.pic3;
	}

	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}

	public String getPic4() {
		return this.pic4;
	}

	public void setPic4(String pic4) {
		this.pic4 = pic4;
	}

	public String getPic5() {
		return this.pic5;
	}

	public void setPic5(String pic5) {
		this.pic5 = pic5;
	}

	public String getPic6() {
		return this.pic6;
	}

	public void setPic6(String pic6) {
		this.pic6 = pic6;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getProductCat1() {
		return this.productCat1;
	}

	public void setProductCat1(String productCat1) {
		this.productCat1 = productCat1;
	}

	public String getProductCat2() {
		return this.productCat2;
	}

	public void setProductCat2(String productCat2) {
		this.productCat2 = productCat2;
	}

	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSummary() {
		return this.productSummary;
	}

	public void setProductSummary(String productSummary) {
		this.productSummary = productSummary;
	}

	public Set<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(Set<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public Set<ViewProduct> getViewProducts() {
		return viewProducts;
	}

	public void setViewProducts(Set<ViewProduct> viewProducts) {
		this.viewProducts = viewProducts;
	}

	

}