package com.a1.a1.mapper;

import com.a1.a1.entity.domain.Bun;
import com.a1.a1.entity.dto.BunParserDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface BunParserMapper {
    Bun bunParserDtoToBun(BunParserDto BunParserDto);

    BunParserDto bunToBunParserDto(Bun bun);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Bun updateBunFromBunParserDto(BunParserDto BunParserDto, @MappingTarget Bun bun);
}
