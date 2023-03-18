package com.a1.a1.entity.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetUserDto implements Serializable {
    private final Long id;
    private final String appAccountName;
    private final Boolean isActive;
    private final String jobTitle;
    private final GetApplicationDto application;
    private final GetDepartmentDto department;
}
