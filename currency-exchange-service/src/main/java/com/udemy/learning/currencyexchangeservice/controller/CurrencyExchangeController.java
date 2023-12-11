package com.udemy.learning.currencyexchangeservice.controller;

import com.udemy.learning.currencyexchangeservice.entity.CurrencyExchange;
import com.udemy.learning.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;
    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveCurrencyExchangeValue(@PathVariable String from, @PathVariable String to) {
        Optional<CurrencyExchange> currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
        currencyExchange.ifPresentOrElse(exchangeInfo -> {
            exchangeInfo.setEnvironment(environment.getProperty("local.server.port"));
        }, () -> {
            throw new RuntimeException("Unable to find data for given from:[" + from + "]and to:[" + to + "]");
        });
        return currencyExchange.get();
    }

}
