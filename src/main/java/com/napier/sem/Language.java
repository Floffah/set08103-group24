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
    public Float percentage;

    /**
     * City Constructor
     * @param countryCode code of country of city location | GBR
     * @param name name of the language | Dutch
     * @param isOfficial whether the language is the official language of the country | True
     * @param percentage percentage of language spoken in country | 76.5
     */
    public Language(String name, String countryCode, Boolean isOfficial, Float percentage)
    {
        this.name = name;
        this.countryCode = countryCode;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
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
    public Boolean getIsOfficial() {
        return isOfficial;
    }


    /**
     * Returns property population
     */
    public Float getPercentage() {
        return percentage;
    }

    /**
     * Returns toString of City
     */
    @Override
    public String toString() {
        return String.format("%-30s %-16s %-8s %3s%%",
                this.name, this.countryCode, this.isOfficial, this.percentage);
    }
}
