package com.a1.a1.mapper;

import com.a1.a1.entity.domain.Post;
import com.a1.a1.entity.dto.PostParserDto;
import com.a1.a1.repo.BUnRepository;
import com.a1.a1.repo.CurrencyRepository;
import com.a1.a1.repo.PostRepository;
import com.a1.a1.repo.UserRepository;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = { UserRepository.class })
public interface PostParserMapper {

    @Mapping(source = "appAccountName", target = "user")
    Post postParserDtoToPost(PostParserDto postParserDto);

    PostParserDto postToPostParserDto(Post post);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Post updatePostFromPostParserDto(PostParserDto postParserDto, @MappingTarget Post post);
}
