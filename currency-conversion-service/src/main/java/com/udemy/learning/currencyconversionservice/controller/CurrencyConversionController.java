package com.udemy.learning.currencyconversionservice.controller;

import com.udemy.learning.currencyconversionservice.bean.CurrencyConversion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        return new CurrencyConversion(10001l, from, to, quantity, BigDecimal.valueOf(65), BigDecimal.valueOf(650l));
    }

}
