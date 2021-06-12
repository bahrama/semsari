package entity;

import java.io.Serializable;
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
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;
@Entity
@Table(name="menu1")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="Menu1.findAll", query="SELECT b FROM Menu1 b"),
	@NamedQuery(name="Menu1.findByItem", query="SELECT m FROM Menu1 m WHERE m.item=:v_item")
	})
public class Menu1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu1id")
	private long menu1id;
	
	@Column(name="item" , length=100,nullable=false)
	private String item;
	
	@Column(name="colaps" , length=100,nullable=true)
	private String colaps;
	
	@Column(name="pic1" , length=100,nullable=true)
	private String pic1;
	
	@OneToMany(mappedBy="menu1",cascade={CascadeType.ALL})
	private Set<Menu2> menu2;

	public long getMenu1id() {
		return menu1id;
	}

	public void setMenu1id(long menu1id) {
		this.menu1id = menu1id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getColaps() {
		return colaps;
	}

	public void setColaps(String colaps) {
		this.colaps = colaps;
	}


	
	

}
