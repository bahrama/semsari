package ir.persikala.ui;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.servlet.http.HttpSession;

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
	private String metaDescription;
	private String metaKeyword;
	@Inject
	private BlogServiceLocal blogServiceLocal;
	private FileConvert fileConvert;
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

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
	
	
	public String getMetaDescription() {
		return metaDescription;
	}
	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
	public String getMetaKeyword() {
		return metaKeyword;
	}
	public void setMetaKeyword(String metaKeyword) {
		this.metaKeyword = metaKeyword;
	}
	public void insertBlog(){
    	fileConvert=new FileConvert();
    	Blog blog=new Blog();
    	blog.setBlogCategury1(blogCategury1);
    	blog.setBlogCategury2(blogCategury2);
    	blog.setReleasedate(new Date());
    	blog.setSummary(summary);
    	blog.setBlogName(blogName);
    	blog.setMetaDescription(metaDescription);
    	blog.setMetaKeyword(metaKeyword);
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
	
	
	public void grantPermission(ComponentSystemEvent event) {
		Object adminLogin=session.getAttribute("admin");
		ExternalContext context=FacesContext.getCurrentInstance().getExternalContext();
		if(adminLogin==null) {
			try {
				context.redirect("login.xhtml?faces-redirect=true");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
