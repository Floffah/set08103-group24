package com.napier.sem.tests.integration;

import com.napier.sem.App;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * This class is responsible for testing the entire application, from the database connection to the data retrieval to closing the connection
 */
public class AppIntegrationTest {
    // Store the for use in tests
    static App app;

    /**
     * Initialise the app before running tests
     */
    @BeforeAll
    static void init() {
        app = new App("localhost:33060");
    }

    /**
     * Disconnect the app after running tests
     */
    @AfterAll
    static void teardown() {
        app.disconnect();
    }



    /**
     * Ensure that there are no errors when printing the city data
     */
    @Test
    void viewCities() {
        app.printCityData();
    }

    /**
     * Ensure that there are no errors when printing the country data
     *
     */
    @Test
    void viewCountries() { app.printCountryData();}

    /**
     * Ensure that there are no errors when printing the language data
     *
     *
     */
    @Test
    void viewLanguages() {
        app.printLanguageData();
    }

    @Test
    void viewCountriesByContinent() {
        app.printCountryByContinentPopulationData("Europe");
    }

    @Test
    void viewCountriesByRegion() {
        app.printCountryByRegionPopulationData("North America");
    }
    /**
     * Ensure that there are no errors when printing the capital city data
     */
    @Test
    void viewCapitalCities() {
        app.printCapitalCityInWorldData();
    }
    @Test
    void viewCapitalCitiesByContinent() {
        app.printCapitalCityByContinentData("Europe");
    }
    @Test
    void viewCapitalCitiesByRegion() {
        app.printCapitalCityByRegionData("North America");
    }
    @Test
    void viewTopNCapitalCitiesByPopulation() {
        app.printTopNCapitalCityInWorldData(5);
    }
    @Test
    void viewTopNCapitalCitiesByContinent() {
        app.printTopNCapitalCityByContinentData("Europe", 5);
    }
    @Test
    void viewTopNCapitalCitiesByRegion(){
        String region = "North America";
        /*
        System.out.println("Enter Top N Capital Cities by region: " + region);

        Scanner scn = new Scanner(System.in);
        int nProvidedByUser = scn.nextInt();;
        */
        int nProvidedByUser = 5;
        app.printTopNCapitalCityRegionData(region,nProvidedByUser);
    }

}
