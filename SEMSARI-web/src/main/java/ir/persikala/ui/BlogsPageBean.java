package ir.persikala.ui;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Blog;
import service.BlogServiceLocal;

@Named
@ViewScoped
public class BlogsPageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BlogsPageBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private BlogServiceLocal blogServiceLocal;

	public List<Blog> findAllBlog(){
		return blogServiceLocal.findAllBlog();
	}
	
}
