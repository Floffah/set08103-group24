package com.napier.sem.tests.unit;

import com.napier.sem.CapitalCity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * This class is responsible for testing the CapitalCity class
 */
public class CapitalCityTest {
    // Store the capital city for use in tests
    static CapitalCity capitalCity;

    @BeforeAll
    static void init() {
        capitalCity = new CapitalCity("TestCity", "GB", "TestDistrict", 1000000, "United Kingdom");
    }

    /**
     * Ensure that the {@link CapitalCity#toString()} class is not null
     */
    @Test
    void testGetCapitalCityData() {
        Assertions.assertEquals(
                "TestCity                       United Kingdom       TestDistrict                   1000000   ",
                capitalCity.toString()
        );
    }

    /**
     * Ensure that the {@link CapitalCity#getName()} returns the correct values
     */
    @Test
    void testGetCapitalCityName() {
        Assertions.assertEquals("TestCity", capitalCity.getName());
    }

    /**
     * Ensure that the {@link CapitalCity#getCountryCode()} returns the correct values
     */
    @Test
    void testGetCapitalCityCountryCode() {
        Assertions.assertEquals("GB", capitalCity.getCountryCode());
    }

    /**
     * Ensure that the {@link CapitalCity#getDistrict()} returns the correct values
     */
    @Test
    void testGetCapitalCityDistrict() {
        Assertions.assertEquals("TestDistrict", capitalCity.getDistrict());
    }

    /**
     * Ensure that the {@link CapitalCity#getPopulation()} returns the correct values
     */
    @Test
    void testGetCapitalCityPopulation() {
        Assertions.assertEquals(1000000, capitalCity.getPopulation());
    }
}
