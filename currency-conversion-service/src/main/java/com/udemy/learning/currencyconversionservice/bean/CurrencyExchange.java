package com.udemy.learning.currencyconversionservice.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class CurrencyExchange {

    private final Long id;
    private final String from;
    private final String to;
    private final BigDecimal conversionMultiple;
    private String environment;
}
