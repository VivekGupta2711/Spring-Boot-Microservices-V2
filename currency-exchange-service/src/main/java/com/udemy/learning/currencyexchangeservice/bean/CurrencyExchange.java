package com.udemy.learning.currencyexchangeservice.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyExchange {
    private final Long id;
    private final String from;
    private final String to;
    private final BigDecimal conversionMultiple;
    private String environment;
}
