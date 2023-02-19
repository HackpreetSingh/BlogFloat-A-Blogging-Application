package com.blogs.constants;

public final class BlogConstants {
    public static final String APPLICATION_JSON = "application/json";
    public static final String SAVE_BLOG = "/saveBlog";
    public static final String GET_ALL_BLOGS = "/getAllBlogs";
    public static final String GET_BLOG_BY_BLOG_ID = "/getBlogByBlogId/{id}";
    public static final String GET_BLOGS_BY_BLOG_TITLE = "/findBlogsByBlogTitle/{title}";
    public static final String GET_BLOGS_BY_BLOG_AUTHOR_ID = "/findBlogsByBlogAuthorId/{authorId}";
    public static final String FIND_BLOGS_BY_BLOG_TITLE_QUERY = "Select b from blogs b where b.blogTitle LIKE %?1%";
    public static final String FIND_BLOGS_BY_BLOG_AUTHOR_ID_QUERY = "Select b from blogs b where b.blogAuthorId=?1";
    public static final String UTF_8 = "UTF-8";
    public static final String NO_BLOG_MESSAGE = "No Blog with this blog id exists!";
    public static final String UPDATE_BLOG_QUERY = "Update blogs b set b.blogTitle=?1, b.description=?2 where b.blogId=?3";
    public static final String UPDATE_BLOG = "/updateBlog";
    public static final String UPDATE_BLOG_SUCCESS = "Blog has been updated.";
    public static final String DELETE_BLOG = "/deleteBlog/{blogId}";
    public static final String DELETE_BLOG_QUERY = "delete from blogs b where b.blogId=?1";
    public static final String DELETE_BLOG_SUCCESS = "Blog has been deleted.";
    public static final String TABLE_NAME = "blogs";

    /**
     * Creating private constructor so that its object cannot be instantiated
     */
    private BlogConstants() {
    }
}
