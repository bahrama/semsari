package service;

import java.util.List;

import javax.ejb.Local;

import entity.Blog;
import entity.Product;

@Local
public interface SingleToneSessionBeanLocal {

	List<Product> getSlideProduct();

	List<Blog> getSlideHomeBlog();

}
