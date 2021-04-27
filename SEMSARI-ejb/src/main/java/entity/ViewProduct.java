package entity;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

import java.util.Date;


/**
 * The persistent class for the view_product database table.
 * 
 */
@Entity
@Table(name="view_product")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="ViewProduct.findAll", query="SELECT v FROM ViewProduct v"),
})
@NamedStoredProcedureQuery(
		name="findMaxViewProduct",
		procedureName="(findMaxViewProduct()).*",
		parameters= {
				@StoredProcedureParameter(mode=ParameterMode.OUT,type=Long.class,name="productid"),
				@StoredProcedureParameter(mode=ParameterMode.OUT,type=Long.class,name="cnt")
		}
		)
public class ViewProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="VIEW_PRODUCT_VIEWID_GENERATOR", sequenceName="VIEW_VIEWID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VIEW_PRODUCT_VIEWID_GENERATOR")
	@Column(name="viewid")
	private long viewId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="viewdate")
	private Date viewDate;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="productid")
	private Product product;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userid")
	private User user;

	public ViewProduct() {
	}

	public long getViewId() {
		return this.viewId;
	}

	public void setViewId(long viewId) {
		this.viewId = viewId;
	}

	public Date getViewDate() {
		return this.viewDate;
	}

	public void setViewDate(Date viewDate) {
		this.viewDate = viewDate;
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