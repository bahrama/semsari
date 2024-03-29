package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.inject.Inject;

import entity.Blog;
import entity.Product;

/**
 * Session Bean implementation class SingleToneSessionBean
 */
@Stateless
@Startup
public class SingleToneSessionBean implements SingleToneSessionBeanLocal {

    /**
     * Default constructor. 
     */
    public SingleToneSessionBean() {
        // TODO Auto-generated constructor stub
    }
    
	@Inject
	private ProductServiceLocal productServiceLocal;
	@Inject
	private BlogServiceLocal blogServiceLocal;
	
	private List<Product> slideProduct=new ArrayList<Product>();
	private List<Blog> slideHomeBlog=new ArrayList<>();
	
	
	@Override
	public List<Product> getSlideProduct() {
		return slideProduct;
	}



	public void setSlideProduct(List<Product> slideProduct) {
		this.slideProduct = slideProduct;
	}
	
	
	
	@Override
	public List<Blog> getSlideHomeBlog() {
		return slideHomeBlog;
	}



	public void setSlideHomeBlog(List<Blog> slideHomeBlog) {
		this.slideHomeBlog = slideHomeBlog;
	}



	@PostConstruct
	public void singleInit() {
		for (int i = 0; i < 20; i++) {
			Random random = new Random();
			int randSize = random.nextInt(productServiceLocal.findAllproductEntity().size()-1);
			slideProduct.add(productServiceLocal.findAllproductEntity().get(randSize));
		}
	}

	@Schedule(hour = "*", minute = "*/1", persistent = false)
	@AccessTimeout(value = 4, unit = TimeUnit.SECONDS)
	public void ejra() {
		slideProduct.clear();
		slideHomeBlog.clear();
		for (int i = 0; i < 20; i++) {
			Random random = new Random();
			int randSize = random.nextInt(productServiceLocal.findAllproductEntity().size()-1);
			slideProduct.add(productServiceLocal.findAllproductEntity().get(randSize));
		}
		
		for (int i = 0; i < 5; i++) {
			Random random = new Random();
			int randSize = random.nextInt(blogServiceLocal.findAllBlog().size()-1);
			slideHomeBlog.add(blogServiceLocal.findAllBlog().get(randSize));
		}
		

		
	}

}
