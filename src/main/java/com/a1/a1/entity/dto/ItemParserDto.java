package com.a1.a1.entity.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ItemParserDto implements Serializable {
    private final String description;
    private final Double amountLC;
    private final String currencyId;
    private final String bunId;
}
