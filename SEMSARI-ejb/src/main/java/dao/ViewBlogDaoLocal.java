package dao;

import javax.ejb.Local;

import entity.ViewBlog;

@Local
public interface ViewBlogDaoLocal {

	void insertViewBlog(ViewBlog viewBlog);

}
