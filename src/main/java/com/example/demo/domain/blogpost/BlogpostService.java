package com.example.demo.domain.blogpost;

import com.example.demo.core.generic.AbstractService;
import com.example.demo.domain.blogpost.dto.BlogpostDTO;
import com.example.demo.domain.user.User;
import jakarta.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.List;

public interface BlogpostService extends AbstractService<Blogpost> {
    List<Blogpost> findAllBlogposts();

    Blogpost findBlogpostById(UUID id);

    List<Blogpost> findBlogpostsByAuthor(User author);

    Blogpost createBlogpost(Blogpost newBlogpost);
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
    Blogpost updateBlogpost(UUID id, BlogpostDTO blogpostDTO)
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
