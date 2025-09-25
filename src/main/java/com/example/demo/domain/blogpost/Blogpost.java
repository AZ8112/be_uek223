package com.example.demo.domain.blogpost;

import com.example.demo.core.generic.AbstractEntity;
import com.example.demo.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "blogpost")
@NoArgsConstructor
@Getter
@Setter
public class Blogpost extends AbstractEntity {
    @NotNull
    @Column(name = "title")
    @Size(min = 3, max = 80)
    private String title;

    @NotNull
    @Column(name = "text", nullable = false)
    @Size(min = 5, max = 8000)
    private String text;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, length = 50)
    private BlogpostCategoryEnum category;

    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    private User author;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public Blogpost(UUID id, String title, String text, User author) {
        super(id);
        this.title = title;
        this.text = text;
        this.author = author;
        this.createdAt = LocalDateTime.now();
    }
}
