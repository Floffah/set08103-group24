package com.napier.sem.tests.unit;

import com.napier.sem.CapitalCity;
import com.napier.sem.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * This class is for testing the Country class
 */
public class CountryTest {
    //Store the country for use in unit tests
    static Country country;
    @BeforeAll
            static void init() {
        country = new Country("1", "Kabul", "AFG", "Kabol", 1780000, 129);
    }

    /**
     * Checks to make sure that the {@link Country#toString()} is not null
     */
    @Test
    void testGetCountryData() {
            Assertions.assertEquals(
                    "1          Kabul                                    AFG                            Kabol                     1780000    129                           "
                    ,country.toString());
    }

    /**
     * Checks that the {@link Country#getCode()} returns the correct values
     */
    @Test
    void testGetCountryCode() {
        Assertions.assertEquals("1", country.getCode());
    }
    @Test
    void testGetCountryName() {
        Assertions.assertEquals("Kabul", country.getName());
    }

    /**
     * Checks that the {@link Country#getContinent()} returns the correct values
     */
    @Test
    void testGetCountryContinent() {
        Assertions.assertEquals("AFG", country.getContinent());
    }
    /**
     * Checks that the {@link Country#getRegion()} returns the correct values
     */
    @Test
    void testGetCountryRegion() {
        Assertions.assertEquals("Kabol", country.getRegion());
    }

    /**
     * Checks that the {@link Country#getPopulation()} returns the correct values
     */
    @Test
    void testGetCountryPopulation() {
        Assertions.assertEquals(1780000, country.getPopulation());
    }

    /**
     * Checks that the {@link Country#getCapital()} returns the correct values
     */
    @Test
    void testGetCountryCapital() {
        Assertions.assertEquals(129, country.getCapital());
    }
}
