package ir.persikala.ui;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import entity.User;
import service.UserServiceLocal;
import service.ViewProductServiceLocal;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	private UserServiceLocal userServiceLocal; 
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	//HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	@Size(min=2,max=100, message="حداقل 2 و حداکثر 100")
	private String username;
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" , message="فرمت ایمیل اشتباه می باشد")
	private String email;
	@Size(min=2,max=100, message="حداقل 2 و حداکثر 100")
	private String password;
	
	private User userOnline;
	
	
	private String nameApp;
	
	
	private int number;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    public String getNameApp() {
		return nameApp;
	}

	public void setNameApp(String nameApp) {
		this.nameApp = nameApp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void register() {
		HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		Cookie[] userCookies = request.getCookies();
		String userAuth = "";
		if (userCookies != null && userCookies.length > 0) {
			for (int i = 0; i < userCookies.length; i++) {
				if (userCookies[i].getName().equals("userAuth")) {
					// System.err.println(userCookies[i]);
					userAuth = userCookies[i].getValue();
					break;
				}
			}
		}
		User user=new User();
		try {
			user=userServiceLocal.findUserByUserToken(userAuth);
			user.setEmail(email);
			user.setPass(password);
			user.setUsername(username);
			user.setRegisterDate(new Date());
			UUID uuid=UUID.randomUUID();
			user.setUserToken2(uuid.toString());
			userServiceLocal.updateUser(user);
			session.setAttribute("userName",user.getUsername());
			session.setMaxInactiveInterval(59*60);
			/////////////
			Cookie cookie = new Cookie("userAuthReg", uuid.toString());
			cookie.setPath("/SEMSARI-web");
			cookie.setMaxAge(2592000);
			response.addCookie(cookie);
			/////////////
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("***با موفقیت ثبت گردید***"));
		} catch (Exception e1) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "این کاربر در سیستم وجود دارد", "این کاربر در سیستم وجود دارد"));
			e1.printStackTrace();
		}
		}

	public void submit() {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Correct");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void login() {
		HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		this.userOnline=new User();
		try {
			this.userOnline=userServiceLocal.findUserByEmail(email);
			if(userOnline.getPass().equals(password)) {
			session.setAttribute("userName",userOnline.getUsername());
			Cookie cookie = new Cookie("userAuth", userOnline.getUserToken());
			Cookie cookie2 = new Cookie("userAuthReg", userOnline.getUserToken2());
			cookie.setPath("/SEMSARI-web");
			cookie.setMaxAge(2592000);
			cookie2.setPath("/SEMSARI-web");
			cookie2.setMaxAge(2592000);
			response.addCookie(cookie);
			response.addCookie(cookie2);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("***خوش آمدید***"));
			}
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "نام کاربری یا رمز عبور اشتباه میباشد", "نام کاربری یا رمز عبور اشتباه میباشد"));
			e.printStackTrace();
		}
	}
	
	public List<User> findAllUser(){
		return userServiceLocal.findAllUser();
	}
	


}
