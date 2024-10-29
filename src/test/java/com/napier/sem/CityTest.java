package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CityTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App("localhost:33060");
    }

    @Test
    void viewCities()
    {
        app.getCityData();
    }
}