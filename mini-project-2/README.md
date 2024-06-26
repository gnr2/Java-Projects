# Java Mini Project 2 - Library Management System

## Overview
This project is a simple library management system implemented in Java. It allows users to add, remove, and search for books. The project also includes logging and unit tests.

## Features
- Add new books to the library.
- Remove books from the library by ID.
- Search for books by title, author, or ISBN.
- List all books in the library.

## Setup
1. Clone the repository:
   git clone https://github.com/gnr2/Java-Projects/mini-project-2.git

2. Navigate to the project directory:
   cd mini-project-2

3. Build the project using Maven:
   ```sh
   mvn clean install
   ```
   or navigate to
   Maven toolbar in Intelli J `mini-project-2 > lifecycle > clean` and 
   `mini-project-2 > lifecycle > install` to build the project. 

## Usage
Run the application using the following command:
```sh
mvn exec:java -Dexec.mainClass="com.EllisDavid.Main"
```
or simply execute the application from the Maven toolbar on Intelli J, navigate to `mini-project-2 > Plugins > exec > exect:java`

## Testing
Run the tests using the following command:

```sh
mvn test
```
With Intelli J you can navigate through the Maven toolbar - `mini-project-2 > Lifecycle > test` to run the test command file.
