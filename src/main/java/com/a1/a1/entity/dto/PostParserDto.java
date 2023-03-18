package com.a1.a1.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class PostParserDto implements Serializable {
    private final Long matDoc;
    private final Date docDate;
    private final Date postDate;
    private final Long quantity;
    private final String userName;
    private final String appAccountName;
}
