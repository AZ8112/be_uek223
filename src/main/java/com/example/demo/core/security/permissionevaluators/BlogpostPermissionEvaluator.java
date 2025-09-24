package com.example.demo.core.security.permissionevaluators;

import com.example.demo.domain.blogpost.BlogpostRepository;
import com.example.demo.domain.user.User;
import org.springframework.stereotype.Component;
import com.example.demo.domain.role.Role;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.blogpost.Blogpost;

import java.util.*;
import java.util.UUID;

@Component
public class BlogpostPermissionEvaluator {
    private final BlogpostRepository blogpostRepository;

    public BlogpostPermissionEvaluator(BlogpostRepository blogpostRepository) {
        this.blogpostRepository = blogpostRepository;
    }
    public boolean canModify(User currentUser, UUID blogpostId) {
        if (currentUser == null || blogpostId == null) return false;

        Optional<Blogpost> opt = blogpostRepository.findById(blogpostId);
        if (opt.isEmpty()) return false;

        Blogpost bp = opt.get();

        boolean isAdmin = currentUser.getRoles().stream()
                .map(Role::getName)
                .filter(Objects::nonNull)
                .anyMatch(n -> n.equalsIgnoreCase("ADMIN"));

        boolean isOwner = bp.getAuthor() != null
                && Objects.equals(bp.getAuthor().getId(), currentUser.getId());

        return isAdmin || isOwner;
    }
}
