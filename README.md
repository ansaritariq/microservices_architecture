# Microservice with spring boot, eureka, zuul and oauth

This project demonstrate microservice architecture using spring boot, srping cloud, netfilx eureka, netflix zuul, and oauth.

## microservices_architecture 
Contains four component all of them are independently deployable applications.

### service-registrar
This service maintain the registry of all the microservices that has been deployed. I have used netflix eureka in this project.

### routing-server or api gateway
The client can make request to each of the microservices directily for that client needs to know all the endpoint addresses but there are challenges with this option.
Things would have been easy for a client if we had a single entry point which routes the request to the appropriate backend service.

To make things easy netflix have zuul.
