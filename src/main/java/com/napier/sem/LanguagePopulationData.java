package com.napier.sem;

/**
 * Represents population data categorised by people who speak a certain language
 */
public class LanguagePopulationData extends PopulationData {
    /**
     * The language that the population data is categorised by
     */
    public String language;

    /**
     * The percentage of people who speak the language in the world
     */
    public double percentage;

    /**
     * Constructor for the LanguagePopulationData class
     * @param language The language that the population data is categorised by
     * @param total The total number of people who speak the language
     * @param inCities The number of people who speak the language and live in cities
     * @param outwithCities The number of people who speak the language and live outwith cities
     */
    public LanguagePopulationData(String language, long total, long inCities, long outwithCities) {
        this.language = language;
        this.total = total;
        this.inCities = inCities;
        this.outwithCities = outwithCities;
    }

    /**
     * Constructor to extend the PopulationData class
     * @param language The language that the population data is categorised by
     * @param worldPopulation The total world population
     * @param populationData The population data to extend
     */
    public LanguagePopulationData(String language, long worldPopulation, PopulationData populationData) {
        this.language = language;
        this.total = populationData.total;
        this.inCities = populationData.inCities;
        this.outwithCities = populationData.outwithCities;
        this.percentage = ((double) populationData.total / worldPopulation) * 100;
    }
    
    @Override
    public String toString() {
        return String.format("%-20s %-20f %-20d", language, percentage, total);
    }
}
