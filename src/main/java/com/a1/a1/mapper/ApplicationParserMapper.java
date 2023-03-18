package com.a1.a1.mapper;

import com.a1.a1.entity.domain.Application;
import com.a1.a1.entity.dto.ApplicationParserDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ApplicationParserMapper {
    Application applicationParserDtoToApplication(ApplicationParserDto applicationParserDto);

    ApplicationParserDto applicationToApplicationParserDto(Application application);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Application updateApplicationFromApplicationParserDto(ApplicationParserDto applicationParserDto, @MappingTarget Application application);
}
