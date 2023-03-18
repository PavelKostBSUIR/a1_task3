package com.a1.a1.mapper;

import com.a1.a1.entity.domain.Item;
import com.a1.a1.entity.dto.ItemParserDto;
import com.a1.a1.repo.BUnRepository;
import com.a1.a1.repo.CurrencyRepository;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {CurrencyRepository.class, BUnRepository.class})
public interface ItemParserMapper {

    @Mapping(source = "currencyId", target = "currency")
    @Mapping(source = "bunId", target = "bun")
    Item itemParserDtoToItem(ItemParserDto itemParserDto);

    ItemParserDto itemToItemParserDto(Item item);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Item updateItemFromItemParserDto(ItemParserDto itemParserDto, @MappingTarget Item item);
}
