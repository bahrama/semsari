package ir.persikala.ui;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Blog;
import ir.persikala.req.FileConvert;
import service.BlogServiceLocal;

@Named
@ViewScoped
public class BlogPageBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BlogPageBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private BlogServiceLocal blogServiceLocal;
	
	private Blog blog=new Blog();
	private FileConvert fileConvert;
	
	
	public Blog getBlog() {
		return blog;
	}



	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public String blogConvert(long blogId) {
		fileConvert =new FileConvert();
		try {
			return fileConvert.convertBlogHead(blogServiceLocal.findBlogById(blogId).getPage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	public Blog finBlogById(long blogId) {
		try {
			this.blog=blogServiceLocal.findBlogById(blogId);
			return blog;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	} 

}
