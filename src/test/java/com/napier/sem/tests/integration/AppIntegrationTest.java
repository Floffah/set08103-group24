package com.napier.sem.tests.integration;

import com.napier.sem.App;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
     * Ensure that there are no errors when printing the capital city data
     */
    @Test
    void viewCapitalCities() {
        app.printCapitalCityData();
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
     */
    @Test
    void viewCountries() {
        app.printCountryData();
    }

    /**
     * Ensure that there are no errors when printing the language data
     */
    @Test
    void viewLanguages() {
        app.printLanguageData();
    }
@Test
    void viewCountriesByContinent() {
        app.printCountriesByPopulationData("Europe");
    }
}
