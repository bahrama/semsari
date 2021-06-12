package ir.persikala.ui;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
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
import service.BlogServiceLocal;
import service.ProductServiceLocal;
import service.SingleToneSessionBeanLocal;
import service.UserServiceLocal;
import service.ViewProductServiceLocal;

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

	private String userName = "مهمان";
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
			.getRequest();
	@Inject
	private ProductServiceLocal productServiceLocal;
	@Inject
	private SingleToneSessionBeanLocal singleToneSessionBeanLocal;
	@Inject
	private ViewProductServiceLocal viewProductServiceLocal;
	@Inject
	private BlogServiceLocal blogServiceLocal;

	private List<Product> slide = new ArrayList<>();
	private FileConvert fileConvert = new FileConvert();
	private User user = new User();
	private String path2 = "";
	private String path3 = "";
	private Product product = new Product();

	public String getPath2() {
		return path2;
	}

	public void setPath2(String path2) {
		this.path2 = path2;
	}

	public String getPath3() {
		return path3;
	}

	public void setPath3(String path3) {
		this.path3 = path3;
	}

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
		User user = new User();
		UUID uuid = UUID.randomUUID();
		user.setUserToken(uuid.toString());
	}

	public String findUser() {
		return (String) session.getAttribute("userName");
	}

	@PostConstruct
	public void startInit() {
		FacesContext contex = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) contex.getExternalContext().getRequest();
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
				.getResponse();
		Cookie[] userCookies = request.getCookies();
		String userAuth = "";
		String userAuthReg = "";
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		System.err.println("ipAddress:" + ipAddress);
		boolean taeed = false;
		/*if (ipAddress.startsWith("127.0.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("2.144.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("2.176.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.22.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.22.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.23.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.34.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.52.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.53.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.56.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.57.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.61.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.62.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.63.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.72.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.78.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.104.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.106.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.112.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.134.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.134.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.144.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.145.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.159.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.160.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.182.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.190.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.198.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("5.200.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.201.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.202.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.208.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.226.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.232.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("5.250.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("31.2.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("31.7.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("31.14.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("31.24.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("31.25.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("31.29.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("31.40.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("31.47.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("31.56.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("31.130.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("31.170.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("31.171.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("31.184.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("31.193.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("31.214.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("31.214.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("31.217.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.9.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("37.10.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.19.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.27.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("37.32.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.44.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.49.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.63.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.75.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.98.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.114.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.128.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.129.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.130.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.137.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.143.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("37.148.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.152.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("37.153.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("37.156.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.191.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.202.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.221.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("37.228.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.235.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("37.254.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.18.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.21.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.28.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.32.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.34.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("46.36.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.38.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.41.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.51.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.62.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.100.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("46.102.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("46.143.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.148.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.164.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.167.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.182.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.209.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.224.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.235.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.245.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.248.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.249.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("46.251.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("46.255.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("62.60.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("62.102.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("62.193.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("62.220.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("66.79.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("77.36.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("77.42.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("77.77.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("77.81.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("77.104.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("77.237.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("77.238.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("77.245.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("78.31.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("78.38.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("78.109.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("78.110.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("78.111.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("78.154.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("78.157.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("78.158.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("79.127.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("79.132.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("79.174.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("79.175.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("80.66.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("80.71.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("80.75.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("80.191.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("80.210.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("80.242.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("80.249.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("80.250.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("80.253.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("81.12.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("81.16.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("81.28.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("81.29.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("81.31.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("81.90.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("81.91.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("81.163.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("82.97.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("82.99.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("82.115.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("83.120.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("83.147.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("83.150.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("84.47.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("84.241.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("85.9.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("85.15.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("85.133.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("85.185.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("85.198.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("85.204.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("85.208.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("85.239.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("86.55.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("86.57.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("86.104.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("86.105.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("86.106.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("86.107.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("86.109.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("87.107.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("87.247.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("87.248.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("87.251.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("88.135.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("89.32.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("89.33.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("89.34.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("89.35.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("89.36.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("89.37.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("89.38.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("89.39.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("89.40.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("89.41.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("89.42.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("89.43.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("89.44.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("89.45.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("89.46.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("89.47.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("89.144.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("89.165.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("89.184.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("89.196.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("89.198.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("89.219.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("89.221.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("89.235.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("91.92.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.98.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.106.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.108.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.109.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.133.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.147.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.184.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.185.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.186.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.190.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.206.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.207.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.208.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.209.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("91.212.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.216.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.217.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.220.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("91.222.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("91.224.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.225.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.226.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.227.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.228.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.229.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.230.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("91.232.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.233.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.236.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.237.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.238.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("91.239.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("91.240.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("91.241.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.242.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("91.243.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.244.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.245.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.247.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.250.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("91.251.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("92.42.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("92.43.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("92.50.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("92.61.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("92.114.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("92.242.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("92.246.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("92.249.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("93.88.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("93.110.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("93.113.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("93.114.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("93.115.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("93.117.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("93.118.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("93.119.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("93.126.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("93.190.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("94.24.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("94.74.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("94.101.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("94.139.")) {
			taeed = true;
		}

		if (ipAddress.startsWith("94.176.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("94.177.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("94.182.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("94.184.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("94.199.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("94.232.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("94.241.")) {
			taeed = true;
		}
		if (ipAddress.startsWith("95.38.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("95.64.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("95.80.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("95.81.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("95.82.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("95.130.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("95.142.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("95.156.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("95.162.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("95.215.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("103.215.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("103.216.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("103.231.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("109.72.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("109.74.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("109.94.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("109.95.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("109.108.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("109.109.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("109.110.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("109.111.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("109.122.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("109.125.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("109.162.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("109.201.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("109.203.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("109.206.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("109.225.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("109.230.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("109.232.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("109.238.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("109.239.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("113.203.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("128.65.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("128.140.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("130.185.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("130.255.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("134.255.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("146.66.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("151.232.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("151.238.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("151.240.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("157.119.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("158.58.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("159.20.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("164.138.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("164.215.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("172.80.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("176.12.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("176.46.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("176.56.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("176.62.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("176.65.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("176.67.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("176.101.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("176.102.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("176.110.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("176.112.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("176.122.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("176.123.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("176.124.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("176.221.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("176.223.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("178.21.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("178.22.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("178.131.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("178.157.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("178.169.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("178.173.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("178.215.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("178.216.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("178.219.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("178.236.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("178.238.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("178.239.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("178.248.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("178.251.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("178.252.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("178.253.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.1")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.2.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.3.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.4.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.5.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.8.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.10.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.11.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.12.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.13.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.14.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.16.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.18.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.20.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.21.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.22.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.23.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.24.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.25.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.26.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.29.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.30.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.31.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.32.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.34.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.37.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.39.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.40.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.41.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.42.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.44.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.45.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.46.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.47.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.49.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.50.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.51.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.53.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.55.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.56.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.57.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.58.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.59.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.60.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.62.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.63.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.64.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.66.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.67.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.69.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.70.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.71.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.72.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.73.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.74.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.75.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.76.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.78.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.79.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.80.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.81.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.82.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.83.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.84.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.85.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.86.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.88.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.89.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.92.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.93.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.94.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.95.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.96.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.97.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.98.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.99.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.100.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.101.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.103.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.104.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.105.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.106.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.107.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.108.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.109.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.110.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.111.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.112.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.113.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.114.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.115.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.116.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.117.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.118.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.119.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.120.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.121.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.122.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.123.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.124.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.125.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.126.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.127.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.128.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.129.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.130.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.131.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.132.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.133.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.134.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.135.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.136.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.137.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.139.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.140.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.141.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.142.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.143.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.144.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.145.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.147.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.148.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.150.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.151.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.153.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.154.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.155.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.156.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.157.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.158.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.159.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.160.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.161.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.162.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.163.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.164.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.165.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.166.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.167.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.168.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.169.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.170.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.171.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.172.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.173.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.174.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.175.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.176.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.177.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.178.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.179.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.180.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.181.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.182.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.183.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.184.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.185.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.186.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.187.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.188.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.189.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.190.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.191.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.192.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.193.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.194.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.195.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.196.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.197.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.198.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.199.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.201.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.202.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.203.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.204.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.205.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.206.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.207.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.208.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.209.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.210.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.211.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.212.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.213.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.214.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.215.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.216.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.217.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.219.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.220.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.221.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.222.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.224.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.225.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.226.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.227.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.228.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.229.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.231.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.231.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.232.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.233.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.234.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.235.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.236.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.237.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.238.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.239.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.240.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.243.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.244.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.246.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.249.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("185.251.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("185.255.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("188.0.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("188.34.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("188.75.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("188.118.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("188.121.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("188.122.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("188.136.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("188.158.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("188.191.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("188.208.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("188.209.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("188.210.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("188.211.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("188.212.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("188.213.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("188.214.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("188.215.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("188.229.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("188.240.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("188.245.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("188.253.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("192.15.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("193.8.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("193.19.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("193.32.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("193.34.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("193.35.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("193.104.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("193.105.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("193.148.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("193.151.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("193.176.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("193.178.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("193.189.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("193.201.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("193.222.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("193.242.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("194.5.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("194.26.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("194.33.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("194.34.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("194.39.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("194.41.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("194.60.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("194.143.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("194.146.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("194.147.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("194.150.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("194.156.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("194.225.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("195.20.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("195.88.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("195.110.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("195.146.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("195.170.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("195.181.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("195.191.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("195.211.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("195.238.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("195.245.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("196.3.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("212.1.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("212.16.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("212.33.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("212.80.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("212.86.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("212.120.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("213.108.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("213.109.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("213.176.")) {
			taeed = true;

		}
		if (ipAddress.startsWith("213.195.")) {
			taeed = true;

		}
		///////////////////////////////////

		if (ipAddress.startsWith("213.207.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("213.217.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("213.232.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("213.233.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("217.11.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("217.24.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("217.25.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("217.60.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("217.66.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("217.77.")) {
			taeed = true;

		}
		////////////////////////////////////////
		if (ipAddress.startsWith("217.146.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("217.170.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("217.171.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("217.172.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("217.174.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("217.218.")) {
			taeed = true;

		}

		if (ipAddress.startsWith("192.168.")) {
			taeed = true;

		}*/
		taeed = true;
		System.err.println(ipAddress);
		System.err.println("********************************************");
		System.err.println("********************************************");
		System.err.println("********************************************");
		System.err.println("********************************************");
		System.err.println(taeed);
		System.err.println("********************************************");
		System.err.println("********************************************");
		System.err.println("********************************************");
		System.err.println("********************************************");
		
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
		if (userAuthReg.equals("")&&taeed==true) {
			if (userAuth.equals("")) {
				session.setAttribute("userName", "مهمان");
				UUID uuid = UUID.randomUUID();
				Cookie cookie2 = new Cookie("userAuth", uuid.toString());
				cookie2.setPath("/");
				cookie2.setMaxAge(2592000);
				response.addCookie(cookie2);
				User user = new User();
				user.setEmail("guest");
				user.setPass("guest");
				user.setRegisterDate(new Date());
				user.setUsername("guest");
				user.setUserToken(uuid.toString());
				this.user=user;
				try {
					userServiceLocal.insertUser(user);
					this.user = userServiceLocal.findUserByUserToken(uuid.toString());
					session.setAttribute("userName", "user " + this.user.getUserId());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					user = userServiceLocal.findUserByUserToken(userAuth);
					session.setAttribute("userName", "user " + user.getUserId());
				} catch (Exception e) {
					session.setAttribute("userName", "مهمان");
					e.printStackTrace();
				}
			}
		}

		else if(!userAuthReg.equals("")&&taeed==true){

			try {
				user = userServiceLocal.findUserByUserToken2(userAuthReg);
				if (!user.equals(null)) {
					session.setAttribute("userName", user.getUsername());
				} else {
					session.setAttribute("userName", "مهمان");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			User user = new User();
			user.setEmail("robot");
			user.setPass("robot");
			user.setRegisterDate(new Date());
			user.setUsername("robot");
			user.setUserToken("robot");
			this.user=user;
			try {
				userServiceLocal.insertUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// public List<Product> findAllSlide(){
	// return singleToneSessionBeanLocal.getSlideProduct();
	// }

	public List<Product> findAllSlide() {
		return productServiceLocal.findAllproductEntity();
	}
	//
	// public List<Blog> findAllBlogSlide(){
	// return singleToneSessionBeanLocal.getSlideHomeBlog();
	// }

	public List<Blog> findAllBlogSlide() {
		return blogServiceLocal.findAllBlog();
	}

	public byte[] findPic6(String pic) {
		fileConvert = new FileConvert();
		try {
			return fileConvert.findPic(pic);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void pathAct(ActionEvent e) {
		this.path2 = (String) e.getComponent().getAttributes().get("path2");
		this.path3 = (String) e.getComponent().getAttributes().get("path3");
	}

	public List<Object> findAllView() {
		return viewProductServiceLocal.findMaxViewProduct();
	}

	public Product findProductbyId(long productId) {
		try {
			this.product = productServiceLocal.findProductEntityById(productId);
			return productServiceLocal.findProductEntityById(productId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public byte[] findPic1() {
		fileConvert = new FileConvert();

		try {
			return fileConvert.findPic(product.getPic1());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean showExit() {
		try {
		String userSess=(String) session.getAttribute("userName");
		if((userSess.contains("user"))||(userSess.contains("مهمان")))
			return true;
		else
			return false;
		}catch (Exception e) {
			return true;
		}
			
	}
	
	
//	public void check(String name) {
//		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
//				.getResponse();
//		FacesContext contex = FacesContext.getCurrentInstance();
//		if(name.equals("ورود"))
//		System.err.println("wwwwwwwwwwwwwwwwww");
//		else
//		{
//		try {
//			Cookie cookie2 = new Cookie("userAuthReg", "");
//			response.addCookie(cookie2);
//			session.invalidate();
//			contex.getExternalContext().redirect("home.xhtml");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		}
//	}

}
