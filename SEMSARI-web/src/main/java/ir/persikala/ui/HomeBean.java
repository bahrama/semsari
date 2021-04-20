package ir.persikala.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Blog;
import entity.Product;
import entity.User;
import ir.persikala.req.FileConvert;
import service.ProductServiceLocal;
import service.SingleToneSessionBeanLocal;
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
	//HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	@Inject
	private ProductServiceLocal productServiceLocal;
	@Inject
	private SingleToneSessionBeanLocal singleToneSessionBeanLocal;
	private List<Product> slide=new ArrayList<>();
	private FileConvert fileConvert;
	private User user=new User();
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Product> getSlide() {
		return slide;
	}

	public void setSlide(List<Product> slide) {
		this.slide = slide;
	}

	@Inject
	private UserServiceLocal userServiceLocal;
	
	 public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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
	
	public String findUser() {
		return (String) session.getAttribute("userName");
	}
	@PostConstruct
	public void startInit() {
		HttpServletResponse response=(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		Cookie[] userCookies = request.getCookies();
		String userAuth = "";
		String userAuthReg = "";
		if (userCookies != null && userCookies.length > 0) {
			for (int i = 0; i < userCookies.length; i++) {
				if (userCookies[i].getName().equals("userAuth")) {
					// System.err.println(userCookies[i]);
					userAuth = userCookies[i].getValue();
					break;
				}
			}
			for (int i = 0; i < userCookies.length; i++) {
				if (userCookies[i].getName().equals("userAuthReg")) {
					// System.err.println(userCookies[i]);
					userAuthReg = userCookies[i].getValue();
					break;
				}
			}
		}
		if(userAuthReg.equals("")) {
			if(userAuth.equals("")) {
		session.setAttribute("userName", "مهمان");
		UUID uuid=UUID.randomUUID();
		Cookie cookie2 = new Cookie("userAuth", uuid.toString());
		cookie2.setPath("/SEMSARI-web");
		cookie2.setMaxAge(2592000);
		response.addCookie(cookie2);
		User user=new User();
		user.setEmail("guest");
		user.setPass("guest");
		user.setRegisterDate(new Date());
		user.setUsername("guest");
		user.setUserToken(uuid.toString());
		try {
			userServiceLocal.insertUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
			else {
				try {
					user=userServiceLocal.findUserByUserToken(userAuth);
					session.setAttribute("userName", "user " + user.getUserId());
				} catch (Exception e) {
					session.setAttribute("userName", "مهمان");
					e.printStackTrace();
				}
			}
		}
		
		else {
			
			try {
				user=userServiceLocal.findUserByUserToken2(userAuthReg);
				if(!user.equals(null)) {
					session.setAttribute("userName", user.getUsername());
				}else {
					session.setAttribute("userName", "مهمان");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public List<Product> findAllSlide(){
		return singleToneSessionBeanLocal.getSlideProduct();
	}
	
	public List<Blog> findAllBlogSlide(){
		return singleToneSessionBeanLocal.getSlideHomeBlog();
	}
	
	public byte[] findPic6(String pic) {
		fileConvert =new FileConvert();
		try {
			return fileConvert.findPic(pic);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
}
