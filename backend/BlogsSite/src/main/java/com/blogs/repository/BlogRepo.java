package com.blogs.repository;

import com.blogs.constants.BlogConstants;
import com.blogs.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Integer> {

    @Query(BlogConstants.FIND_BLOGS_BY_BLOG_TITLE_QUERY)
    List<Blog> findBlogsByBlogTitle(String title);

    @Query(BlogConstants.FIND_BLOGS_BY_BLOG_AUTHOR_ID_QUERY)
    List<Blog> findBlogsByBlogAuthorId(String authorId);

    @Query(BlogConstants.UPDATE_BLOG_QUERY)
    @Transactional
    @Modifying
    Integer updateBlog(String blogTitle, String description, Integer blogId);

    @Query(BlogConstants.DELETE_BLOG_QUERY)
    @Transactional
    @Modifying
    Integer deleteBlogByBlogId(Integer blogId);
}
