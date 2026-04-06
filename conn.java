package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    // Connection object for database
    Connection connection;

    // Statement object to execute SQL queries
    Statement statement;

    // Constructor
    public conn(){

        try {

            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employeemanagement",
                    "root",
                    "gaurav4898");

            // Create statement
            statement = connection.createStatement();

        } catch (Exception e){

            // Print error if connection fails
            e.printStackTrace();

        }
    }
}