package com.napier.sem.tests.unit;

import com.napier.sem.City;
import com.napier.sem.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * This class is for testing the City class
 */
public class CityTest {
    //Store the city for use in unit tests
    static City city;
    @BeforeAll
            static void init() {
        city = new City("TestCity", "TES", "TestDistrict", 10000, "TestCountry");
    }

    /**
     * Checks to make sure that the {@link City#toString()} is not null
     */
    @Test
    void testGetCityData() {
            System.out.println(city.toString());
            Assertions.assertEquals(
                    "TestCity                       TestCountry          TestDistrict                   10000     "
                    ,city.toString());
    }

    /**
     * Checks that the {@link City#getName()} returns the correct values
     */
    @Test
    void testGetCityName() {
        Assertions.assertEquals("TestCity", city.getName());
    }

    /**
     * Checks that the {@link City#getCountryCode()} returns the correct values
     */
    @Test
    void testGetCityCountryCode() {
        Assertions.assertEquals("TES", city.getCountryCode());
    }

    /**
     * Checks that the {@link City#getDistrict()} returns the correct values
     */
    @Test
    void testGetCityDistrict() {
        Assertions.assertEquals("TestDistrict", city.getDistrict());
    }

    /**
     * Checks that the {@link City#getPopulation()} returns the correct values
     */
    @Test
    void testGetCityPopulation() {
        Assertions.assertEquals(10000, city.getPopulation());
    }

    /**
     * Checks that the {@link City#getCountry()} returns the correct values
     */
    @Test
    void testGetCityCountry() {
        Assertions.assertEquals("TestCountry", city.getCountry());
    }
}
