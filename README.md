# 📚 Hibernate Book Management System (CRUD using JPA & Hibernate)

## Description
A simple Java console application built using Hibernate ORM and JPA that performs CRUD (Create, Read, Update, Delete) operations on a Book database. The system allows users to add, search, update, and delete books using a menu-driven interface. This project demonstrates how Hibernate interacts with a relational database using EntityManager, EntityTransaction, and the Persistence API.

## Features
- Add new books to the database
- Find book by ID
- Update book details
- Delete book
- Menu-driven console interface
- Hibernate ORM integration

## Technologies Used
- Java
- Hibernate ORM
- JPA (Jakarta Persistence)
- MySQL / Any relational database

## Project Structure
com.siddharth.hibernate2
- BookDAO.java (Main logic and CRUD operations)
- BookDTO.java (Entity class representing Book table)
- persistence.xml (Hibernate configuration)

## Functionalities

1. Add Book  
User enters Book ID, Book Name, Author Name, and Price. The book is then stored in the database.

2. Find Book By ID  
Search a book using its Book ID and display details if found.

3. Update Book  
Allows updating Book Name, Author Name, or Price.

4. Delete Book  
Delete a book from the database using its Book ID.

## Sample Console Menu

====== Book Management ======

1. Add Book  
2. Find Book By ID  
3. Update Book  
4. Delete Book  
5. Exit  

## Example Output

Enter BookID  
101  

Enter Book Name  
Java Programming  

Enter Book Author Name  
James Gosling  

Enter price of the Book  
499  

Book Added Successfully

## Learning Objectives
- Understanding Hibernate ORM
- Using JPA EntityManager
- Transaction management
- Performing CRUD operations with Hibernate
- Connecting Java applications with databases

## Author
Siddharth Ekatpure
