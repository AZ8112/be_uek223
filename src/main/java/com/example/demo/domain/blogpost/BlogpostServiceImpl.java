package com.example.demo.domain.blogpost;

import com.example.demo.core.generic.AbstractServiceImpl;
import com.example.demo.domain.blogpost.dto.BlogpostDTO;
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
    public Blogpost updateBlogpost(UUID id, BlogpostDTO blogpostDTO)
            throws NoSuchElementException, IllegalArgumentException {
        log.info("Updating blogpost with id: {}", id);
        if (blogpostDTO == null) {
            log.error("Blogpost with id {} is null -> cannot update", id);
            throw new IllegalArgumentException(String.format("The given blogpost with id: '%s' cannot be null", id));
        }

        Blogpost existingBlogpost = repository.findById(id)
                .orElseThrow(() -> {
                    log.error("Blogpost with id {} not found in repository", id);
                    return new NoSuchElementException(
                            String.format("Blogpost with id: '%s' was not found", id));
                });
        log.debug("Found blogpost with id {} -> updating fields", id);
        existingBlogpost.setTitle(blogpostDTO.getTitle());
        existingBlogpost.setText(blogpostDTO.getText());
        log.info("Successfully updated blogpost with id: {}", id);
        return repository.save(existingBlogpost);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteBlogpost(UUID id) throws EntityNotFoundException {
        log.info("Deleting blogpost with id: {}", id);
        if (!repository.existsById(id)) {
            log.warn("Attempted to delete non-existing blogpost with id {}", id);
            throw new EntityNotFoundException(String.format("Blogpost with id: %s doesn't exist", id));
        } else {
            repository.deleteById(id);
            log.info("Successfully deleted blogpost with id: {}", id);
        }
    }
}
