# Java Persistence API (JPA)

## Objetivo
- Material para estudo
  
## Tecnologias 
- Java
- JPA / Hibernate
- Banco MySQL, PostgreSQL
- DAO (Data Access Object)

## Estrutura do Projeto
```txt
.
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── org
│       │       └── example
│       │           ├── entities
│       │           │   ├── basic
│       │           │   │   ├── Product.java
│       │           │   │   └── User.java
│       │           │   ├── manyToMany
│       │           │   │   ├── Actor.java
│       │           │   │   ├── Movie.java
│       │           │   │   ├── Nephew.java
│       │           │   │   └── Uncle.java
│       │           │   ├── oneToMany
│       │           │   │   ├── OrderItem.java
│       │           │   │   └── Order.java
│       │           │   └── oneToOne
│       │           │       ├── Client.java
│       │           │       └── Seat.java
│       │           ├── infra
│       │           │   └── DAO.java
│       │           └── queries
│       │               ├── manyToMany
│       │               │   ├── CreateMovieActor.java
│       │               │   └── CreateUncleNephew.java
│       │               ├── oneToMany
│       │               │   ├── GetOrder.java
│       │               │   └── NewOrder.java
│       │               ├── oneToOne
│       │               │   ├── CreateSeatClient2.java
│       │               │   └── CreateSeatClient.java
│       │               ├── product
│       │               │   ├── CreateProduct.java
│       │               │   └── GetProducts.java
│       │               └── user
│       │                   ├── CreateUser.java
│       │                   ├── DeleteUser.java
│       │                   ├── GetUser.java
│       │                   ├── GetUsers.java
│       │                   └── UpdateUser.java
│       └── resources
│           └── META-INF
│               └── persistence.xml
└── structure.txt

20 directories, 27 files
```
