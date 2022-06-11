package com.vr.miniautorizador.enums;

public enum ErrorCode {

    CARD_ALREADY_EXISTS("CARD_ALREADY_EXISTS", "O CARTÃO JÁ EXISTE");

    private String description;
    private String code;

    ErrorCode(String description, String code) {
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }
}
