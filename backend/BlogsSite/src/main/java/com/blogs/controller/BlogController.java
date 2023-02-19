package com.blogs.controller;

import com.blogs.constants.BlogConstants;
import com.blogs.exception.ValidationException;
import com.blogs.model.Blog;
import com.blogs.service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @RequestMapping(method = RequestMethod.POST, path = BlogConstants.SAVE_BLOG,
            consumes = BlogConstants.APPLICATION_JSON, produces = BlogConstants.APPLICATION_JSON)
    public ResponseEntity<?> saveBlog(@Valid @RequestBody Blog blog, Errors errors) throws ValidationException {

        if (errors.hasErrors()) {
            throw new ValidationException(errors);
        }

        return new ResponseEntity<>(blogService.saveBlog(blog), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = BlogConstants.GET_ALL_BLOGS,
            produces = BlogConstants.APPLICATION_JSON)
    public ResponseEntity<?> getAllBlogs() {
        return new ResponseEntity<>(blogService.getAllBlogs(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = BlogConstants.GET_BLOG_BY_BLOG_ID,
            produces = BlogConstants.APPLICATION_JSON)
    public ResponseEntity<?> getBlogByBlogId(@PathVariable Integer id) {
        Optional<Blog> opt = blogService.getBlogByBlogId(id);
        return new ResponseEntity<>((opt.isPresent() ? opt.get() : BlogConstants.NO_BLOG_MESSAGE), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = BlogConstants.GET_BLOGS_BY_BLOG_TITLE,
            produces = BlogConstants.APPLICATION_JSON)
    public ResponseEntity<?> findBlogsByBlogTitle(@PathVariable String title) {
        List<Blog> blogs = blogService.findBlogsByBlogTitle(title);
        return new ResponseEntity<>((blogs.size() == 0) ? BlogConstants.NO_BLOG_MESSAGE : blogs, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = BlogConstants.GET_BLOGS_BY_BLOG_AUTHOR_ID,
            produces = BlogConstants.APPLICATION_JSON)
    public ResponseEntity<?> findBlogsByBlogAuthorId(@PathVariable String authorId) {
        List<Blog> blogs = blogService.findBlogsByBlogAuthorId(authorId);
        return new ResponseEntity<>((blogs.size() == 0) ? BlogConstants.NO_BLOG_MESSAGE : blogs, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = BlogConstants.UPDATE_BLOG,
            consumes = BlogConstants.APPLICATION_JSON)
    public ResponseEntity<?> updateBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>((blogService.updateBlog(blog) ? BlogConstants.UPDATE_BLOG_SUCCESS : BlogConstants.NO_BLOG_MESSAGE), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = BlogConstants.DELETE_BLOG)
    public ResponseEntity<?> deleteBlog(@PathVariable Integer blogId) {
        return new ResponseEntity<>((blogService.deleteBlog(blogId) ? BlogConstants.DELETE_BLOG_SUCCESS : BlogConstants.NO_BLOG_MESSAGE), HttpStatus.OK);
    }
}
