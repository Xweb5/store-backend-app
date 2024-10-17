# Bookshop backend

The bookshop backend is the backend side that allow to manage book chart and read a list of book.

The project is based in java as base technological stack. Other technologies associated are:
- spring boot v3.3.4
- H2 database as in memory DB 


## Table of contents (optional)

- Requirements
- Execution
- DB access 
- Missing development part


## Requirements

This module requires the following modules:

- java 17
- Apache Maven 3.6.3


## Execution

- please run : **mvn spring-boot:run**
- access to http://localhost:8080/bookshop/v1

## DB Acess

in order to access to the database console :

- db Url: http://localhost:8080/bookshop/v1/h2-console
- usr : sa
- password: password


## Missing development part

due to the luck of time, the following implementation are missed 
- appropriate unit tests, integration tests and appropriate code coverage
- correct implementation of the http codes