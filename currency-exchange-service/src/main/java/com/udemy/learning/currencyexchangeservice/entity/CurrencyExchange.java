package com.udemy.learning.currencyexchangeservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class CurrencyExchange {

    @Id
    private final Long id;
    //from is an SQL identifier hence we cannot have a column name from
    //Hence need to changed this column name
    @Column(name = "currency_from")
    private final String from;
    @Column(name = "currency_to")
    private final String to;
    private final BigDecimal conversionMultiple;
    private String environment;
}
