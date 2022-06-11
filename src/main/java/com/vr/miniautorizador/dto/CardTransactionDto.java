package com.vr.miniautorizador.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CardTransactionDto {

    private String cardNumber;
    private String cardPassword;
    private BigDecimal balance;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardPassword(String cardPassword) {
        this.cardPassword = cardPassword;
    }

    public String getCardPassword() {
        return cardPassword;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
