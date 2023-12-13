package com.udemy.learning.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route(predicateSpec -> predicateSpec
                                .path("/get")
                        .filters(gatewayFilterSpec ->
                            gatewayFilterSpec.addRequestHeader("MyHeader","MyURI")
                                    .addRequestParameter("MyParam", "MyParamValue"))
                .uri("http://httpbin.org:80"))
                //To set autorouting so that we dont require service name we can use below setting
//                .route(predicateSpec -> predicateSpec
//                        .path("/currency-exchange/**").uri("lb://CURRENCY-EXCHANGE"))
                .build();
    }

}
