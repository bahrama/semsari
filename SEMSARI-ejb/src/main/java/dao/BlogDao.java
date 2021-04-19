package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Blog;
import entity.Product;

/**
 * Session Bean implementation class BlogDao
 */
@Stateless
public class BlogDao implements BlogDaoLocal {

    /**
     * Default constructor. 
     */
    public BlogDao() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName="aliUnit")
    private EntityManager entityManager;
    
    
    @Override
    public void insertBlog(Blog blog) throws Exception{
    	try {
    	entityManager.persist(blog);
    	}catch (Exception e) {
			throw new Exception("insertBlog rollback............................");
		}
    	}
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<Blog> findAllBlog(){
    	return entityManager.createNamedQuery("Blog.findAll").getResultList();
    }
    
    
    @Override
    public Blog findBlogById(long blogId) throws Exception{
    	try {
    	return (Blog) entityManager.createNamedQuery("Blog.findByBlogId").setParameter("v_blogid", blogId).getSingleResult();
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    

    
    
    @Override
    public void updateBlog(Blog blog) throws Exception{
    	try {
    	entityManager.merge(blog);
    	}catch (Exception e) {
			throw new Exception();
		}
    }
    
    @Override
    public void deleteProductEntity(Blog blog){
    	Blog homeEntity2=new Blog();
    	homeEntity2=entityManager.merge(blog);
    	entityManager.remove(homeEntity2);
    }

}
