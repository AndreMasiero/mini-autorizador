package com.vr.miniautorizador;

import com.vr.miniautorizador.domain.Cards;
import com.vr.miniautorizador.dto.CardTransactionDto;
import com.vr.miniautorizador.dto.request.CardTransactionRequest;
import com.vr.miniautorizador.exception.UnprocessableEntityException;
import com.vr.miniautorizador.mapper.CardMapper;
import com.vr.miniautorizador.repository.CardRepository;
import com.vr.miniautorizador.service.CardTransactionService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class TransactionServiceTest {

    @Mock
    private CardRepository cardRepository;

    @Mock
    private CardMapper cardMapper;

    @InjectMocks
    private CardTransactionService cardTransactionService;

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateCard_Ok() {
        CardTransactionRequest cardTransactionRequest = TestMassHelper.buildCardTransactionRequest();
        CardTransactionDto cardTransactionDto = TestMassHelper.buildCardTransactionDto();
        Cards card = TestMassHelper.buildCardEntity();

        when(cardMapper.cardTransactionRequestToCardBalanceDto(any(CardTransactionRequest.class))).thenReturn(cardTransactionDto);
        when(cardRepository.findByCardNumber(any(String.class))).thenReturn(card);

        cardTransactionService.cardTransaction(cardTransactionRequest);
    }

    @Test(expectedExceptions = {UnprocessableEntityException.class})
    public void testCreateCard_CardNotFound() {
        CardTransactionRequest cardTransactionRequest = TestMassHelper.buildCardTransactionRequest();
        CardTransactionDto cardTransactionDto = TestMassHelper.buildCardTransactionDto();
        Cards card = TestMassHelper.buildCardEntity();

        when(cardMapper.cardTransactionRequestToCardBalanceDto(any(CardTransactionRequest.class))).thenReturn(cardTransactionDto);
        when(cardRepository.findByCardNumber(any(String.class))).thenReturn(null, card);

        cardTransactionService.cardTransaction(cardTransactionRequest);
    }

}
