# cars
The first assignment of the 3rd semester.

This repository contains my solution for the assignment on using ORM mapping with Java, JPA, Hibernate, and Spring Data JPA. Below, I've provided reflections on how my solution covered the learning goals from the corresponding lecture.

## Learning Goals Reflection

### 1. The idea with, and reasons for why to use, an ORM-mapper
Using an ORM (Object-Relational Mapping) mapper like Hibernate allows me to bridge the gap between object-oriented programming and relational databases. It simplifies the process of mapping Java objects to database tables, eliminates the need for writing complex SQL queries and provides a more intuitive way to interact with databases.

### 2. The meaning of the terms JPA, Hibernate, and Spring Data JPA and how they are connected
JPA (Java Persistence API) is a standard specification for ORM in Java applications. Hibernate is one of the most popular implementations of the JPA specification, providing a powerful and flexible ORM framework. Spring Data JPA, on the other hand, is a Spring framework module that simplifies the implementation of JPA repositories and query methods, making database interaction even more streamlined.

### 3. How to create simple Java entities and map them to a database via the Spring Data API
I created Java entity classes like `Car` and `Member`, annotating them with JPA annotations to define their relationships and mappings to database tables. The Spring Data API allowed me to extend repository interfaces to provide CRUD (create, read, update, delete) operations and custom query methods.

### 4. How to control the mapping between individual fields in an Entity class and their matching columns in the database
By using JPA annotations such as `@Column`, I was able to control the mapping of individual fields in my Entity classes to specific columns in the corresponding database tables. This allowed me to define column names, data types, and constraints.

### 5. How to auto generate IDs, and how to ensure we are using a specific database's preferred way of doing it (Auto Increment in our case for MySQL)
I used the `@GeneratedValue` annotation in combination with the `strategy = GenerationType.IDENTITY` to auto generate IDs for my entities. This strategy ensures that MySQL's auto-increment mechanism is used to generate unique IDs for each new record.

### 6. How to use and define repositories and relevant query methods using Spring Data JPA's repository pattern
I defined repositories for my entities by extending the relevant Spring Data JPA repository interfaces.
