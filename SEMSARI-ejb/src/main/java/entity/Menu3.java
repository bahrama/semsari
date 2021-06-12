package entity;

import java.io.Serializable;

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
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheCoordinationType;
import org.eclipse.persistence.annotations.CacheType;
@Entity
@Table(name="menu3")
@Cache(type = CacheType.SOFT, coordinationType = CacheCoordinationType.INVALIDATE_CHANGED_OBJECTS, size = 1000000)
@NamedQueries({
	@NamedQuery(name="Menu3.findAll", query="SELECT b FROM Menu3 b ORDER BY b.menu3id DESC"),
	@NamedQuery(name="Menu3.findByMenu2", query="SELECT m FROM Menu3 m WHERE m.menu2=:v_menu2")
	})
public class Menu3 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu3id")
	private long menu3id;
	
	@Column(name="item" , length=100,nullable=false)
	private String item;
	
	@Column(name="pic1" , length=100,nullable=true)
	private String pic1;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="menu2id")
	private Menu2 menu2;

	public long getMenu3id() {
		return menu3id;
	}

	public void setMenu3id(long menu3id) {
		this.menu3id = menu3id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Menu2 getMenu2() {
		return menu2;
	}

	public void setMenu2(Menu2 menu2) {
		this.menu2 = menu2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + (int) (menu3id ^ (menu3id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu3 other = (Menu3) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (menu3id != other.menu3id)
			return false;
		return true;
	}


	
	

}
