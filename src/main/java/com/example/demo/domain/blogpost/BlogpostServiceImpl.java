package com.example.demo.domain.blogpost;

import com.example.demo.core.generic.AbstractServiceImpl;
import org.springframework.stereotype.Service;

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
}
