package com.example.demo.domain.blogpost.dto;

import com.example.demo.core.generic.AbstractDTO;
import com.example.demo.domain.blogpost.BlogpostCategoryEnum;
import com.example.demo.domain.user.dto.UserDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BlogpostDTO extends AbstractDTO {
    @NotNull
    @Size(min = 3, max = 80)
    private String title;
    @NotNull
    @Size(min = 5, max = 8000)
    private String text;
    @NotNull
    private BlogpostCategoryEnum category;
    private LocalDateTime createdAt;
    private UserDTO.BaseUserDTO author;
}
