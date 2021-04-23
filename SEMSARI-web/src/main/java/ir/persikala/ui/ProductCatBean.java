package ir.persikala.ui;

import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import service.ProductServiceLocal;

@Named
@ViewScoped
public class ProductCatBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductCatBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private ProductServiceLocal productServiceLocal;
	
	private String path2="";

	public String getPath2() {
		return path2;
	}

	public void setPath2(String path2) {
		this.path2 = path2;
	}
	
	public void pathAct(ActionEvent e) {
		this.path2=(String) e.getComponent().getAttributes().get("path2");
	}
	@PreDestroy
	public void dest() {
		this.path2="";
	}

}
