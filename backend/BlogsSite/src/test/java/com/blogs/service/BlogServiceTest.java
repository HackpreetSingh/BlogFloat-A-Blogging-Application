package com.blogs.service;

import com.blogs.model.Blog;
import com.blogs.repository.BlogRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BlogServiceTest {
    @Mock
    private BlogRepo blogRepo;
    @InjectMocks
    private BlogService blogService;

    @Test
    void testDeleteBlog() {
        // Setup
        when(blogRepo.deleteBlogByBlogId(1)).thenReturn(1);

        // Run the test
        final boolean result = blogService.deleteBlog(1);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testDeleteBlog_Fail() {
        // Setup
        when(blogRepo.deleteBlogByBlogId(1)).thenReturn(0);

        // Run the test
        final boolean result = blogService.deleteBlog(1);

        // Verify the results
        assertFalse(result);
    }

    @Test
    void testFindBlogsByBlogAuthorId() {
        // Setup
        final List<Blog> expectedResult = List.of(
                new Blog(0, "blogTitle", "description", "blogAuthorId", LocalDateTime.of(2020, 1, 1, 0, 0, 0), false));

        // Configure BlogRepo.findBlogsByBlogAuthorId(...).
        when(blogRepo.findBlogsByBlogAuthorId("blogAuthorId")).thenReturn(expectedResult);

        // Run the test
        final List<Blog> result = blogService.findBlogsByBlogAuthorId("blogAuthorId");

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindBlogsByBlogAuthorId_BlogRepoReturnsNoItems() {
        // Setup
        when(blogRepo.findBlogsByBlogAuthorId("authorId")).thenReturn(Collections.emptyList());

        // Run the test
        final List<Blog> result = blogService.findBlogsByBlogAuthorId("authorId");

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void testFindBlogsByBlogTitle() {
        // Setup
        final List<Blog> expectedResult = List.of(
                new Blog(0, "blogTitle", "description", "blogAuthorId", LocalDateTime.of(2020, 1, 1, 0, 0, 0), false));

        // Configure BlogRepo.findBlogsByBlogTitle(...).
        when(blogRepo.findBlogsByBlogTitle("blogTitle")).thenReturn(expectedResult);

        // Run the test
        final List<Blog> result = blogService.findBlogsByBlogTitle("blogTitle");

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindBlogsByBlogTitle_BlogRepoReturnsNoItems() {
        // Setup
        when(blogRepo.findBlogsByBlogTitle("title")).thenReturn(Collections.emptyList());

        // Run the test
        final List<Blog> result = blogService.findBlogsByBlogTitle("title");

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void testGetAllBlogs() {
        // Setup
        final List<Blog> expectedResult = List.of(
                new Blog(0, "blogTitle", "description", "blogAuthorId", LocalDateTime.of(2020, 1, 1, 0, 0, 0), false));

        // Configure BlogRepo.findAll(...).
        when(blogRepo.findAll()).thenReturn(expectedResult);

        // Run the test
        final List<Blog> result = blogService.getAllBlogs();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetAllBlogs_BlogRepoReturnsNoItems() {
        // Setup
        when(blogRepo.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Blog> result = blogService.getAllBlogs();

        // Verify the results
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void testGetBlogByBlogId() {
        // Setup
        final Optional<Blog> expectedResult = Optional.of(
                new Blog(0, "blogTitle", "description", "blogAuthorId", LocalDateTime.of(2020, 1, 1, 0, 0, 0), false));

        // Configure BlogRepo.findById(...).
        when(blogRepo.findById(0)).thenReturn(expectedResult);

        // Run the test
        final Optional<Blog> result = blogService.getBlogByBlogId(0);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testGetBlogByBlogId_BlogRepoReturnsAbsent() {
        // Setup
        when(blogRepo.findById(0)).thenReturn(Optional.empty());

        // Run the test
        final Optional<Blog> result = blogService.getBlogByBlogId(0);

        // Verify the results
        assertEquals(Optional.empty(), result);
    }

    @Test
    void testSaveBlog() {
        // Setup
        final Blog expectedResult = new Blog(0, "blogTitle", "description", "blogAuthorId",
                LocalDateTime.of(2020, 1, 1, 0, 0, 0), false);

        // Configure BlogRepo.saveAndFlush(...).
        final Blog actualResult = new Blog(0, "blogTitle", "description", "blogAuthorId",
                LocalDateTime.of(2020, 1, 1, 0, 0, 0), false);
        when(blogRepo.saveAndFlush(
                actualResult)).thenReturn(actualResult);

        // Run the test
        final Blog result = blogService.saveBlog(expectedResult);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    void testUpdateBlog_Fail() {
        // Setup
        final Blog blog = new Blog(0, "blogTitle", "description", "blogAuthorId", LocalDateTime.of(2020, 1, 1, 0, 0, 0),
                false);
        when(blogRepo.updateBlog("blogTitle", "description", 0)).thenReturn(0);

        // Run the test
        final Boolean result = blogService.updateBlog(blog);

        // Verify the results
        assertFalse(result);
    }

    @Test
    void testUpdateBlog() {
        // Setup
        final Blog blog = new Blog(0, "blogTitle", "description", "blogAuthorId", LocalDateTime.of(2020, 1, 1, 0, 0, 0),
                false);
        when(blogRepo.updateBlog("blogTitle", "description", 0)).thenReturn(1);

        // Run the test
        final Boolean result = blogService.updateBlog(blog);

        // Verify the results
        assertTrue(result);
    }
}
