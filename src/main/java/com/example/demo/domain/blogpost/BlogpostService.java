package com.example.demo.domain.blogpost;

import com.example.demo.core.generic.AbstractService;
import jakarta.persistence.EntityNotFoundException;

import java.util.NoSuchElementException;
import java.util.UUID;

public interface BlogpostService extends AbstractService<Blogpost> {
    /**
     * update name of blogpost entity by given id
     *
     * @param id      blogpost id
     * @param blogpost values to be updated to
     * @return updated blogpost with the updated name
     * @throws NoSuchElementException   if the blogpost was not found
     * @throws IllegalArgumentException if the name is null or blank
     * @see Blogpost
     */
    Blogpost updateBlogpost(UUID id, Blogpost blogpost)
            throws NoSuchElementException, IllegalArgumentException;

    /**
     * delete a blogpost by its id
     *
     * @param id of blogpost
     * @throws EntityNotFoundException if blogpost not found
     * @see Blogpost
     */
    void deleteBlogpost(UUID id) throws EntityNotFoundException;
}
