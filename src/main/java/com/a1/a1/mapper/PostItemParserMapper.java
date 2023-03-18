package com.a1.a1.mapper;

import com.a1.a1.entity.domain.PostItem;
import com.a1.a1.entity.dto.PostItemParserDto;
import com.a1.a1.repo.ItemRepository;
import com.a1.a1.repo.PostRepository;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {ItemRepository.class, PostRepository.class})
public interface PostItemParserMapper {

    @Mapping(source = "itemDescription", target = "item")
    @Mapping(source = "postMatDoc", target = "post")
    PostItem postItemParserDtoToPostItem(PostItemParserDto postItemParserDto);

    PostItemParserDto postItemToPostItemParserDto(PostItem postItem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PostItem updatePostItemFromPostItemParserDto(PostItemParserDto postItemParserDto, @MappingTarget PostItem postItem);
}
