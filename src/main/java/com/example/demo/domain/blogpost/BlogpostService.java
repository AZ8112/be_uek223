package com.example.demo.domain.blogpost;

import com.example.demo.core.generic.AbstractService;
import com.example.demo.domain.blogpost.dto.BlogpostDTO;
import com.example.demo.domain.user.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.core.exception.InvalidCategoryException;

import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.List;

public interface BlogpostService extends AbstractService<Blogpost> {

    /**
     * Filters by amount of entries shown on a page, additionally it can filter by categories
     *
     * @param category value to be searched for
     * @param pageable to enter the amount of entries to be shown and what page to be on
     * @return all blogposts filtered by pages and categories
     * @throws InvalidCategoryException if a category doesn't exist
     * @see Blogpost
     * @see BlogpostCategoryEnum
     */
    Page<Blogpost> findAllPaginated(String category, Pageable pageable);

    /**
     * Find a blogpost by searching for the blogpost id
     *
     * @param id value to be searched for
     * @return a blogpost by id
     * @throws RuntimeException if id doesn't exist
     * @see Blogpost
     */
    Blogpost findById(UUID id);

    /**
     * Find a blogpost by searching for the author id
     *
     * @param author value to be searched for
     * @return all blogposts by an author
     * @see Blogpost
     */
    List<Blogpost> findBlogpostsByAuthor(User author);

    /**
     * Creates a blogpost with title, text and category. Automatically sets the author
     *
     * @param newBlogpost values to be updated to
     * @return created blogpost with the entered values
     * @throws IllegalArgumentException if a value that is not null is empty
     * @see Blogpost
     */
    Blogpost createBlogpost(Blogpost newBlogpost);

    /**
     * update the title, text and category of a blogpost
     *
     * @param id      blogpost id
     * @param blogpostDTO values to be updated to
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
    void deleteById(UUID id) throws EntityNotFoundException;
}
