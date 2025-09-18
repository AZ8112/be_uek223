package com.example.demo.domain.blogpost;

import com.example.demo.core.generic.AbstractServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.util.*;

@Log4j2
@Service
public class BlogpostServiceImpl extends AbstractServiceImpl<Blogpost> implements BlogpostService {


    private final BlogpostRepository blogpostRepository;

    public BlogpostServiceImpl(BlogpostRepository blogpostRepository) {
        this.blogpostRepository = blogpostRepository;
    }

    public List<Blogpost> findAllBlogposts(){
        List<Blogpost> post = repository.findAll();
        if (post.isEmpty()){
            log.warn("No blogposts found in the database");
        } else {
            log.info(post.size() + " blogposts retrieved from database.");
        }
        return post;
    }

    public Blogpost findBlogpostById(UUID id){
        return blogpostRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Blogpost with ID {} not found.", id);
                    return new RuntimeException("Blogpost not found");
                });

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
                .orElseThrow(() -> new NoSuchElementException(String.format("Blogpost with id: '%s' was not found", id)));
        existingBlogpost.setTitle(blogpost.getTitle());
        existingBlogpost.setText(blogpost.getText());
        existingBlogpost.setAuthor(blogpost.getAuthor());
        existingBlogpost.setCreatedAt(blogpost.getCreatedAt());
        return repository.save(existingBlogpost);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteBlogpost(UUID id) throws EntityNotFoundException {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(String.format("Blogpost with id: %s doesn't exist", id));
        } else {
            repository.deleteById(id);
        }
    }
}
