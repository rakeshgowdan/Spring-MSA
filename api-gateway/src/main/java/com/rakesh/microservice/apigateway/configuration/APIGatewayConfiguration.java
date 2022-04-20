package com.rakesh.microservice.apigateway.configuration;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		Function<PredicateSpec, Buildable<Route>> routeFunction = p -> p.path("/get")
				.filters(f->f.addRequestHeader("dummyHeader", "dummyHeader")
							 .addRequestParameter("dummyParam", "dummyParam"))
				.uri("http://httpbin.org:80");
		return builder.routes().route(routeFunction).build();
	}
	@Bean
	public RouteLocator gatewayRouterForCurrencyExchange(RouteLocatorBuilder builder) {
		Function<PredicateSpec, Buildable<Route>> routeFunction =
				p -> p.path("/api/v1/currency-exchange-service/**")  //accessing path
				.uri("lb://currency-exchange-service"); //name in eureka 
		return builder.routes().route(routeFunction).build();
	}
	
	@Bean
	public RouteLocator gatewayRouterForCurrencyConversion(RouteLocatorBuilder builder) {
		Function<PredicateSpec, Buildable<Route>> routeFunction =
				p -> p.path("/api/v1/currency-conversion/**")  //accessing path
				.uri("lb://currency-conversion-service"); //name in eureka 
		return builder.routes().route(routeFunction).build();
	}

}
