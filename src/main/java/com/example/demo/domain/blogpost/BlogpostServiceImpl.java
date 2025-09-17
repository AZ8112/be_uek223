package com.example.demo.domain.blogpost;

import com.example.demo.core.generic.AbstractServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogpostServiceImpl extends AbstractServiceImpl<Blogpost> implements BlogpostService {

    private final BlogpostService blogpostService;

    public BlogpostServiceImpl(BlogpostRepository repository, BlogpostService userService) {
        super(repository);
        this.blogpostService = userService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Blogpost updateBlogpost(UUID id, Blogpost blogpost)
            throws NoSuchElementException, IllegalArgumentException {
        if (blogpost == null) {
            throw new IllegalArgumentException(String.format("The given blogpost with id: '%s' cannot be null", id));
        }

        Blogpost existingBlogpost = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Company with id: '%s' was not found", id)));
        existingBlogpost.setTitle(blogpost.getTitle());
        existingBlogpost.setText(blogpost.getText());
        existingBlogpost.setAuthor(blogpost.getAuthor());
        existingBlogpost.setCreatedAt(blogpost.getCreatedAt());
        return repository.save(existingBlogpost);
    }
}
