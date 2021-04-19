package entity;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the blog database table.
 * 
 */
@Entity
@Table(name="blog")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="Blog.findAll", query="SELECT b FROM Blog b")
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

	//bi-directional many-to-one association to ViewBlog
	@OneToMany(mappedBy="blog", cascade={CascadeType.ALL})
	private Set<ViewBlog> viewBlogs;

	public Blog() {
	}

	public Long getBlogid() {
		return this.blogid;
	}

	public void setBlogid(Long blogid) {
		this.blogid = blogid;
	}

	public String getPage() {
		return this.page;
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
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}


}