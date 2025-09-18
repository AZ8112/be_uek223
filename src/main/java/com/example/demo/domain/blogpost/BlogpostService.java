package com.example.demo.domain.blogpost;

import com.example.demo.core.generic.AbstractService;

import java.util.List;
import java.util.UUID;

public interface BlogpostService extends AbstractService<Blogpost> {

    List<Blogpost> findAllBlogposts();

    Blogpost findBlogpostById(UUID id);

    List<Blogpost> findBlogpostsByAuthor(UUID authorId);
}
