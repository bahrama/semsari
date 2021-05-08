package ir.persikala.ui;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@Named
@SessionScoped
public class AdminLogin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminLogin() {
		// TODO Auto-generated constructor stub
	}
	
	private String pass;
	private String user;
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

	
	
	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public void adminLogin() {
		ExternalContext context=FacesContext.getCurrentInstance().getExternalContext();
		if(this.pass.equals("ali680313")&&this.user.equals("ali")) {
		session.setAttribute("admin", "ali");
			try {
				context.redirect("add-product.xhtml?faces-redirect=true");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
