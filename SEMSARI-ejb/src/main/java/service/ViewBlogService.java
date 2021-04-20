package service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ViewBlogDaoLocal;
import entity.ViewBlog;

/**
 * Session Bean implementation class ViewBlogService
 */
@Stateless
public class ViewBlogService implements ViewBlogServiceLocal {

    /**
     * Default constructor. 
     */
    public ViewBlogService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private ViewBlogDaoLocal viewBlogDaoLocal;
    @Override
    public void insertViewBlog(ViewBlog viewBlog){
    	viewBlogDaoLocal.insertViewBlog(viewBlog);
    }

}
