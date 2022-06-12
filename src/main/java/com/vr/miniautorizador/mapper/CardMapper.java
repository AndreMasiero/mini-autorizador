package com.vr.miniautorizador.mapper;

import com.vr.miniautorizador.domain.Cards;
import com.vr.miniautorizador.dto.CardDto;
import com.vr.miniautorizador.dto.CardTransactionDto;
import com.vr.miniautorizador.dto.request.CardRequest;
import com.vr.miniautorizador.dto.request.CardTransactionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CardMapper {

    @Mapping(target = "cardNumber", source = "numeroCartao")
    @Mapping(target = "cardPassword", source = "senha")
    CardDto cardRequestToCardDto(CardRequest cardRequest);

    @Mapping(target = "cardNumber", source = "numeroCartao")
    @Mapping(target = "cardPassword", source = "senha")
    @Mapping(target = "balance", source = "valor")
    CardTransactionDto cardTransactionRequestToCardBalanceDto(CardTransactionRequest cardTransactionRequest);

    @Mapping(target = "cardNumber", source = "cardNumber")
    @Mapping(target = "cardPassword", source = "cardPassword")
    @Mapping(target = "insertDate", source = "insertDate")
    @Mapping(target = "balance", source = "balance")
    Cards cardDtoToEntity(CardDto cardDto);
}
