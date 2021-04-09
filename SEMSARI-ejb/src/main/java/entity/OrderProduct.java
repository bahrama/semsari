package entity;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

import java.util.Date;


/**
 * The persistent class for the order_product database table.
 * 
 */
@Entity
@Table(name="order_product")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="OrderProduct.findAll", query="SELECT o FROM OrderProduct o")
})
public class OrderProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORDER_PRODUCT_ORDERID_GENERATOR", sequenceName="ORDER_ORDERID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORDER_PRODUCT_ORDERID_GENERATOR")
	@Column(name="orderid")
	private long orderId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="orderdate" ,nullable=false)
	private Date orderDate;
	@Column(name="ordernum" ,nullable=true)
	private int orderNum;

	//bi-directional many-to-one association to Product
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="productid")
	private Product product;

	//bi-directional many-to-one association to User
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinColumn(name="userid")
	private User user;

	public OrderProduct() {
	}

	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}