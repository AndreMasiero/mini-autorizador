package com.vr.miniautorizador.service;

import com.vr.miniautorizador.domain.Cards;
import com.vr.miniautorizador.dto.CardDto;
import com.vr.miniautorizador.dto.response.CardRequest;
import com.vr.miniautorizador.mapper.CardMapper;
import com.vr.miniautorizador.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    private CardMapper cardMapper;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public String save(CardRequest cardRequest) {

        CardDto cardDto = cardMapper.cardRequestToCardDto(cardRequest);

        cardDto.setInsertDate(LocalDateTime.now());
        Cards cards = cardMapper.cardDtoToEntity(cardDto);

        return cardRepository.save(cards).getId();
    }
}
