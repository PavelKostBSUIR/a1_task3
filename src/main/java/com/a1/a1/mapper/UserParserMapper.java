package com.a1.a1.mapper;

import com.a1.a1.entity.domain.User;
import com.a1.a1.entity.dto.UserParserDto;
import com.a1.a1.repo.ApplicationRepository;
import com.a1.a1.repo.DepartmentRepository;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {DepartmentRepository.class, ApplicationRepository.class})
public interface UserParserMapper {
    @Mapping(source = "departmentId", target = "department")
    @Mapping(source = "applicationId", target = "application")
    User userParserDtoToUser(UserParserDto userParserDto);

    UserParserDto userToUserParserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromUserParserDto(UserParserDto userParserDto, @MappingTarget User user);
}
