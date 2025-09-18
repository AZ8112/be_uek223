package com.example.demo.domain.blogpost;

import com.example.demo.core.generic.AbstractRepository;
import com.example.demo.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogpostRepository extends AbstractRepository<Blogpost> {
    List<Blogpost> findByAuthor(User author);
}
