package com.napier.sem;




import org.apache.commons.lang3.StringUtils;

/**
 * This is the class representing a country
 *
 */
public class Country {
    //Attributes
    public String code;

    public String name;

    public String continent;

    public String region;

    public int population;

    public int capital;


    /**
     * Country Constructor
     * @param code Code for the country e.g. 1
     * @param name Name for the country e.g. United Kingdom
     * @param continent Continent for the country e.g. Europe
     * @param region Region of the country e.g. Western Europe
     * @param population Population of the country e.g. 186800
     * @param capital Capitals ID for the country e.g. 1
      */

    public Country(String code, String name, String continent, String region, int population, int capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }

    // Getters

    /**
     * Gets the country's code
     * @return Country code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the name of the country
     * @return Country name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the continent where the country is located
     * @return Country continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Gets the region where the country is located
     * @return Country region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Gets the population of the country
     * @return Country population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Gets the capital ID of the country
     * @return Country capital
     */
    public int getCapital() {
        return capital;
    }

    /**
     * String method to display
     * @return Correctly formats the string
     */
    @Override
    public String toString() {
        return String.format("%-10s %-40s %-30s %-25s %-10s %-30s",
                this.code,
                StringUtils.truncate(this.name, 40),
                this.continent,
                StringUtils.truncate(this.region, 25),
                this.population,
                this.capital
        );

    }
}
