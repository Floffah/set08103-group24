package com.napier.sem.tests.integration;

import com.napier.sem.App;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
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
        app = new App();
    }

    /**
     * Load the SQL driver
     */
    @BeforeAll
    static void loadSQLDriver() {
        App.loadSQLDriver();
    }

    /**
     * Connect to the database
     */
    @BeforeAll
    static void connect() {
        app.connect("localhost:33060");
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

    @Test
    void viewCitiesByPopulation() {app.printCityByPopulationData("GBR");}

    /**
     * Ensure that there are no errors when printing the country data
     */
    @Test
    void viewCountries() { app.printCountryData();}

    /**
     * Ensure that there are no errors when printing the language data
     */
    @Test
    void viewLanguages() {
        app.printLanguageData();
    }

    @Test
    void viewCountryByPopulation() {app.printCountryByPopulationData();}

    @Test
    void viewTopNPopulationForCountry() {app.printTopNPopulationForCountryData(5);}

    @Test
    void viewCountriesByContinent() {
        app.printCountryByContinentPopulationData("Europe");
    }

    @Test
    void viewTopNCountryByContinentPopulation() {app.printTopNCountryByContinentPopulationData("South America", 5);}

    @Test
    void viewTopNCountryByRegionPopulation() {app.printTopNCountryByRegionPopulationData("North America", 5);}

    @Test
    void viewCountriesByRegion() {app.printCountryByRegionPopulationData("North America");}

    /**
     * Ensure that there are no errors when printing the population of a continent
     */
    @Test
    void viewPopulationForContinent() {
        app.printPopulationForContinent("Europe");
    }

    /**
     * Make sure that an error is thrown when trying to view the population of an invalid continent
     */
    @Test
    void tryViewPopulationForInvalidContinent() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            app.printPopulationForContinent("Eurpe");
        });
    }

    /**
     * Ensure that there are no errors when printing the population of a region
     */
    @Test
    void viewPopulationForRegion() {
        app.printPopulationForRegion("North America");
    }

    /**
     * Make sure that an error is thrown when trying to view the population of an invalid region
     */
    @Test
    void tryViewPopulationForInvalidRegion() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            app.printPopulationForRegion("North merica");
        });
    }

    /**
     * Ensure that there are no errors when printing the population of a country
     */
    @Test
    void viewPopulationForCountry() {
        app.printPopulationForCountry("United Kingdom");
    }

    /**
     * Make sure that an error is thrown when trying to view the population of an invalid country
     */
    @Test
    void tryViewPopulationForInvalidCountry() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            app.printPopulationForCountry("United Kingom");
        });
    }

    /**
     * Ensure that there are no errors when printing the population of a district
     */
    @Test
    void viewPopulationForDistrict() {
        app.printPopulationForDistrict("São Paulo");
    }

    /**
     * Make sure that an error is thrown when trying to view the population of an invalid district
     */
    @Test
    void tryViewPopulationForInvalidDistrict() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            app.printPopulationForDistrict("So Pulo");
        });
    }

    /**
     * Ensure that there are no errors when printing the population of a city
     */
    @Test
    void viewPopulationForCity() {
        app.printPopulationForCity("London");
    }

    /**
     * Make sure that an error is thrown when trying to view the population of an invalid city
     */
    @Test
    void tryViewPopulationForInvalidCity() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            app.printPopulationForCity("Lndon");
        });
    }

    /**
     * Ensure that there are no errors when printing the population of the world
     */
    @Test
    void viewPopulationOfWorld() {
        app.printPopulationOfWorld();
    }
    
    /**
     * Ensure that there are no errors when printing the population of a language
     */
    @Test
    void viewPopulationOfLanguage() {
        app.printPopulationOfLanguageSpeakers("English");
    }

    /**
     * Make sure that an error is thrown when trying to view the population of an invalid language
     */
    @Test
    void tryViewPopulationOfInvalidLanguage() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            app.printPopulationOfLanguageSpeakers("Englsh");
        });
    }

    /**
     * Ensure that there are no errors when printing the population of popular languages
     */
    @Test
    void viewPopulationOfPopularLanguages() {
        app.printPopulationOfPopularLanguages();
    }
}
