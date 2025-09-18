package com.example.demo.domain.blogpost;

import com.example.demo.core.generic.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BlogpostRepository extends AbstractRepository<Blogpost> {
    List<Blogpost> findByAuthor(UUID authorId);
}
