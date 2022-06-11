package com.vr.miniautorizador.service;

import com.vr.miniautorizador.domain.Cards;
import com.vr.miniautorizador.dto.CardTransactionDto;
import com.vr.miniautorizador.dto.response.CardTransactionRequest;
import com.vr.miniautorizador.enums.ErrorCode;
import com.vr.miniautorizador.exception.UnprocessableEntityException;
import com.vr.miniautorizador.mapper.CardMapper;
import com.vr.miniautorizador.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

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

        Optional<Cards> foundCard = cardRepository.findByCardNumber(cardTransactionDto.getCardNumber());
        if (!foundCard.isPresent()) {
            throw new UnprocessableEntityException(ErrorCode.CARD_NOT_FOUND);
        }

        Optional<Cards> card = cardRepository.findByCardNumberAndCardPassword(
                cardTransactionDto.getCardNumber(), cardTransactionDto.getCardPassword()
        );
        if (!card.isPresent()) {
            throw new UnprocessableEntityException(ErrorCode.CARD_INVALID_PASSWORD);
        }

        BigDecimal currentBalance = card.get().getBalance();
        BigDecimal newBalance = currentBalance.subtract(cardTransactionDto.getBalance());

        if (newBalance.compareTo(BigDecimal.ZERO) == 0 || newBalance.compareTo(BigDecimal.ZERO) == -1) {
            throw new UnprocessableEntityException(ErrorCode.INSUFFICIENT_BALANCE);
        }

        card.get().setBalance(newBalance);

        return card.get();
    }

}
