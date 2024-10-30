package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * The type App.
 */
public class App {
    static Connection dbCon;
    static DataCollector dataCol;

    public App(String dbLocation) {
        loadSQLDriver();
        dbCon = getConnection(dbLocation);
        dataCol = new DataCollector();
        String location = "db:3306";
    }

    public App() {
        this("db:3306");
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        App app = new App();
        app.printCityData();
        app.disconnect();
    }


    /**
     * Attempt to load mySQL driver to app
     */
    private static void loadSQLDriver() {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
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
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(1000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                // Wait a bit
                Thread.sleep(1000);
                // Exit for loop
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
        return con;
    }

    /**
     * Disconnect the mySQL database connection
     */
    public void disconnect() {
        if (dbCon != null) {
            try {
                // Close connection
                dbCon.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }


    /**
     * Get city data.
     *
     * @return the array list of cities
     */
    public void printCityData() {
        ArrayList<City> cities = dataCol.getCityData(dbCon);
        // Print header
        System.out.printf("%-30s %-12s %-30s %-10s\n", "Name", "Country Code", "Country", "Population");
        // Loop over all cities in the list
        for (City city : cities) {
            System.out.println(city.toString());
        }
    }
}