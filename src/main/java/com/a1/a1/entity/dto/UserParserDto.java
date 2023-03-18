package com.a1.a1.entity.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserParserDto implements Serializable {
    private final String appAccountName;
    private final Boolean isActive;
    private final String jobTitle;
    private final String applicationId;
    private final String departmentId;
}
