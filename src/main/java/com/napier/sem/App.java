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

    public App(){
        dbCon = getConnection();
        dataCol = new DataCollector();
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args)
    {
        loadSQLDriver();

        dbCon = getConnection();
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
    public ArrayList<City> getCityData() {
        return dataCol.getCityData(dbCon);
    }


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
    private static Connection getConnection() {
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
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
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