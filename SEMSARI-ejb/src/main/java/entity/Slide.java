package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;
@Entity
@Table(name="slide")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="Slide.findAll", query="SELECT b FROM Slide b ORDER BY b.slideid DESC")
	})
public class Slide implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "slideid")
	private long slideid;
	
	@Column(name="pic1" , length=100,nullable=false)
	private String pic1;
	
	@Column(name="link" , length=100,nullable=false)
	private String link;
	
	@Column(name="name" , length=100,nullable=false)
	private String name;
	
	@Column(name="typrCom" , length=100,nullable=false)
	private String typrCom;


	public long getSlideid() {
		return slideid;
	}

	public void setSlideid(long slideid) {
		this.slideid = slideid;
	}

	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTyprCom() {
		return typrCom;
	}

	public void setTyprCom(String typrCom) {
		this.typrCom = typrCom;
	}
	

}
