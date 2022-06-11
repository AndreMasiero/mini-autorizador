package com.vr.miniautorizador.service;

import com.vr.miniautorizador.domain.Cards;
import com.vr.miniautorizador.dto.CardDto;
import com.vr.miniautorizador.dto.response.CardRequest;
import com.vr.miniautorizador.enums.ErrorCode;
import com.vr.miniautorizador.exception.UnprocessableEntityException;
import com.vr.miniautorizador.exception.NotFoundException;
import com.vr.miniautorizador.mapper.CardMapper;
import com.vr.miniautorizador.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

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

        Optional<Cards> card = cardRepository.findByCardNumber(cardDto.getCardNumber());

        if (card.isPresent()) {
            throw new UnprocessableEntityException(ErrorCode.CARD_ALREADY_EXISTS);
        }

        cardDto.setInsertDate(LocalDateTime.now());
        cardDto.setBalance(BigDecimal.valueOf(500));
        Cards cards = cardMapper.cardDtoToEntity(cardDto);

        return cardRepository.save(cards).getId();
    }

    public BigDecimal getcardBalance(String cardNumber){

        Optional<Cards> card = cardRepository.findByCardNumber(cardNumber);

        if (!card.isPresent()) {
            throw new NotFoundException(ErrorCode.CARD_NOT_FOUND);
        }

        return card.get().getBalance();
    }

}
