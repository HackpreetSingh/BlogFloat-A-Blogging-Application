package com.blogs.model;

import com.blogs.constants.BlogConstants;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = BlogConstants.TABLE_NAME)
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogId;
    @NotEmpty(message = "{blog.title.empty}")
    private String blogTitle;

    @NotEmpty(message = "{blog.description.empty}")
    private String description;

    @NotEmpty(message = "{blog.blogAuthorId.empty}")
    private String blogAuthorId;

    @NotNull(message = "{blog.publishDate.empty}")
    private LocalDateTime publishDate;

    @NotNull(message = "{blog.isPublic.null}")
    private Boolean isPublic;
}
