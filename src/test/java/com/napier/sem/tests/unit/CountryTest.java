package com.napier.sem.tests.unit;

import com.napier.sem.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CountryTest {
    //Store the country for use in unit tests
    static Country country;
    @BeforeAll
            static void init() {
        country = new Country("1", "Kabul", "AFG", "Kabol", 1780000, 129);
    }
        @Test
    void testGetCountryData() {
            Assertions.assertEquals(
                    "1          Kabul                                    AFG                            Kabol                     1780000    129                           "
                    ,country.toString());
    }
    @Test
    void testGetCountryCode() {
        Assertions.assertEquals("1", country.getCode());
    }
    @Test
    void testGetCountryName() {
        Assertions.assertEquals("Kabul", country.getName());
    }
    @Test
    void testGetCountryContinent() {
        Assertions.assertEquals("AFG", country.getContinent());
    }
    @Test
    void testGetCountryRegion() {
        Assertions.assertEquals("Kabol", country.getRegion());
    }
    @Test
    void testGetCountryPopulation() {
        Assertions.assertEquals(1780000, country.getPopulation());
    }
    @Test
    void testGetCountryCapital() {
        Assertions.assertEquals(129, country.getCapital());
    }
}
