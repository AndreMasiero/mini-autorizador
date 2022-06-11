package com.vr.miniautorizador.enums;

public enum ErrorCode {

    CARD_ALREADY_EXISTS("O CARTÃO JÁ EXISTE"),
    CARD_NOT_FOUND("CARTÃO NÃO ENCONTRADO"),
    CARD_INVALID_PASSWORD("SENHA INVÁLIDA"),
    INSUFFICIENT_BALANCE("SALDO INSUFICINTE");

    private String description;

    ErrorCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
