package com.example.demo.domain.blogpost;

import com.example.demo.domain.blogpost.dto.BlogpostDTO;
import com.example.demo.domain.blogpost.dto.BlogpostMapper;
import com.example.demo.domain.user.User;
import com.example.demo.domain.user.UserService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogposts")
public class BlogpostController {   
    private final BlogpostService blogpostService;
    private final UserService userService;
    private final BlogpostMapper blogpostMapper;

    public BlogpostController(BlogpostService blogpostService, BlogpostMapper blogpostMapper, UserService userService) {
        this.blogpostService = blogpostService;
        this.userService = userService;
        this.blogpostMapper = blogpostMapper;
    }

    @GetMapping
    @ApiResponse(responseCode = "200", description = "Successfully found courses with pagination information",
            content = {@Content(mediaType = "application/json")})
    public ResponseEntity<List<BlogpostDTO>> findAll(
            @RequestParam(defaultValue = "false") boolean includeDisabled,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Blogpost> blogposts = blogpostService.findAllPaginated(includeDisabled, pageable);
        List<BlogpostDTO> blogpostDTOS = blogposts.stream().map(blogpostMapper::toDTO).toList();
        return new ResponseEntity<>(blogpostDTOS, HttpStatus.OK);
    }

    @GetMapping("/{blogpostId}")
    public ResponseEntity<BlogpostDTO> findById(@PathVariable UUID blogpostId) {
        Blogpost blogpost = blogpostService.findById(blogpostId);
        return new ResponseEntity<>(blogpostMapper.toDTO(blogpost), HttpStatus.OK);
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<BlogpostDTO>> findByAuthor(@PathVariable UUID authorId) {
        User blogpostAuthor = userService.findById(authorId);
        List<Blogpost> authorBlogposts = blogpostService.findBlogpostsByAuthor(blogpostAuthor);
        List<BlogpostDTO> authorBlogpostDTOS = authorBlogposts.stream().map(blogpostMapper::toDTO).toList();
        return new ResponseEntity<>(authorBlogpostDTOS, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('BLOGPOST_CREATE')")
    public ResponseEntity<BlogpostDTO> createBlogpost(@Valid @RequestBody Blogpost blogpost) {
        Blogpost createdBlogpost = blogpostService.createBlogpost(blogpost);
        return new ResponseEntity<>(blogpostMapper.toDTO(createdBlogpost), HttpStatus.CREATED);
    }

    @PutMapping("/{blogpostId}")
    @PreAuthorize("hasRole('ADMIN') or hasAuthority('BLOGPOST_UPDATE')")
    public ResponseEntity<BlogpostDTO> updateBlogpost(@Valid @PathVariable UUID blogpostId, @RequestBody @Valid BlogpostDTO blogpostDTO) {
        Blogpost updatedBlogpost = blogpostService.updateBlogpost(blogpostId, blogpostDTO);
        return new ResponseEntity<>(blogpostMapper.toDTO(updatedBlogpost), HttpStatus.OK);
    }

    @DeleteMapping("/{blogpostId}")
    @PreAuthorize("hasRole('ADMIN') or hasAuthority('BLOGPOST_DELETE')")
    public ResponseEntity<Void> deleteById(@PathVariable UUID blogpostId) {
        blogpostService.deleteById(blogpostId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}