package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * The type App.
 */
public class App
{
    static Connection dbCon;
    static DataCollector dataCol;

    public App(String dbLocation) {
        loadSQLDriver();
        dbCon = getConnection(dbLocation);
        dataCol = new DataCollector();
    }

    public App() {
        this("db:3306");
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        loadSQLDriver();

        String location = "db:3306";

        if (args.length > 0) {
            location = args[0];
        }

        dbCon = getConnection(location);
        dataCol = new DataCollector();

        // City Data View: Prints all city data as a ArrayList, clean up and make easier to read later
        // System.out.println(Arrays.toString(cityData.toArray()));

        disconnect(dbCon);
    }


    /**
     * Get city data.
     *
     * @return the array list of cities
     */
    public void printCityData() {
        ArrayList<City> cities dataCol.getCityData(dbCon);
        // Print header
        System.out.println(String.format("%-10s %-15s %-20s %-8s", "Emp No", "First Name", "Last Name", "Salary"));
        // Loop over all employees in the list
        for (Employee emp : employees)
        {
            String emp_string =
                    String.format("%-10s %-15s %-20s %-8s",
                            emp.emp_no, emp.first_name, emp.last_name, emp.salary);
            System.out.println(emp_string);
        }    }


    /**
     * Attempt to load mySQL driver to app
     */
    private static void loadSQLDriver() {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }
    }


    /**
     * Attempt connection app to mySQL Database
     *
     * @return mySQL database connection class
     */
    private static Connection getConnection(String location) {
        // Connection to the database
        Connection con = null;
        int retries = 100;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                // Wait a bit
                Thread.sleep(1000);
                // Exit for loop
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
        return con;
    }

    /**
     * Disconnect the mySQL database connection
     *
     * @param con mySQL database connection class
     */
    private static void disconnect(Connection con) {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
}