package com.a1.a1.mapper;

import com.a1.a1.entity.domain.Currency;
import com.a1.a1.entity.dto.CurrencyParserDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CurrencyParserMapper {
    Currency currencyParserDtoToCurrency(CurrencyParserDto currencyParserDto);

    CurrencyParserDto currencyToCurrencyParserDto(Currency currency);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Currency updateCurrencyFromCurrencyParserDto(CurrencyParserDto currencyParserDto, @MappingTarget Currency currency);
}
