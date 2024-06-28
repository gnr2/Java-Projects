# Java Mini-Project 3 Basic E-commerce Cart System

## Overview
This project is a simple e-commerce cart system implemented in Java. It allows users to add and remove items to a cart, and search for products in a store. The project also includes logging and unit tests, and applies design patterns singleton and factory.

## Features 
- View a list of available products
- Search for products by name or ID
- Add products from the cart
- Remove products from the cart
- View items in the cart along with the total price

## Set up
### Build and Dependencies
```
 - Java 17
 - Maven 4.0.0
 - JUnit 4.13.2
 - Mockito 3.3.3
 - SLF4J
   - API 2.0.13
   - Core 2.23.1
   - Binding 2.23.1
 - Lombok 1.18.32
```
### Installation
1. **Clone the repository**
```
 https://github.com/gnr2/Java-Projects/mini-project-3.git
 cd mini-project-3
```

2. **Build the project**
```
mvn clean install
```

3. **Run the application**
```
mvn exec:java -Dexec.mainClass="org.David.Application"
```

## Usage

### Main Menu
- View Products
- Search Products
- Add Product to Cart
- Remove Product from Cart
- View Cart
- Exit
### Commands
- To view products, select the option to view products.
- To search for products, select the option to search and enter the keyword.
- To add a product to the cart, enter the index and quantity when prompted.
- To remove a product from the cart, enter the index of the item when prompted.
- To view the cart, select the option to view the cart.
- To exit the application, select the exit option.
## Classes
`ProductItem`

Represents a product with attributes:

- int productId
- String productName
- double productPrice
- ProductFactory
  - Provides a factory method to create ProductItem instances.

`CartService`

Interface defining the contract for cart operations.

`ProductService`

Interface defining the contract for product operations.

`CartServiceImpl`

Implementation of CartService that manages the shopping cart.

`ProductServiceImpl`

Implementation of ProductService that manages product-related operations.

## Logging
The application uses SLF4J with Logback for logging. Logs provide information on user actions and any warnings or errors encountered during the execution of the application.