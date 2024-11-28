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
        app.printCountryData();
        app.printCountryByPopulationData();
        String continent = "Asia";  // For example, hardcoded as "Asia"
        String region = "Caribbean";  // For example, hardcoded as "Caribbean"
        app.printCountryByContinentPopulationData(continent);
        app.printCountryByRegionPopulationData(region);
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
        System.out.printf("%-30s %-20s %-30s %-10s\n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (City city : cities) {
            System.out.println(city.toString());
        }
    }

    /**
     * Get language data.
     *
     * @return the array list of languages
     */
    public void printLanguageData() {
        ArrayList<Language> languages = dataCol.getLanguageData(dbCon);
        // Print header
        System.out.printf("%-30s %-16s %-8s %3s\n", "Languages", "Country Code", "Official", "Percentage");
        // Loop over all cities in the list
        for (Language lan : languages) {
            System.out.println(lan.toString());
        }
    }

    /**
     * Get country data.
     *
     * @return the array list of countries
     */
    public void printCountryData() {
        ArrayList<Country> countries = dataCol.getCountryData(dbCon);
        // Print header
        System.out.printf("%-10s %-40s %-30s %-25s %-10s %-30s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (Country country : countries) {
            System.out.println(country.toString());
        }
    }

    /**
     * Get country by population data.
     *
     * @return the array list of countries
     */
    public void printCountryByPopulationData() {
        ArrayList<Country> countries = dataCol.getCountriesByPopulation(dbCon);
        // Print header
        System.out.printf("%-10s %-40s %-30s %-25s %-10s %-30s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (Country country : countries) {
            System.out.println(country.toString());
        }
    }

    /**
     * Get country data.
     *
     * @return the array list of countries
     */
    public void printCountryByContinentPopulationData(String continent) {
        ArrayList<Country> countries = dataCol.getCountriesByContinentPopulation(dbCon, continent);
        // Print header
        System.out.printf("%-10s %-40s %-30s %-25s %-10s %-30s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (Country country : countries) {
            System.out.println(country.toString());
        }
    }

    /**
     * Get country region by population data.
     *
     * @return the array list of countries
     */
    public void printCountryByRegionPopulationData(String region) {
        ArrayList<Country> countries = dataCol.getCountriesByRegionPopulation(dbCon, region);
        // Print header
        System.out.printf("%-10s %-40s %-30s %-25s %-10s %-30s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (Country country : countries) {
            System.out.println(country.toString());
        }
    }

    public void printCapitalCityData() {
        ArrayList<CapitalCity> capitalCities = dataCol.getCapitalCityData(dbCon);
        // Print header
        System.out.printf("%-30s %-20s %-30s %-10s\n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (CapitalCity capitalcity : capitalCities) {
            System.out.println(capitalcity.toString());
        }
    }
}