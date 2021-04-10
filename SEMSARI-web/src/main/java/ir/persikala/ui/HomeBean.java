package ir.persikala.ui;

import java.io.Serializable;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.User;
import service.UserServiceLocal;

@Named
@SessionScoped
public class HomeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HomeBean() {
		// TODO Auto-generated constructor stub
	}
	
	private String userName="مهمان";
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

	
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Inject
	private UserServiceLocal userServiceLocal;
	
	 FacesContext contex = FacesContext.getCurrentInstance();
	public void insertToUser() {
		HttpServletRequest request = (HttpServletRequest) contex.getExternalContext().getRequest();
    	
		Cookie[] userCookies = request.getCookies();
		String semCookie = "";
		if (userCookies != null && userCookies.length > 0) {
			for (int i = 0; i < userCookies.length; i++) {
				if (userCookies[i].getName().equals("semCookie")) {
					// System.err.println(userCookies[i]);
					semCookie = userCookies[i].getValue();
					break;
				}
			}
		}
		System.err.println(semCookie);
		User user=new User();
		UUID uuid=UUID.randomUUID();
		user.setUserToken(uuid.toString());
	}
	
	@PostConstruct
	public void startHome() {
		this.userName=(String) session.getAttribute("username");
	}
	
	
	
}
