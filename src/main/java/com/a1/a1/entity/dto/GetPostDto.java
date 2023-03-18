package com.a1.a1.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
public class GetPostDto implements Serializable {
    private final Long matDoc;
    private final Boolean authorized;
    private final Date docDate;
    private final Date postDate;
    private final List<GetPostItemDto> items;
    private final Long quantity;
    private final GetUserDto user;
    private final String userName;
}
