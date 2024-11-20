package com.napier.sem.tests.unit;

import com.napier.sem.Language;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * This class is for testing the Language class
 */
public class LanguageTest {
    //Store the language for use in unit tests
    static Language language;
    @BeforeAll
            static void init() {
        language = new Language("TestName", "TES", Boolean.TRUE, 0.7f);
    }

    /**
     * Checks to make sure that the {@link Language#toString()} is not null
     */
    @Test
    void testGetLanguageData() {
            System.out.println(language.toString());
            Assertions.assertEquals(
                    "TestName                       TES              true     0.7%"
                    ,language.toString());
    }

    /**
     * Checks that the {@link Language#getName()} returns the correct values
     */
    @Test
    void testGetLanguageName() {
        Assertions.assertEquals("TestName", language.getName());
    }

    /**
     * Checks that the {@link Language#getCountryCode()} returns the correct values
     */
    @Test
    void testGetLanguageCountryCode() {
        Assertions.assertEquals("TES", language.getCountryCode());
    }

    /**
     * Checks that the {@link Language#getIsOfficial()} ()} returns the correct values
     */
    @Test
    void testGetLanguageIsOfficial() {
        Assertions.assertEquals(Boolean.TRUE, language.getIsOfficial());
    }

    /**
     * Checks that the {@link Language#getPercentage()} returns the correct values
     */
    @Test
    void testGetLanguagePercentage() {
        Assertions.assertEquals(0.7f, language.getPercentage());
    }

}
