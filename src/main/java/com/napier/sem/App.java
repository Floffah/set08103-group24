package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The type App.
 */
public class App {
    static Connection dbCon;
    static DataCollector dataCol;

    /**
     * Initialise the app with a database connection
     * @param dbLocation the host:port of the database
     */
    public App(String dbLocation) {
        loadSQLDriver();
        dbCon = getConnection(dbLocation);
        dataCol = new DataCollector();
    }

    public App() {
        dataCol = new DataCollector();
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        App app = new App("db:3306");
        app.printCityData();
        app.printCountryData();
        String continent = "Asia";  // For example, hardcoded as "Asia"
        String region = "Caribbean";  // For example, hardcoded as "Caribbean"
        String countryCode = "USA"; // For example hardcoded as "USA"
        app.printCountryByPopulationData();
        app.printCountryByContinentPopulationData(continent);
        app.printTopNCountryByContinentPopulationData(continent, 5);
        app.printCountryByRegionPopulationData(region);
        app.printTopNCountryByRegionPopulationData(region, 5);
        app.printCityByPopulationData(countryCode);
        app.disconnect();
    }


    /**
     * Attempt to load mySQL driver to app
     */
    public static void loadSQLDriver() {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }
    }


    /**
     * Attempt connection app to mySQL Database
     *
     * @return mySQL database connection class
     */
    private static Connection getConnection(String location) {
        // Connection to the database
        Connection con = null;
        int retries = 100;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(1000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                // Wait a bit
                Thread.sleep(1000);
                // Exit for loop
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
        return con;
    }

    public void connect(String location) {
        dbCon = getConnection(location);
    }

    /**
     * Disconnect the mySQL database connection
     */
    public void disconnect() {
        if (dbCon != null) {
            try {
                // Close connection
                dbCon.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }


    /**
     * Get city data.
     *
     * @return the array list of cities
     */
    public void printCityData() {
        ArrayList<City> cities = dataCol.getCityData(dbCon);
        // Print header
        System.out.printf("%-30s %-20s %-30s %-10s\n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (City city : cities) {
            System.out.println(city.toString());
        }
    }

    /**
     * Get city by population data.
     *
     * @return the array list of cities
     */
    public void printCityByPopulationData(String countryCode) {
        ArrayList<City> cities = dataCol.getCityByPopulationData(dbCon, countryCode);
        // Print header
        System.out.printf("%-30s %-20s %-30s %-10s\n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (City city : cities) {
            System.out.println(city.toString());
        }
    }

    /**
     * Get language data.
     *
     * @return the array list of languages
     */
    public void printLanguageData() {
        ArrayList<Language> languages = dataCol.getLanguageData(dbCon);
        // Print header
        System.out.printf("%-30s %-16s %-8s %3s\n", "Languages", "Country Code", "Official", "Percentage");
        // Loop over all cities in the list
        for (Language lan : languages) {
            System.out.println(lan.toString());
        }
    }

    /**
     * Get country data.
     *
     * @return the array list of countries
     */
    public void printCountryData() {
        ArrayList<Country> countries = dataCol.getCountryData(dbCon);
        // Print header
        System.out.printf("%-10s %-40s %-30s %-25s %-10s %-30s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (Country country : countries) {
            System.out.println(country.toString());
        }
    }

    /**
     * Get country by population data.
     *
     * @return the array list of countries
     */
    public void printCountryByPopulationData() {
        ArrayList<Country> countries = dataCol.getCountriesByPopulation(dbCon);
        // Print header
        System.out.printf("%-10s %-40s %-30s %-25s %-10s %-30s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (Country country : countries) {
            System.out.println(country.toString());
        }
    }

    /**
     * Get country data.
     *
     * @return the array list of countries
     */
    public void printCountryByContinentPopulationData(String continent) {
        ArrayList<Country> countries = dataCol.getCountriesByContinentPopulation(dbCon, continent);
        // Print header
        System.out.printf("%-10s %-40s %-30s %-25s %-10s %-30s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (Country country : countries) {
            System.out.println(country.toString());
        }
    }

    /**
     * Get country data.
     *
     * @return the array list of countries
     */
    public void printTopNCountryByContinentPopulationData(String continent, int nProvidedByUser) {
        ArrayList<Country> countries = dataCol.getTopNCountryByContinentPopulation(dbCon, continent, nProvidedByUser);
        // Print header
        System.out.printf("%-10s %-40s %-30s %-25s %-10s %-30s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (Country country : countries) {
            System.out.println(country.toString());
        }
    }

    /**
     * Get country region by population data.
     *
     * @return the array list of countries
     */
    public void printCountryByRegionPopulationData(String region) {
        ArrayList<Country> countries = dataCol.getCountriesByRegionPopulation(dbCon, region);
        // Print header
        System.out.printf("%-10s %-40s %-30s %-25s %-10s %-30s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (Country country : countries) {
            System.out.println(country.toString());
        }
    }
    /**
     * Get Capital City in the world Data
     *
     * @return the array list of Capital Cities in the world
     */
    public void printCapitalCityInWorldData() {
        ArrayList<CapitalCity> capitalCities = dataCol.getCapitalCityInWorldData(dbCon);
        // Print header
        System.out.printf("%-30s %-20s %-30s %-10s\n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (CapitalCity capitalcity : capitalCities) {
            System.out.println(capitalcity.toString());
        }
    }
    /**
     * Get Capital City by continent Data
     *
     * @return the array list of Capital Cities by Continent
     */
    public void printCapitalCityByContinentData(String continent) {
        ArrayList<CapitalCity> capitalCities = dataCol.getCapitalCityByContinentData(dbCon,  continent);
        // Print header
        System.out.printf("%-30s %-20s %-30s %-10s\n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (CapitalCity capitalcity : capitalCities) {
            System.out.println(capitalcity.toString());
        }
    }

    /**
     * Get Capital cities by region data.
     *
     * @return the array list of Capital Cities by region
     */
    public void printCapitalCityByRegionData(String region) {
        ArrayList<CapitalCity> capitalCities = dataCol.getCapitalCityByRegionData(dbCon, region);
        // Print header
        System.out.printf("%-30s %-20s %-30s %-10s\n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (CapitalCity capitalcity : capitalCities) {
            System.out.println(capitalcity.toString());
        }
    }


    public void printTopNCapitalCityInWorldData(int nProvidedByUser) {
        ArrayList<CapitalCity> capitalCities = dataCol.getTopNCapitalCityInWorldData(dbCon, nProvidedByUser);
        // Print header
        System.out.printf("%-30s %-20s %-30s %-10s\n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (CapitalCity capitalcity : capitalCities) {
            System.out.println(capitalcity.toString());
        }
    }


    /**
     * Get country data.
     *
     * @return the array list of countries
     */
    public void printTopNCountryByRegionPopulationData(String region, int nProvidedByUser) {
        ArrayList<Country> countries = dataCol.getTopNCountryByRegionPopulation(dbCon, region, nProvidedByUser);
        // Print header
        System.out.printf("%-10s %-40s %-30s %-25s %-10s %-30s\n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        // Loop over all countries in the list
        for (Country country : countries) {
            System.out.println(country.toString());
        }
    }

    public void printTopNCapitalCityByContinentData(String continent, int nProvidedByUser) {
        ArrayList<CapitalCity> capitalCities = dataCol.getTopNCapitalCityByContinentData(dbCon,  continent, nProvidedByUser);
        // Print header
        System.out.printf("%-30s %-20s %-30s %-10s\n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (CapitalCity capitalcity : capitalCities) {
            System.out.println(capitalcity.toString());
        }
    }


    /**
     * Get Top N Capital cities by region data.
     *
     * @return the array list of Capital Cities by region
     */
    public void printTopNCapitalCityRegionData(String region, int nProvidedByUser) {
        ArrayList<CapitalCity> capitalCities = dataCol.getTopNCapitalCityRegionData(dbCon, region, nProvidedByUser);
        // Print header
        System.out.printf("%-30s %-20s %-30s %-10s\n", "Name", "Country", "District", "Population");
        // Loop over all cities in the list
        for (CapitalCity capitalcity : capitalCities) {
            System.out.println(capitalcity.toString());
        }
    }

    public void printPopulationForContinent(String continent) {
        PopulationData popData = dataCol.getPopulationForContinent(dbCon, continent);

        if (popData == null) {
            throw new NullPointerException("Population data is null");
        }

        System.out.println(popData.toString());
    }

    public void printPopulationForRegion(String region) {
        PopulationData popData = dataCol.getPopulationForRegion(dbCon, region);

        if (popData == null) {
            throw new NullPointerException("Population data is null");
        }

        System.out.println(popData.toString());
    }

    public void printPopulationForCountry(String country) {
        PopulationData popData = dataCol.getPopulationForCountry(dbCon, country);

        if (popData == null) {
            throw new NullPointerException("Population data is null");
        }

        System.out.println(popData.toString());
    }
    
    public void printPopulationForDistrict(String district) {
        PopulationData popData = dataCol.getPopulationForDistrict(dbCon, district);

        if (popData == null) {
            throw new NullPointerException("Population data is null");
        }

        System.out.println(popData.toString());
    }
    
    public void printPopulationForCity(String city) {
        PopulationData popData = dataCol.getPopulationForCity(dbCon, city);

        if (popData == null) {
            throw new NullPointerException("Population data is null");
        }

        System.out.println(popData.toString());
    }
    
    public void printPopulationOfWorld() {
        PopulationData popData = dataCol.getPopulationOfWorld(dbCon);

        if (popData == null) {
            throw new NullPointerException("Population data is null");
        }

        System.out.println(popData.toString());
    }
    
    public void printPopulationOfLanguageSpeakers(String language) {
        PopulationData popData = dataCol.getPopulationOfLanguageSpeakers(dbCon, language);

        if (popData == null) {
            throw new NullPointerException("Population data is null");
        }

        System.out.println(popData.toString());
    }
    
    public void printPopulationOfPopularLanguages() {
        // get the population of the world
        PopulationData worldPopData = dataCol.getPopulationOfWorld(dbCon);
        
        List<LanguagePopulationData> langPopData = new ArrayList<>();
        
        // Get all the languages
        PopulationData chinesePopData = dataCol.getPopulationOfLanguageSpeakers(dbCon, "Chinese");
        langPopData.add(new LanguagePopulationData("Chinese", worldPopData.total, chinesePopData));
        PopulationData englishPopData = dataCol.getPopulationOfLanguageSpeakers(dbCon, "English");
        langPopData.add(new LanguagePopulationData("English", worldPopData.total, englishPopData));
        PopulationData hindiPopData = dataCol.getPopulationOfLanguageSpeakers(dbCon, "Hindi");
        langPopData.add(new LanguagePopulationData("Hindi", worldPopData.total, hindiPopData));
        PopulationData spanishPopData = dataCol.getPopulationOfLanguageSpeakers(dbCon, "Spanish");
        langPopData.add(new LanguagePopulationData("Spanish", worldPopData.total, spanishPopData));
        PopulationData arabicPopData = dataCol.getPopulationOfLanguageSpeakers(dbCon, "Arabic");
        langPopData.add(new LanguagePopulationData("Arabic", worldPopData.total, arabicPopData));
        
        // Sort the list of languages by percentage of speakers
        langPopData.sort((a, b) -> (int) (b.total - a.total));
        

        System.out.format("%-20s %-20s %-20s\n", "Language", "Percentage", "Total");
        
        for (LanguagePopulationData lang : langPopData) {
            System.out.println(lang.toString());
        }
    }
}