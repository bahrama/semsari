package dao;

import java.util.List;

import javax.ejb.Local;

import entity.Blog;

@Local
public interface BlogDaoLocal {

	void insertBlog(Blog blog) throws Exception;

	List<Blog> findAllBlog();

	Blog findBlogById(long blogId) throws Exception;

	void updateBlog(Blog blog) throws Exception;

	void deleteProductEntity(Blog blog);

}
