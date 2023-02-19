package com.blogs.service;

import com.blogs.model.Blog;
import com.blogs.repository.BlogRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepo blogRepo;

    public Blog saveBlog(Blog blog) {
        return blogRepo.saveAndFlush(blog);
    }

    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }

    public Optional<Blog> getBlogByBlogId(Integer id) {
        return blogRepo.findById(id);
    }

    public List<Blog> findBlogsByBlogTitle(String title) {
        return blogRepo.findBlogsByBlogTitle(title);
    }

    public List<Blog> findBlogsByBlogAuthorId(String authorId) {
        return blogRepo.findBlogsByBlogAuthorId(authorId);
    }

    public Boolean updateBlog(Blog blog) {
        return blogRepo.updateBlog(blog.getBlogTitle(), blog.getDescription(), blog.getBlogId()) == 1;
    }

    public boolean deleteBlog(Integer blogId) {
        return blogRepo.deleteBlogByBlogId(blogId) == 1;
    }
}
