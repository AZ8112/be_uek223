package com.example.demo.domain.blogpost.dto;

import com.example.demo.core.generic.AbstractMapper;
import com.example.demo.domain.blogpost.Blogpost;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BlogpostMapper extends AbstractMapper<Blogpost, BlogpostDTO> {

}
