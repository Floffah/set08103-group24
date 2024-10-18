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

    /**
     * City Constructor
     * @param name name of city e.g. London
     * @param countryCode code of country of city location
     * @param district district name of city location
     * @param population number of people living in the city e.g. 1200000
     */
    private City(String name, String countryCode, String district, Integer population)
    {
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }



    /**
     * Returns toString of City
     */
    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}
