package com.vr.miniautorizador.dto.request;

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

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
