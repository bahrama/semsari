package service;

import javax.ejb.Local;

import entity.ViewBlog;

@Local
public interface ViewBlogServiceLocal {

	void insertViewBlog(ViewBlog viewBlog);

}
