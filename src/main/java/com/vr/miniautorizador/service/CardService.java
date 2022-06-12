package com.vr.miniautorizador.service;

import com.vr.miniautorizador.domain.Cards;
import com.vr.miniautorizador.dto.CardDto;
import com.vr.miniautorizador.dto.request.CardRequest;
import com.vr.miniautorizador.enums.ErrorCode;
import com.vr.miniautorizador.exception.NotFoundException;
import com.vr.miniautorizador.exception.UnprocessableEntityException;
import com.vr.miniautorizador.mapper.CardMapper;
import com.vr.miniautorizador.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public CardService(CardRepository cardRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    public String save(CardRequest cardRequest) {

        CardDto cardDto = cardMapper.cardRequestToCardDto(cardRequest);

        Cards card = getCardsByNumber(cardDto.getCardNumber());

        if (nonNull(card)) {
            throw new UnprocessableEntityException(ErrorCode.CARD_ALREADY_EXISTS);
        }

        cardDto.setInsertDate(LocalDateTime.now());
        cardDto.setBalance(BigDecimal.valueOf(500));
        Cards cards = cardMapper.cardDtoToEntity(cardDto);

        return cardRepository.save(cards).getId();
    }

    public BigDecimal getCardBalance(String cardNumber) {

        Cards card = getCardsByNumber(cardNumber);

        if (isNull(card)) {
            throw new NotFoundException(ErrorCode.CARD_NOT_FOUND);
        }

        return card.getBalance();
    }

    private Cards getCardsByNumber(String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber);
    }

}
