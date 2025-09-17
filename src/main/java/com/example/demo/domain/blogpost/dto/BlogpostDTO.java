package com.example.demo.domain.blogpost.dto;

import com.example.demo.core.generic.AbstractDTO;
import com.example.demo.domain.user.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BlogpostDTO extends AbstractDTO {
    @NotNull
    @Size(min = 1, max = 255)
    private String title;
    @NotNull
    @Size(min = 1, max = 8000)
    private String text;
    private LocalDateTime createdAt;
    private User author;
}
