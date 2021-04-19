package entity;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the view_blog database table.
 * 
 */
@Entity
@Table(name="view_blog")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="ViewBlog.findAll", query="SELECT v FROM ViewBlog v")
	})
public class ViewBlog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="VIEW_BLOG_VIEWBLOGID_GENERATOR", sequenceName="VIEWBLOG_VIEWBLOGIDID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="VIEW_BLOG_VIEWBLOGID_GENERATOR")
	private long viewblogid;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userid")
	private User user;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="viewblogdate")
	private Date viewblogdate;

	//bi-directional many-to-one association to Blog
	@ManyToOne(cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="blogid")
	private Blog blog;

	public ViewBlog() {
	}

	public long getViewblogid() {
		return viewblogid;
	}

	public void setViewblogid(long viewblogid) {
		this.viewblogid = viewblogid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getViewblogdate() {
		return viewblogdate;
	}

	public void setViewblogdate(Date viewblogdate) {
		this.viewblogdate = viewblogdate;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	
}