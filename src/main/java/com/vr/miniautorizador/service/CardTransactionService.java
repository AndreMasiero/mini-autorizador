package com.vr.miniautorizador.service;

import com.vr.miniautorizador.domain.Cards;
import com.vr.miniautorizador.dto.CardTransactionDto;
import com.vr.miniautorizador.dto.request.CardTransactionRequest;
import com.vr.miniautorizador.enums.ErrorCode;
import com.vr.miniautorizador.exception.UnprocessableEntityException;
import com.vr.miniautorizador.mapper.CardMapper;
import com.vr.miniautorizador.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static java.util.Objects.isNull;

@Service
public class CardTransactionService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public CardTransactionService(CardRepository cardRepository, CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    public void cardTransaction(CardTransactionRequest cardTransactionRequest) {

        Cards card = transactionValidate(cardTransactionRequest);

        cardRepository.save(card);
    }

    private Cards transactionValidate(CardTransactionRequest cardTransactionRequest) {

        CardTransactionDto cardTransactionDto = cardMapper.cardTransactionRequestToCardBalanceDto(cardTransactionRequest);

        Cards card = cardRepository.findByCardNumber(cardTransactionDto.getCardNumber());

        if (isNull(card)) {
            throw new UnprocessableEntityException(ErrorCode.CARD_NOT_FOUND);
        } else if (!card.getCardPassword().equals(cardTransactionDto.getCardPassword())) {
            throw new UnprocessableEntityException(ErrorCode.CARD_INVALID_PASSWORD);
        }

        BigDecimal currentBalance = card.getBalance();
        BigDecimal newBalance = currentBalance.subtract(cardTransactionDto.getBalance());

        if (newBalance.compareTo(BigDecimal.ZERO) == -1) {
            throw new UnprocessableEntityException(ErrorCode.INSUFFICIENT_BALANCE);
        }

        card.setBalance(newBalance);

        return card;
    }

}
