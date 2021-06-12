package entity;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

import java.util.Date;


/**
 * The persistent class for the user_address database table.
 * 
 */
@Entity
@Table(name="user_address")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="UserAddress.findAll", query="SELECT u FROM UserAddress u"),
	@NamedQuery(name="UserAddress.findByUser", query="SELECT u FROM UserAddress u WHERE u.user=:v_user")
})
public class UserAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_ADDRESS_ADDRESSID_GENERATOR", sequenceName="ADDRESS_ADDRESSID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_ADDRESS_ADDRESSID_GENERATOR")
	@Column(name="addressid")
	private long addressId;
	@Column(name="addresss" , length=200,nullable=false , unique=true)
	private String addresss;
	@Column(name="mobile" , length=11,nullable=false)
	private String mobile;
	@Column(name="postcode" , length=10,nullable=true)
	private String postCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="viewdate")
	private Date viewDate;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userid" , unique=true)
	private User user;

	public UserAddress() {
	}

	public long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getAddresss() {
		return this.addresss;
	}

	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Date getViewDate() {
		return this.viewDate;
	}

	public void setViewDate(Date viewDate) {
		this.viewDate = viewDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}