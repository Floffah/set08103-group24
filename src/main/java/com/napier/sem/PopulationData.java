package com.napier.sem;

/**
 * Class that represents population data categorised by people within cities and people outwith cities
 */
public class PopulationData {
    /**
     * The total number of people in the region/country/continent
     */
    public long total;
    /**
     * The number of people living in cities within the region/country/continent
     */
    public long inCities;
    /**
     * The number of people living outwith cities within the region/country/continent
     */
    public long outwithCities;

    @Override
    public String toString() {
        return "Total = " + total + "\n" +
                "In Cities = " + inCities + "\n" +
                "Outwith Cities = " + outwithCities;
    }
}
