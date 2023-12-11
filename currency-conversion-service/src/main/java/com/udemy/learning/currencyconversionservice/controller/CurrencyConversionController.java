package com.udemy.learning.currencyconversionservice.controller;

import com.udemy.learning.currencyconversionservice.bean.CurrencyConversion;
import com.udemy.learning.currencyconversionservice.bean.CurrencyExchange;
import com.udemy.learning.currencyconversionservice.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        CurrencyExchange currencyExchange = new RestTemplate().getForObject("http://localhost:8000/currency-exchange/from/EUR/to/INR", CurrencyExchange.class, Map.of());

        CurrencyConversion currencyConversion = new CurrencyConversion(currencyExchange.getId(), from, to, quantity,
                currencyExchange.getConversionMultiple(), quantity.multiply(currencyExchange.getConversionMultiple()));

        currencyConversion.setEnvironment(currencyExchange.getEnvironment()+" via RestTemplate");

        return currencyConversion;
    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        CurrencyExchange currencyExchange = currencyExchangeProxy.retrieveCurrencyExchangeValue(from, to);
        CurrencyConversion currencyConversion = new CurrencyConversion(currencyExchange.getId(), from, to, quantity,
                currencyExchange.getConversionMultiple(), quantity.multiply(currencyExchange.getConversionMultiple()));
        currencyConversion.setEnvironment(currencyExchange.getEnvironment()+" via Feign");
        return currencyConversion;
    }

}
