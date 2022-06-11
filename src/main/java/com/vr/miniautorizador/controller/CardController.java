package com.vr.miniautorizador.controller;

import com.vr.miniautorizador.dto.response.CardRequest;
import com.vr.miniautorizador.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cartoes")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody CardRequest cardRequest) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(cardService.save(cardRequest));
    }
}
