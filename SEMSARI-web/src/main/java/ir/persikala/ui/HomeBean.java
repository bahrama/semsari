package ir.persikala.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import entity.Product;
import entity.User;
import ir.persikala.req.FileConvert;
import service.ProductServiceLocal;
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
	@Inject
	private ProductServiceLocal productServiceLocal;
	private List<Product> slide=new ArrayList<>();
	private FileConvert fileConvert;
	
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
		session.setAttribute("userName", "مهمان");
		int size=productServiceLocal.findAllproductEntity().size();
	    slide.add(productServiceLocal.findAllproductEntity().get(size-1));
	    slide.add(productServiceLocal.findAllproductEntity().get(size-2));
	    slide.add(productServiceLocal.findAllproductEntity().get(size-3));
	    slide.add(productServiceLocal.findAllproductEntity().get(size-4));
	    slide.add(productServiceLocal.findAllproductEntity().get(size-5));
		
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
