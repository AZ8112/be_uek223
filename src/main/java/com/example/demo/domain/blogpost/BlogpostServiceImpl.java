package com.example.demo.domain.blogpost;

import com.example.demo.core.generic.AbstractServiceImpl;
import com.example.demo.domain.blogpost.dto.BlogpostDTO;
import com.example.demo.domain.user.User;
import com.example.demo.domain.role.Role;
import com.example.demo.domain.user.UserDetailsImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.util.*;

@Log4j2
@Service
public class BlogpostServiceImpl extends AbstractServiceImpl<Blogpost> implements BlogpostService {
    private final BlogpostRepository blogpostRepository;
    private static final String NOT_FOUND_BLOGPOST = "Blogpost not found with id: ";

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
        Blogpost existingBlogpost = repository.findById(id)
                .orElseThrow(() -> {
                    log.error("Blogpost with id {} not found in repository", id);
                    return new NoSuchElementException(
                            String.format("Blogpost with id: '%s' was not found", id));
                });

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        User currentUser = userDetails.user();

        if (!existingBlogpost.getAuthor().getId().equals(currentUser.getId())) {
            throw new AccessDeniedException("You do not have permission to update this blogpost");
        }

        log.info("Updating blogpost with id: {}", id);
        if (blogpostDTO == null) {
            log.error("Blogpost with id {} is null -> cannot update", id);
            throw new IllegalArgumentException(String.format("The given blogpost with id: '%s' cannot be null", id));
        }

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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        User currentUser = userDetails.user();
        log.info("Deleting blogpost with id: {}", id);
        Blogpost existingBlogpost = blogpostRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(NOT_FOUND_BLOGPOST + id));
        if (!existingBlogpost.getAuthor().getId().equals(currentUser.getId())) {
            throw new AccessDeniedException("You do not have permission to update this blogpost");
        }
        blogpostRepository.delete(existingBlogpost);
    }
}
