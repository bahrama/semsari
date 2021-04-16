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
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="User.findById", query="SELECT m FROM User m WHERE m.userId=:v_userId"),
	@NamedQuery(name="User.findByEmail", query="SELECT m FROM User m WHERE m.email=:v_email")
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERS_USERID_GENERATOR", sequenceName="USERS_USERID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_USERID_GENERATOR")
	@Column(name="userid")
	private long userId;
	@Column(name="email" , length=100,nullable=false , unique=true)
	private String email;
	@Column(name="pass" , length=100,nullable=false)
	private String pass;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="registerdate")
	private Date registerDate;
	@Column(name="username" , length=100,nullable=false)
	private String username;
	@Column(name="usertoken" , length=100,nullable=false)
	private String userToken;

	//bi-directional many-to-one association to OrderProduct
	@OneToMany(mappedBy="user",cascade={CascadeType.ALL})
	private Set<OrderProduct> orderProducts;

	//bi-directional many-to-one association to UserAddress
	@OneToMany(mappedBy="user",cascade={CascadeType.ALL})
	private Set<UserAddress> userAddresses;

	//bi-directional many-to-one association to ViewProduct
	@OneToMany(mappedBy="user",cascade={CascadeType.ALL})
	private Set<ViewProduct> viewProducts;

	public User() {
	}

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserToken() {
		return this.userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public Set<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(Set<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public Set<UserAddress> getUserAddresses() {
		return userAddresses;
	}

	public void setUserAddresses(Set<UserAddress> userAddresses) {
		this.userAddresses = userAddresses;
	}

	public Set<ViewProduct> getViewProducts() {
		return viewProducts;
	}

	public void setViewProducts(Set<ViewProduct> viewProducts) {
		this.viewProducts = viewProducts;
	}

	

}