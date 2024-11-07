package com.napier.sem;

/**
 * Class that represents a City.
 * @author Fergus Haak
 * @version 1.0
 */
public class Language {

    public String countryCode;
    public String name;
    public Boolean isOfficial;
    public Integer percentage;

    /**
     * City Constructor
     * @param countryCode code of country of city location | GBR
     * @param name name of the language | Dutch
     * @param isOfficial whether the language is the official language of the country | True
     * @param population percentage of language spoken in country | 76.5
     */
    Language(String name, String countryCode, String district, Integer population)
    {
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
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
        return String.format("%-30s %-12s %-30s %-10s",
                this.name, this.countryCode, this.district, this.population);
    }
}
