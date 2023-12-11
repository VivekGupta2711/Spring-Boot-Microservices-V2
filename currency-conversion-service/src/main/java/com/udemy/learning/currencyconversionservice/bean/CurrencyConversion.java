package com.udemy.learning.currencyconversionservice.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyConversion {
    private final Long id;
    private final String from;
    private final String to;
    private final BigDecimal quantity;
    private final BigDecimal conversionMultiple;
    private final BigDecimal totalCalculatedAmount;
    private String environment;
}
