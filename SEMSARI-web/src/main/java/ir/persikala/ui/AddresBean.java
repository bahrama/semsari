package ir.persikala.ui;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;

import entity.UserAddress;
import service.AddresServiceLocal;

@Named
@SessionScoped
public class AddresBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddresBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private LoginBean loginBean;
	@Inject
	private HomeBean homeBean;
	@Inject
	private AddresServiceLocal addresServiceLocal;
	
	private String addresss;
	private String mobile;
	private String postCode;

	public String getAddresss() {
		return addresss;
	}
	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}
	public String getMobile() {
		return mobile;
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
	
	public void insertAddres() {
		UserAddress userAddress=new UserAddress();
		userAddress.setAddresss(addresss);
		userAddress.setMobile(mobile);
		userAddress.setPostCode(postCode);
		if(homeBean.getUser()!=null)
		userAddress.setUser(homeBean.getUser());
		else
		userAddress.setUser(loginBean.getUserOnline());
		try {
			addresServiceLocal.insertUserAddres(userAddress);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
