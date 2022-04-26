# Spring-MSA
Spring Microservice implementation 

## Major URLS 

```
Eureka
http://localhost:8761/


API gateway to Currency exchange service
http://localhost:8765/api/v1/currency-exchange-service/from/EUR/to/INR

API gateway to Currency conversion Service
http://localhost:8765/api/v1/currency-conversion-service/from/EUR/to/INR/quantity/21

API gateway to Currency conversion Service (feign)
http://localhost:8765/api/v1/currency-conversion-service/feign/from/EUR/to/INR/quantity/21

Zipkin
http://localhost:9411/


Direct Currency exchange service
http://localhost:8000/api/v1/currency-exchange-service/from/EUR/to/INR

Direct currency conversion service
http://localhost:8100/api/v1/currency-conversion-service/from/EUR/to/INR/quantity/21

with feign 
http://localhost:8100/api/v1/currency-conversion-service/feign/from/EUR/to/INR/quantity/21
```
