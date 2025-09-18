package com.example.demo.domain.blogpost.dto;

import com.example.demo.core.generic.AbstractMapper;
import com.example.demo.domain.blogpost.Blogpost;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BlogpostMapper extends AbstractMapper<Blogpost, BlogpostDTO> {
    BlogpostDTO toDTO(Blogpost blogpost);
    Collection<BlogpostDTO> toDTOs(Collection<Blogpost> blogposts);

    Blogpost fromDTO(BlogpostDTO dto);
    Collection<Blogpost> fromDTOs(Collection<BlogpostDTO> dtos);
}