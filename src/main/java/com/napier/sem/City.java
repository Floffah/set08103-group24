package com.napier.sem;

/**
 * Class that represents a City.
 * @author Fergus Haak
 * @version 1.0
 */
public class City {

    public String name;
    public String countryCode;
    public String district;
    public Integer population;
    public String country;

    /**
     * City Constructor
     * @param name name of city | London
     * @param countryCode code of country of city location | GBR
     * @param district district name of district location | England
     * @param population number of people living in the city | 7285000
     * @param country name of the country of city location | England
     */
    City(String name, String countryCode, String district, Integer population, String country)
    {
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
        this.country = country;
    }

    /**
     * Returns property name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns property country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Returns property district
     */
    public String getDistrict() {
        return district;
    }


    /**
     * Returns property population
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     * Returns toString of City
     */
    @Override
    public String toString() {
        return String.format("%-30s %-20s %-30s %-10s",
                this.name, this.country, this.district, this.population);
    }
}
