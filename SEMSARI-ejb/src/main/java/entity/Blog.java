package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;


/**
 * The persistent class for the blog database table.
 * 
 */
@Entity
@Table(name="blog")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="Blog.findAll", query="SELECT b FROM Blog b"),
	@NamedQuery(name="Blog.findByBlogId", query="SELECT m FROM Blog m WHERE m.blogid=:v_blogid"),
	})
public class Blog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BLOG_BLOGID_GENERATOR", sequenceName="BLOG_BLOGID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BLOG_BLOGID_GENERATOR")
	private long blogid;
	@Column(name="page" , length=100,nullable=false)
	private String page;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="releasedate")
	private Date releasedate;
	@Column(name="summary" , length=2000,nullable=false)
	private String summary;
	@Column(name="BlogCategury1" , length=100,nullable=false)
	private String blogCategury1;
	@Column(name="BlogCategury2" , length=100,nullable=false)
	private String blogCategury2;
	@Column(name="BlogName" , length=200,nullable=false)
	private String blogName;

	//bi-directional many-to-one association to ViewBlog
	@OneToMany(mappedBy="blog", cascade={CascadeType.ALL})
	private Set<ViewBlog> viewBlogs;

	public Blog() {
	}

	public long getBlogid() {
		return blogid;
	}

	public void setBlogid(long blogid) {
		this.blogid = blogid;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Date getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}


	public Set<ViewBlog> getViewBlogs() {
		return viewBlogs;
	}

	public void setViewBlogs(Set<ViewBlog> viewBlogs) {
		this.viewBlogs = viewBlogs;
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

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}




	

}