package com.vr.miniautorizador.repository;

import com.vr.miniautorizador.domain.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Cards, String> {
    Cards findByCardNumber(String cardNumber);
}
