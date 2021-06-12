package entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;
@Entity
@Table(name="menu2")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="Menu2.findAll", query="SELECT b FROM Menu2 b ORDER BY b.menu2id DESC"),
	@NamedQuery(name="Menu2.findByItem", query="SELECT m FROM Menu2 m WHERE m.item=:v_item"),
	@NamedQuery(name="Menu2.findByMenu1", query="SELECT m FROM Menu2 m WHERE m.menu1=:v_menu1")
	})
public class Menu2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu2id")
	private long menu2id;
	
	@Column(name="item" , length=100,nullable=false)
	private String item;
	
	@Column(name="pic1" , length=100,nullable=true)
	private String pic1;
	
	@Column(name="title" , length=100,nullable=true)
	private String title;
	
	@Column(name="descript" , length=1000,nullable=true)
	private String descript;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="menu1id")
	private Menu1 menu1;
	
	@OneToMany(mappedBy="menu2",cascade={CascadeType.ALL})
	private Set<Menu3> menu3;

	public long getMenu2id() {
		return menu2id;
	}

	public void setMenu2id(long menu2id) {
		this.menu2id = menu2id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Menu1 getMenu1() {
		return menu1;
	}

	public void setMenu1(Menu1 menu1) {
		this.menu1 = menu1;
	}

	public Set<Menu3> getMenu3() {
		return menu3;
	}

	public void setMenu3(Set<Menu3> menu3) {
		this.menu3 = menu3;
	}

	public String getPic1() {
		return pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}


	

}
