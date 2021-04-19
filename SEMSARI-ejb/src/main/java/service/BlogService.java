package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.BlogDaoLocal;
import entity.Blog;

/**
 * Session Bean implementation class BlogService
 */
@Stateless
public class BlogService implements BlogServiceLocal {

    /**
     * Default constructor. 
     */
    public BlogService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private BlogDaoLocal blogDaoLocal;
    
    @Override
    public void insertBlog(Blog blog) throws Exception{
    	blogDaoLocal.insertBlog(blog);
    }
    
    
    
    
    @Override
    @SuppressWarnings("unchecked")
	public List<Blog> findAllBlog(){
    	return blogDaoLocal.findAllBlog();
    }
    
    
    @Override
    public Blog findBlogById(long blogId) throws Exception{
    	try {
    	return blogDaoLocal.findBlogById(blogId);
    }catch(Exception exception) {
    	throw new Exception();
    }
    }
    

    
    
    @Override
    public void updateBlog(Blog blog) throws Exception{
    	try {
    		blogDaoLocal.updateBlog(blog);
    	}catch (Exception e) {
			throw new Exception();
		}
    }
    
    @Override
    public void deleteProductEntity(Blog blog){
    	blogDaoLocal.deleteProductEntity(blog);
    }

}
