package com.example.demo.domain.blogpost;

import com.example.demo.domain.blogpost.dto.BlogpostDTO;
import com.example.demo.domain.blogpost.dto.BlogpostMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{blogpostId}")
    @PreAuthorize("hasAuthority('BLOGPOST_UPDATE')")
    public ResponseEntity<BlogpostDTO> updateBlogpost(@PathVariable UUID blogpostId, @RequestBody @Valid BlogpostDTO blogpostDTO) {
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