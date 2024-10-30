package com.napier.sem;
// This is the class representing a country

// Variables

public class Country {

    public String code;

    public String name;

    public String continent;

    public String region;

    public int population;

    public int capital;


    // Constructor
    public Country(String code, String name, String continent, String region, int population, int capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }

    // Getters

    // Returns the country's code
    public String getCode() {
        return code;
    }

    // Returns name of the country
    public String getName() {return name;}

    // Returns the continent where the country is located
    public String getContinent() {
        return continent;
    }

    // Returns the region where the country is located
    public String getRegion() {
        return region;
    }

    // Returns the population of the country
    public int getPopulation() {
        return population;
    }

    // Returns the capital city of the country
    public int getCapital() {return capital;}

    // String method to display
    @Override
    public String toString() {
        return String.format("%-10s %-20s %-30s %-20s %-10s %-30s",
                this.code, this.name, this.continent, this.region, this.population, this.capital);
    }
}
