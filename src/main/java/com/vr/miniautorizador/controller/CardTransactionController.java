package com.vr.miniautorizador.controller;

import com.vr.miniautorizador.dto.request.CardTransactionRequest;
import com.vr.miniautorizador.service.CardTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transacoes")
public class CardTransactionController {

    private final CardTransactionService cardTransactionService;

    public CardTransactionController(CardTransactionService cardTransactionService) {
        this.cardTransactionService = cardTransactionService;
    }

    @PostMapping
    public ResponseEntity<Void> transaction(@RequestBody CardTransactionRequest cardTransactionRequest) {
        cardTransactionService.cardTransaction(cardTransactionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
