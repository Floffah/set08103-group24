package com.napier.sem.tests.integration;

import com.napier.sem.App;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AppIntegrationTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App("localhost:33060");
    }

    @AfterAll
    static void teardown() {
        app.disconnect();
    }

    @Test
    void viewCapitalCities() {
        app.printCapitalCityData();
    }

    @Test
    void viewCities() {
        app.printCityData();
    }

    @Test
    void viewCountries() {
        app.printCountryData();
    }

    @Test
    void viewLanguages() {
        app.printLanguageData();
    }
}
