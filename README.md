# JDBC-ASSIGNMENT-2
Assignment 2 JDBC

Write a Java application which interacts with MySQL database using JDBC. Following are the functions we want to perform.

Prerequisites: Assignment 1 should be completed. Following the product and cart schema,
1. Add a method which takes (pid: String, pname: String, price: Int) as input parameter and inserts into the product table. Add another methode for cart table.
2. Add a method which queries the product table as per given pid. It should return Optional.empty if no records are found.
3. Write a method to find the average price of all the products
