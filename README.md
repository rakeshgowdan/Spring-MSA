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
# RESTful Web Services
## Example : Social Media Application Resource Mappings
### User -> Posts
```
-Retrieve all Users	GET /users
-Create a User		 POST /users
- Retrieve one User		- GET Vusers/{id}I-> /users/1
- Delete a User			- DELETE /users/{id} -> /users/1
        
- Retrieve all posts for a User - GET /users/{id}/posts
-Create a posts for a User - POST /users/{id}/posts
- Retrieve details of a post - GET /users/{id}/posts/{post_id}
````

# HATEOAS, 
or Hypermedia as the Engine of Application State, is a complicated-sounding term for a simple idea:

A client interacts with a REST API entirely through the responses provided dynamically by the server.
Put even more simply:

You shouldn’t need any documentation or out-of-band information to use a REST API.

This may sound odd, because the first stop for any developer working with a new API is the documentation. How could you interact with an unfamiliar API without any out-of-band information?

You typically need to read API docs to understand:

What endpoints are available
How requests are structured
What responses to expect


One of the distinguishing features of the REST architecture is this idea that the responses themselves should tell you what you can do and how you can do it. This is HATEOAS in a nutshell, although it could also be referred to as “discoverability”.

Clients are like browsers
Think about how your browser interacts with a site like Wikipedia. It doesn’t have any special Wikipedia-specific code – it knows how to render HTML and CSS, and that’s about it (relatively speaking). Everything the browser needs to know about what it can do next is included in the document itself!


# What Is an Actuator?
In essence, Actuator brings production-ready features to our application.

Monitoring our app, gathering metrics, understanding traffic, or the state of our database become trivial with this dependency.

The main benefit of this library is that we can get production-grade tools without having to actually implement these features ourselves.

Actuator is mainly used to expose operational information about the running application — health, metrics, info, dump, env, etc. It uses HTTP endpoints or JMX beans to enable us to interact with it.


2.1. Getting Started
To enable Spring Boot Actuator, we just need to add the spring-boot-actuator dependency to our package manager.

In Maven:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
In Application.properties
```
management.endpoints.web.exposure.include=*
```

## HAL explorer
Visualising with HAL explorer
HAL and the HAL Browser
JSON Hypertext Application Language, or HAL, is a simple format that gives a consistent and easy way to hyperlink between resources in our API. Including HAL within our REST API makes it much more explorable to users as well as being essentially self-documenting.

In Maven:
```
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-rest-hal-explorer</artifactId>
    <version>3.4.1.RELEASE</version>
</dependency>
```

To access:
```
http://localhost:8080/

http://localhost:8080/explorer/index.html#
```




