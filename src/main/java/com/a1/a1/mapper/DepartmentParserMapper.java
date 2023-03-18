package com.a1.a1.mapper;

import com.a1.a1.entity.domain.Department;
import com.a1.a1.entity.dto.DepartmentParserDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DepartmentParserMapper {
    Department departmentParserDtoToDepartment(DepartmentParserDto departmentDto);

    DepartmentParserDto departmentToDepartmentParserDto(Department department);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Department updateDepartmentFromDepartmentDto(DepartmentParserDto departmentDto, @MappingTarget Department department);
}
