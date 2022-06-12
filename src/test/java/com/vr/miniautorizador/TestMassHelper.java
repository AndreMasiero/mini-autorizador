package com.vr.miniautorizador;

import com.vr.miniautorizador.domain.Cards;
import com.vr.miniautorizador.dto.CardDto;
import com.vr.miniautorizador.dto.CardTransactionDto;
import com.vr.miniautorizador.dto.request.CardRequest;
import com.vr.miniautorizador.dto.request.CardTransactionRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestMassHelper {

    public static CardRequest buildCardRequest() {
        CardRequest cardRequest = new CardRequest();
        cardRequest.setNumeroCartao("6549873025634501");
        cardRequest.setSenha("1234");

        return cardRequest;
    }

    public static CardTransactionRequest buildCardTransactionRequest() {
        CardTransactionRequest cardTransactionRequest = new CardTransactionRequest();
        cardTransactionRequest.setNumeroCartao("6549873025634501");
        cardTransactionRequest.setSenha("1234");
        cardTransactionRequest.setValor(BigDecimal.valueOf(250));

        return cardTransactionRequest;
    }

    public static CardTransactionDto buildCardTransactionDto() {
        CardTransactionDto cardTransactionDto= new CardTransactionDto();
        cardTransactionDto.setCardNumber("6549873025634501");
        cardTransactionDto.setCardPassword("1234");
        cardTransactionDto.setBalance(BigDecimal.valueOf(250));

        return cardTransactionDto;
    }

    public static CardDto buildCardDto() {

        CardDto cardDto = new CardDto();
        cardDto.setCardNumber("6549873025634501");
        cardDto.setCardPassword("1234");
        cardDto.setBalance(BigDecimal.valueOf(500));
        cardDto.setInsertDate(LocalDateTime.now());

        return cardDto;
    }

    public static Cards buildCardEntity() {

        Cards card = new Cards();

        card.setId("748b362e-587f-418e-9487-7d3e74f5602e");
        card.setCardNumber("6549873025634501");
        card.setCardPassword("1234");
        card.setBalance(BigDecimal.valueOf(500));
        card.setInsertDate(LocalDateTime.now());

        return card;
    }

}
