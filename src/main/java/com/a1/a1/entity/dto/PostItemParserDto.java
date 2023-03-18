package com.a1.a1.entity.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PostItemParserDto implements Serializable {
    private final Long itemNumber;
    private final Long postMatDoc;
    private final String itemDescription;
}
