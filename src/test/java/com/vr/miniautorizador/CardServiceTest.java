package com.vr.miniautorizador;

import com.vr.miniautorizador.domain.Cards;
import com.vr.miniautorizador.dto.CardDto;
import com.vr.miniautorizador.dto.request.CardRequest;
import com.vr.miniautorizador.exception.NotFoundException;
import com.vr.miniautorizador.mapper.CardMapper;
import com.vr.miniautorizador.repository.CardRepository;
import com.vr.miniautorizador.service.CardService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CardServiceTest {

    private static final String CARD_NUMBER = "6549873025634501";

    @Mock
    private CardRepository cardRepository;

    @Mock
    private CardMapper cardMapper;

    @InjectMocks
    private CardService cardService;

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateCard() {
        CardRequest cardRequest = TestMassHelper.buildCardRequest();
        CardDto cardDto = TestMassHelper.buildCardDto();
        Cards card = TestMassHelper.buildCardEntity();

        when(cardMapper.cardRequestToCardDto(cardRequest)).thenReturn(cardDto);
        when(cardMapper.cardDtoToEntity(cardDto)).thenReturn(card);
        when(cardRepository.save(card)).thenReturn(card);

        String idCreated = cardService.save(cardRequest);
        assertEquals(idCreated, card.getId());
    }

    @Test(expectedExceptions = {NotFoundException.class})
    public void testGetBalanceCard_NotFound() {
        when(cardRepository.findByCardNumber(CARD_NUMBER)).thenReturn(null);

        cardService.getCardBalance(CARD_NUMBER);
    }

}
