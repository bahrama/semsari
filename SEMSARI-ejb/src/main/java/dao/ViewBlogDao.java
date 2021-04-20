package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.ViewBlog;
import entity.ViewProduct;

/**
 * Session Bean implementation class ViewBlogDao
 */
@Stateless
public class ViewBlogDao implements ViewBlogDaoLocal {

    /**
     * Default constructor. 
     */
    public ViewBlogDao() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    @Override
    public void insertViewBlog(ViewBlog viewBlog){
    	entityManager.persist(viewBlog);
    }
}
