# car-garage-assesstment
 car garage

# Getting Started
you should first docker-compose-up -d command
and check the configuration in application properties

The swagger can be used directly for tests.

http://localhost:8082/swagger-ui.html#/vehicle-controller`

The any car cane be added firstly,

curl -X POST "http://localhost:8082/api/vehicles/add" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"id\": 0, \"vehicleColor\": \"black\", \"vehicleLicense\": \"121212\", \"vehicleType\": \"CAR\", \"vehicleYear\": 1212}"
The tests can be run anytime.

`mvn clean install`

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.1/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.5.1/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

