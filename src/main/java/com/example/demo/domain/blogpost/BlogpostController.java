package com.example.demo.domain.blogpost;

import com.example.demo.domain.blogpost.dto.BlogpostDTO;
import com.example.demo.domain.blogpost.dto.BlogpostMapper;
import jakarta.validation.Valid;
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
    private final BlogpostMapper blogpostMapper;

    public BlogpostController(BlogpostService blogpostService, BlogpostMapper blogpostMapper) {
        this.blogpostService = blogpostService;
        this.blogpostMapper = blogpostMapper;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('BLOGPOST_READ')")
    public ResponseEntity<List<BlogpostDTO>> findAll() {
        List<Blogpost> blogposts = blogpostService.findAll();
        List<BlogpostDTO> blogpostDTOS = blogposts.stream().map(blogpostMapper::toDTO).toList();
        return new ResponseEntity<>(blogpostDTOS, HttpStatus.OK);
    }

    @GetMapping("/{blogpostId}")
    @PreAuthorize("hasAuthority('BLOGPOST_READ')")
    public ResponseEntity<BlogpostDTO> findById(@PathVariable UUID blogpostId) {
        Blogpost blogpost = blogpostService.findById(blogpostId);
        return new ResponseEntity<>(blogpostMapper.toDTO(blogpost), HttpStatus.OK);
    }

    @GetMapping("/author/{authorId}")
    @PreAuthorize("hasAuthority('BLOGPOST_READ')")
    public ResponseEntity<List<BlogpostDTO>> findByAuthor(@PathVariable UUID authorId) {
        List<Blogpost> authorBlogposts = blogpostService.findBlogpostsByAuthor(authorId);
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
    @PreAuthorize("hasAuthority('BLOGPOST_UPDATE')")
    public ResponseEntity<BlogpostDTO> updateBlogpost(@Valid @PathVariable UUID blogpostId, @RequestBody @Valid BlogpostDTO blogpostDTO) {
        Blogpost updatedBlogpost = blogpostService.updateBlogpost(blogpostId, blogpostDTO);
        return new ResponseEntity<>(blogpostMapper.toDTO(updatedBlogpost), HttpStatus.OK);
    }

    @DeleteMapping("/{blogpostId}")
    @PreAuthorize("hasAuthority('BLOGPOST_DELETE')")
    public ResponseEntity<Void> deleteById(@PathVariable UUID blogpostId) {
        blogpostService.deleteById(blogpostId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}