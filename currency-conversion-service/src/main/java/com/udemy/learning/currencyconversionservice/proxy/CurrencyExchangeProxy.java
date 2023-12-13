package com.udemy.learning.currencyconversionservice.proxy;

import com.udemy.learning.currencyconversionservice.bean.CurrencyExchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Old Way
//@FeignClient(name = "currency-exchange", url = "localhost:8000")
//Eureka way directly give service name
@FeignClient(name = "CURRENCY-EXCHANGE")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveCurrencyExchangeValue(@PathVariable String from, @PathVariable String to);

}
