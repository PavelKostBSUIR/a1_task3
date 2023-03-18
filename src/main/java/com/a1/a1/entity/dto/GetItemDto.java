package com.a1.a1.entity.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetItemDto implements Serializable {
    private final Long id;
    private final String description;
    private final GetBunDto bun;
    private final Long amountLC;
    private final GetCurrencyDto currency;
}
