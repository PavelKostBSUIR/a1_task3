package com.a1.a1.mapper;

import com.a1.a1.entity.domain.Post;
import com.a1.a1.entity.dto.GetPostDto;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface GetPostMapper {
    Post getPostDtoToPost(GetPostDto getPostDto);

    GetPostDto postToGetPostDto(Post post);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Post updatePostFromGetPostDto(GetPostDto getPostDto, @MappingTarget Post post);
}
