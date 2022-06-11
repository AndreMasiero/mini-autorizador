package com.vr.miniautorizador.mapper;

import com.vr.miniautorizador.domain.Cards;
import com.vr.miniautorizador.dto.CardDto;
import com.vr.miniautorizador.dto.response.CardRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CardMapper {

    @Mapping(target = "cardNumber", source = "numeroCartao")
    @Mapping(target = "cardPassword", source = "senha")
    CardDto cardRequestToCardDto(CardRequest cardRequest);

    @Mapping(target = "cardNumber", source = "cardNumber")
    @Mapping(target = "cardPassword", source = "cardPassword")
    @Mapping(target = "insertDate", source = "insertDate")
    Cards cardDtoToEntity(CardDto cardDto);

}
