package com.vr.miniautorizador.dto.response;

import java.math.BigDecimal;

public class CardTransactionRequest {

    private String numeroCartao;
    private String senha;
    private BigDecimal valor;

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getSenha() {
        return senha;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
