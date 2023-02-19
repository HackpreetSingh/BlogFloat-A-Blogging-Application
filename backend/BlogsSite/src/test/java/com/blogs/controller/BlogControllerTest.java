package com.blogs.controller;

import com.blogs.constants.BlogConstants;
import com.blogs.model.Blog;
import com.blogs.service.BlogService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BlogControllerTest {

    @Mock
    private BlogService mockBlogService;

    @InjectMocks
    private BlogController blogController;

    @Test
    void testDeleteBlog() {
        // Setup
        final ResponseEntity<?> expectedResult = new ResponseEntity<>(BlogConstants.DELETE_BLOG_SUCCESS, HttpStatus.OK);
        when(mockBlogService.deleteBlog(0)).thenReturn(true);

        // Run the test
        final ResponseEntity<?> result = blogController.deleteBlog(0);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindBlogsByBlogAuthorId() {
        // Setup
        final List<Blog> blogs = List.of(
                new Blog(0, "blogTitle", "description", "blogAuthorId", LocalDateTime.of(2020, 1, 1, 0, 0, 0), false));
        final ResponseEntity<?> expectedResult = new ResponseEntity<>(blogs, HttpStatus.OK);

        // Configure BlogService.findBlogsByBlogAuthorId(...).
        when(mockBlogService.findBlogsByBlogAuthorId("blogAuthorId")).thenReturn(blogs);

        // Run the test
        final ResponseEntity<?> result = blogController.findBlogsByBlogAuthorId("blogAuthorId");

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindBlogsByBlogAuthorId_BlogServiceReturnsNoItems() {
        // Setup
        final ResponseEntity<?> expectedResult = new ResponseEntity<>(BlogConstants.NO_BLOG_MESSAGE, HttpStatus.OK);
        when(mockBlogService.findBlogsByBlogAuthorId("authorId")).thenReturn(Collections.emptyList());

        // Run the test
        final ResponseEntity<?> result = blogController.findBlogsByBlogAuthorId("authorId");

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindBlogsByBlogTitle() {
        // Setup
        final List<Blog> blogs = List.of(
                new Blog(0, "blogTitle", "description", "blogAuthorId", LocalDateTime.of(2020, 1, 1, 0, 0, 0), false));
        final ResponseEntity<?> expectedResult = new ResponseEntity<>(blogs, HttpStatus.OK);

        // Configure BlogService.findBlogsByBlogTitle(...).
        when(mockBlogService.findBlogsByBlogTitle("blogTitle")).thenReturn(blogs);

        // Run the test
        final ResponseEntity<?> result = blogController.findBlogsByBlogTitle("blogTitle");

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindBlogsByBlogTitle_BlogServiceReturnsNoItems() {
        // Setup
        final ResponseEntity<?> expectedResult = new ResponseEntity<>(BlogConstants.NO_BLOG_MESSAGE, HttpStatus.OK);
        when(mockBlogService.findBlogsByBlogTitle("title")).thenReturn(Collections.emptyList());

        // Run the test
        final ResponseEntity<?> result = blogController.findBlogsByBlogTitle("title");

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetAllBlogs() {
        // Setup
        final List<Blog> blogs = List.of(
                new Blog(0, "blogTitle", "description", "blogAuthorId", LocalDateTime.of(2020, 1, 1, 0, 0, 0), false));
        final ResponseEntity<?> expectedResult = new ResponseEntity<>(blogs, HttpStatus.OK);

        // Configure BlogService.getAllBlogs(...).
        when(mockBlogService.getAllBlogs()).thenReturn(blogs);

        // Run the test
        final ResponseEntity<?> result = blogController.getAllBlogs();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetAllBlogs_BlogServiceReturnsNoItems() {
        // Setup
        final ResponseEntity<?> expectedResult = new ResponseEntity<>(BlogConstants.NO_BLOG_MESSAGE, HttpStatus.OK);
        when(mockBlogService.getAllBlogs()).thenReturn(Collections.emptyList());

        // Run the test
        final ResponseEntity<?> result = blogController.getAllBlogs();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetBlogByBlogId() {
        // Setup
        final Optional<Blog> blog = Optional.of(
                new Blog(0, "blogTitle", "description", "blogAuthorId", LocalDateTime.of(2020, 1, 1, 0, 0, 0), false));
        final ResponseEntity<?> expectedResult = new ResponseEntity<>(blog.get(), HttpStatus.OK);

        // Configure BlogService.getBlogByBlogId(...).
        when(mockBlogService.getBlogByBlogId(0)).thenReturn(blog);

        // Run the test
        final ResponseEntity<?> result = blogController.getBlogByBlogId(0);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetBlogByBlogId_BlogServiceReturnsAbsent() {
        // Setup
        final ResponseEntity<?> expectedResult = new ResponseEntity<>(BlogConstants.NO_BLOG_MESSAGE, HttpStatus.OK);
        when(mockBlogService.getBlogByBlogId(0)).thenReturn(Optional.empty());

        // Run the test
        final ResponseEntity<?> result = blogController.getBlogByBlogId(0);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testSaveBlog() {
        // Setup
        final Blog blog = new Blog(0, "blogTitle", "description", "blogAuthorId", LocalDateTime.of(2020, 1, 1, 0, 0, 0),
                false);
        final Errors errors = Mockito.mock(Errors.class);
        final ResponseEntity<?> expectedResult = new ResponseEntity<>(null, HttpStatus.OK);

        // Configure BlogService.saveBlog(...).
        when(mockBlogService.saveBlog(blog)).thenReturn(blog);
        when(errors.hasErrors()).thenReturn(false);
        // Run the test
        final ResponseEntity<?> result = blogController.saveBlog(blog, errors);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testUpdateBlog() {
        // Setup
        final Blog blog = new Blog(0, "blogTitle", "description", "blogAuthorId", LocalDateTime.of(2020, 1, 1, 0, 0, 0),
                false);
        final ResponseEntity<?> expectedResult = new ResponseEntity<>(BlogConstants.UPDATE_BLOG_SUCCESS, HttpStatus.OK);
        when(mockBlogService.updateBlog(blog)).thenReturn(true);

        // Run the test
        final ResponseEntity<?> result = blogController.updateBlog(blog);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
