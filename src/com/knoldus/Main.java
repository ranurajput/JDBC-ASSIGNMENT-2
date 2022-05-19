package com.knoldus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet;

    public void dbConnection () throws Exception {
        connection = DbConnection.getDbConnection();
    }

    public void InsertDataInShoppingTable(int pid, double price, String name) throws Exception {

        String query = "Insert into Product Values (?,?,?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,pid);
        preparedStatement.setDouble(2,price);
        preparedStatement.setString(3,name);

        int count = preparedStatement.executeUpdate();
        System.out.println(count + " rows Effected");
    }

    public void  InsertDataToCart(int pid, int qty) throws Exception {

        String query = "INSERT INTO cart VALUES (?,?)";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,pid);
        preparedStatement.setInt(2,qty);

        int count = preparedStatement.executeUpdate();
        System.out.println(count + " rows Effected");
    }

    public void printData(int pid) throws Exception {

        String query = "SELECT * FROM product WHERE product.pid=" +pid;
        preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println(resultSet.getDouble(2) + " " + resultSet.getString(3));
        }
        else {
            System.out.println("Empty");
        }
    }

    public void findAveragePrice () throws Exception {

        String query = "SELECT pid, AVG(price) AS 'Avg Price' FROM product GROUP BY pid";
        preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet2 = preparedStatement.executeQuery();

        while (resultSet2.next()) {
            System.out.println(resultSet2.getInt(1) + " " + resultSet2.getDouble(2));
        }
    }

    public static void main(String[] args) throws Exception {

	Main main = new Main();
    main.dbConnection();
    main.InsertDataInShoppingTable(14,65, "Classmate_Ranu");
    main.InsertDataToCart(4,5);
    main.printData(10);
    main.findAveragePrice();

    preparedStatement.close();
    connection.close();
    }
}
