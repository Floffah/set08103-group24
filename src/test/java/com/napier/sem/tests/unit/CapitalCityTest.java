package com.napier.sem.tests.unit;

import com.napier.sem.CapitalCity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CapitalCityTest {
    CapitalCity capitalCity = new CapitalCity("TestCity", "GB", "TestDistrict", 1000000, "United Kingdom");

    @Test
    void testGetCapitalCityData() {
        Assertions.assertEquals(
                "TestCity                       United Kingdom       TestDistrict                   1000000   ",
                capitalCity.toString()
        );
    }

    @Test
    void testGetCapitalCityName() {
        Assertions.assertEquals("TestCity", capitalCity.getName());
    }

    @Test
    void testGetCapitalCityCountryCode() {
        Assertions.assertEquals("GB", capitalCity.getCountryCode());
    }

    @Test
    void testGetCapitalCityDistrict() {
        Assertions.assertEquals("TestDistrict", capitalCity.getDistrict());
    }

    @Test
    void testGetCapitalCityPopulation() {
        Assertions.assertEquals(1000000, capitalCity.getPopulation());
    }
}
