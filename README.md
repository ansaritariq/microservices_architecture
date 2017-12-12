# Microservice with spring boot, eureka, zuul and oauth

This project demonstrate microservice architecture using spring boot, srping cloud, netfilx eureka, netflix zuul, and oauth.

## microservices_architecture 
Contains four component all of them are independently deployable applications.

### service-registrar
This service maintain the registry of all the microservices that has been deployed. I have used netflix eureka in this project. To register service to `service-registrar` we need to specify property like below.

```
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
```

### routing-server or api gateway
The client can make request to each of the microservices directily, to do that client needs to know all the endpoint addresses but there are challenges with this option.
Things would have been easy for a client if we had a single entry point which routes the request to the appropriate backend service.
To provide single entry point I have used netflix zuul, we need to configure zuul to route the request by specifying routes using properties under `zuul.routes.NAME` where NAME is the application name as per `spring.application.name` property. Below is the routing  configuration for order-service.

```
zuul.routes.order-service.path=/order-api/**
```
### authentication-service
To access any resource authentication is required. Instead of using the resource owner's credentials to access protected 
resources, the client obtains an access token.

#### Generate access token
To generate access token basic authorization header with `client id` and `secret` encoded in `Base64` should be passed as authorization header.

Name	| Value	|
------------- | ------------------------- 
Client Id	| trusted-app
Secret	| password

_request_
```
POST /auth-api/oauth/token HTTP/1.1
Accept: application/json;charset=UTF-8
Authorization: Basic dHJ1c3RlZC1hcHA6cGFzc3dvcmQ=
Host: localhost:8765
Content-Type: application/x-www-form-urlencoded

grant_type=password&username=demo&password=password
```
_response_
```
{
    "access_token": "02db66a1-6bd0-4240-bed4-556ec3fdfc6c",
    "token_type": "bearer",
    "refresh_token": "06b8a0c8-5ef5-4b77-87ef-c7256bab7c17",
    "expires_in": 44512,
    "scope": "read write trust",
    "name": "Demo"
}
````

- Resources can be access using access token either by passing access_token in url __<resource_url>?access_token=<access_token>__ or by passing as authrization header __Authorization: Bearer <access_token>__. This document will use Authorization header to access resources.

#### order-service
To access api of `order-service` the user needs to be authenticated via `authentication-service`.

_request_
```
GET /orders HTTP/1.1
Accept: application/json;charset=UTF-8
Authorization: Bearer 02db66a1-6bd0-4240-bed4-556ec3fdfc6c
Host: localhost:8765
Content-Type: application/json
```
