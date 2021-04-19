package ir.persikala.ui;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;

import entity.Blog;
import ir.persikala.req.FileConvert;
import service.BlogServiceLocal;

@Named
@ViewScoped
public class BlogAdminBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BlogAdminBean() {
		// TODO Auto-generated constructor stub
	}
	
	private String page;
	private String persianReleasedate;
	private String summary;
	private String blogCategury1;
	private String blogCategury2;
	private String blogName;

	@Inject
	private BlogServiceLocal blogServiceLocal;
	private FileConvert fileConvert;
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getPersianReleasedate() {
		return persianReleasedate;
	}
	public void setPersianReleasedate(String persianReleasedate) {
		this.persianReleasedate = persianReleasedate;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
    public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getBlogCategury1() {
		return blogCategury1;
	}
	public void setBlogCategury1(String blogCategury1) {
		this.blogCategury1 = blogCategury1;
	}
	public String getBlogCategury2() {
		return blogCategury2;
	}
	public void setBlogCategury2(String blogCategury2) {
		this.blogCategury2 = blogCategury2;
	}
	public void insertBlog(){
    	fileConvert=new FileConvert();
    	Blog blog=new Blog();
    	blog.setBlogCategury1(blogCategury1);
    	blog.setBlogCategury2(blogCategury2);
    	blog.setReleasedate(new Date());
    	blog.setSummary(summary);
    	blog.setBlogName(blogName);
    	blog.setPage(fileConvert.convertString(page));
    	try {
			blogServiceLocal.insertBlog(blog);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("***با موفقیت وارد گردید***"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	

}