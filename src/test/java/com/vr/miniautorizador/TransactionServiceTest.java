package com.vr.miniautorizador;

import com.vr.miniautorizador.domain.Cards;
import com.vr.miniautorizador.dto.CardTransactionDto;
import com.vr.miniautorizador.dto.request.CardTransactionRequest;
import com.vr.miniautorizador.exception.UnprocessableEntityException;
import com.vr.miniautorizador.mapper.CardMapper;
import com.vr.miniautorizador.repository.CardRepository;
import com.vr.miniautorizador.service.CardTransactionService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

public class TransactionServiceTest {

    private static final String CARD_NUMBER = "6549873025634501";

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

        when(cardMapper.cardTransactionRequestToCardBalanceDto(cardTransactionRequest)).thenReturn(cardTransactionDto);
        when(cardRepository.findByCardNumber(CARD_NUMBER)).thenReturn(card);

        cardTransactionService.cardTransaction(cardTransactionRequest);
        verify(cardRepository, times(1)).save(card);
    }
//
//    @Test(expectedExceptions = {UnprocessableEntityException.class})
//    public void testCreateCard_CardNotFound() {
//        CardTransactionRequest cardTransactionRequest = TestMassHelper.buildCardTransactionRequest();
//        CardTransactionDto cardTransactionDto = TestMassHelper.buildCardTransactionDto();
//
//        when(cardMapper.cardTransactionRequestToCardBalanceDto(cardTransactionRequest)).thenReturn(cardTransactionDto);
//        when(cardRepository.findByCardNumber(CARD_NUMBER)).thenReturn(null);
//
//        cardTransactionService.cardTransaction(cardTransactionRequest);
//    }


}
