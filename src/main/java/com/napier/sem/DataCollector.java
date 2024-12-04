package com.napier.sem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DataCollector {

    /**
     * Get city data as array list.
     *
     * @param con the Sql Database connection
     * @return ArrayList of City Classes
     */
    public ArrayList<City> getCityData(Connection con) {

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Name FROM city, country WHERE city.CountryCode = country.Code";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                String name = rset.getString("city.Name");
                String code = rset.getString("city.CountryCode");
                String district = rset.getString("city.District");
                Integer population = rset.getInt("city.Population");
                String country = rset.getString("country.Name");

                City city = new City(name, code, district, population, country);

                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public ArrayList<City> getCityByPopulationData(Connection con, String countryCode) {

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.CountryCode, country.Name, city.District, city.Population " +
                            "FROM city " +
                            "JOIN country ON city.CountryCode = country.Code " +
                            "WHERE city.CountryCode = '" + countryCode + "' " + // Filter by country code
                            "ORDER BY city.Population DESC";  // Sort by population (largest to smallest)
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                String name = rset.getString("city.Name");
                String code = rset.getString("city.CountryCode");
                String district = rset.getString("city.District");
                Integer population = rset.getInt("city.Population");
                String country = rset.getString("country.Name");

                City city = new City(name, code, district, population, country);

                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }



    /**
     * Get Language data as array list.
     *
     * @param con the Sql Database connection
     * @return ArrayList of Language Classes
     */
    public ArrayList<Language> getLanguageData(Connection con){
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT countrylanguage.Language, countrylanguage.CountryCode, countrylanguage.IsOfficial, countrylanguage.Percentage FROM countrylanguage";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Language> languages = new ArrayList<>();
            while (rset.next()) {
                String name = rset.getString("countrylanguage.Language");
                String code = rset.getString("countrylanguage.CountryCode");
                Boolean official = rset.getBoolean("countrylanguage.IsOfficial");
                Float percentage = rset.getFloat("countrylanguage.Percentage");

                Language language = new Language(name, code, official, percentage);

                languages.add(language);
            }
            return languages;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Language details");
            return null;
        }
    }

    /**
     * Get country data as array list.
     *
     * @param con the Sql Database connection
     * @return ArrayList of Country Classes
     */
    public ArrayList<Country> getCountryData(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Corrected SQL query
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital " +
                            "FROM country";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String region = rset.getString("Region");
                int population = rset.getInt("Population");
                int capital = rset.getInt("Capital");

                Country country = new Country(code, name, continent, region, population, capital);
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * All the countries in the world organised by largest population to smallest.
     *
     * @param con the Sql Database connection
     * @return ArrayList of Country Classes
     */
    public ArrayList<Country> getCountriesByPopulation(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get all countries sorted by population largest to smallest
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital " +
                            "FROM country " +
                            "ORDER BY country.Population DESC";  // Sort by population (largest to smallest)

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continentName = rset.getString("Continent");
                String region = rset.getString("Region");
                int population = rset.getInt("Population");
                int capital = rset.getInt("Capital");

                Country country = new Country(code, name, continentName, region, population, capital);
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details by population");
            return null;
        }
    }

    /**
     * All the countries in a continent organised by largest population to smallest
     *
     * @param con the Sql Database connection
     * @return ArrayList of Country Classes
     */
    public ArrayList<Country> getCountriesByContinentPopulation(Connection con, String continent) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get all countries from the specified continent, sorted by population
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital " +
                            "FROM country " +
                            "WHERE country.Continent = '" + continent + "' " +  // Filter by continent
                            "ORDER BY country.Population DESC";  // Sort by population (largest to smallest)

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continentName = rset.getString("Continent");
                String region = rset.getString("Region");
                int population = rset.getInt("Population");
                int capital = rset.getInt("Capital");

                Country country = new Country(code, name, continentName, region, population, capital);
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details by population");
            return null;
        }
    }

    /**
     * The top N populated countries in a continent where N is provided by the user.
     *
     * @param con the Sql Database connection
     * @return ArrayList of Country Classes
     */
    public ArrayList<Country> getTopNCountryByContinentPopulation(Connection con, String continent, int nProvidedByUser) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get all countries from the specified continent, sorted by population
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital " +
                            "FROM country " +
                            "WHERE country.Continent = '" + continent + "' " +  // Filter by continent
                            "ORDER BY country.Population DESC " +
                            "LIMIT " + nProvidedByUser + ";";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continentName = rset.getString("Continent");
                String region = rset.getString("Region");
                int population = rset.getInt("Population");
                int capital = rset.getInt("Capital");

                Country country = new Country(code, name, continentName, region, population, capital);
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details by population");
            return null;
        }
    }

    /**
     * All the countries in a region organised by largest population to smallest.
     *
     * @param con the Sql Database connection
     * @return ArrayList of Country Classes
     */
    public ArrayList<Country> getCountriesByRegionPopulation(Connection con, String region) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // SQL query to get all countries from the specified region, sorted by population
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital " +
                            "FROM country " +
                            "WHERE country.Region = '" + region + "' " +  // Filter by region
                            "ORDER BY country.Population DESC";  // Sort by population (largest to smallest)

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                String code = rset.getString("Code");
                String name = rset.getString("Name");
                String continent = rset.getString("Continent");
                String regionName = rset.getString("Region");
                int population = rset.getInt("Population");
                int capital = rset.getInt("Capital");

                Country country = new Country(code, name, continent, regionName, population, capital);
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country region details by population");
            return null;
        }
    }

    public ArrayList<CapitalCity> getCapitalCityData(Connection con){

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Name " +
                            "FROM city, country " +
                            "WHERE city.CountryCode = country.Code AND city.ID = country.Capital AND country.Capital is NOT NULL\n";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> capitalCities = new ArrayList<>();
            while (rset.next()) {
                String name = rset.getString("city.Name");
                String code = rset.getString("city.CountryCode");
                String district = rset.getString("city.District");
                Integer population = rset.getInt("city.Population");
                String country = rset.getString("country.Name");

                CapitalCity capitalCity = new CapitalCity(name, code, district, population, country);

                capitalCities.add(capitalCity);
            }
            return capitalCities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital city details");
            return null;
        }
    }

    /**
     * Get the number of people living in cities and outwith cities for a continent
     * @param con the Sql Database connection
     * @param continent the continent to get the population data for
     * @return PopulationData object containing the total population, population in cities, and population outwith cities
     */
    public PopulationData getPopulationForContinent(Connection con, String continent) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT COUNT(country.Code) as countriesChecked, SUM(country.Population) AS total, SUM(city.Population) AS inCities, SUM(country.Population) - SUM(city.Population) AS outwithCities " +
                            "FROM country, city " +
                            "WHERE country.Code = city.CountryCode AND country.Continent = '" + continent + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract population information
            PopulationData populationData = new PopulationData();

            while (rset.next()) {
                if (rset.getInt("countriesChecked") == 0) {
                    throw new NullPointerException("No population data found for continent");
                }

                populationData.total = rset.getLong("total");
                populationData.inCities = rset.getLong("inCities");
                populationData.outwithCities = rset.getLong("outwithCities");
            }

            return populationData;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to get population details for continent");
            return null;
        }
    }

    public PopulationData getPopulationForRegion(Connection con, String region) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT COUNT(country.Code) as countriesChecked, SUM(country.Population) AS total, SUM(city.Population) AS inCities, SUM(country.Population) - SUM(city.Population) AS outwithCities " +
                            "FROM country, city " +
                            "WHERE country.Code = city.CountryCode AND country.Region = '" + region + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract population information
            PopulationData populationData = new PopulationData();

            while (rset.next()) {
                if (rset.getInt("countriesChecked") == 0) {
                    throw new NullPointerException("No population data found for region");
                }

                populationData.total = rset.getLong("total");
                populationData.inCities = rset.getLong("inCities");
                populationData.outwithCities = rset.getLong("outwithCities");
            }

            return populationData;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to get population details for region");
            return null;
        }
    }

    public PopulationData getPopulationForCountry(Connection con, String country) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT COUNT(country.Code) as countriesChecked, SUM(country.Population) AS total, SUM(city.Population) AS inCities, SUM(country.Population) - SUM(city.Population) AS outwithCities " +
                            "FROM country, city " +
                            "WHERE country.Code = city.CountryCode AND country.Name = '" + country + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract population information
            PopulationData populationData = new PopulationData();

            while (rset.next()) {
                if (rset.getInt("countriesChecked") == 0) {
                    throw new NullPointerException("No population data found for country");
                }

                populationData.total = rset.getLong("total");
                populationData.inCities = rset.getLong("inCities");
                populationData.outwithCities = rset.getLong("outwithCities");
            }

            return populationData;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to get population details for country");
            return null;
        }
    }
    
    public PopulationData getPopulationForDistrict(Connection con, String district) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT COUNT(city.ID) as citiesChecked, SUM(city.Population) AS total " +
                            "FROM city " +
                            "WHERE city.District = '" + district + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract population information
            PopulationData populationData = new PopulationData();

            while (rset.next()) {
                if (rset.getInt("citiesChecked") == 0) {
                    throw new NullPointerException("No population data found for district");
                }

                populationData.total = rset.getLong("total");
            }

            return populationData;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to get population details for district");
            return null;
        }
    }
    
    public PopulationData getPopulationForCity(Connection con, String city) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT COUNT(city.ID) as citiesChecked, SUM(city.Population) AS total " +
                            "FROM city " +
                            "WHERE city.Name = '" + city + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract population information
            PopulationData populationData = new PopulationData();

            while (rset.next()) {
                if (rset.getInt("citiesChecked") == 0) {
                    throw new NullPointerException("No population data found for city");
                }

                populationData.total = rset.getLong("total");
            }

            return populationData;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to get population details for city");
            return null;
        }
    }
    
    public PopulationData getPopulationOfWorld(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(country.Population) AS total, SUM(city.Population) AS inCities, SUM(country.Population) - SUM(city.Population) AS outwithCities " +
                            "FROM country, city " +
                            "WHERE country.Code = city.CountryCode";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract population information
            PopulationData populationData = new PopulationData();

            while (rset.next()) {
                populationData.total = rset.getLong("total");
                populationData.inCities = rset.getLong("inCities");
                populationData.outwithCities = rset.getLong("outwithCities");
            }

            return populationData;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to get population details for world");
            return null;
        }
    }
    
    public PopulationData getPopulationOfLanguageSpeakers(Connection con, String language) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Population AS total, countrylanguage.Percentage as percentageSpeakers " +
                            "FROM country, countrylanguage " +
                            "WHERE country.Code = countrylanguage.CountryCode AND countrylanguage.Language = '" + language + "' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract population information
            PopulationData populationData = new PopulationData();

            long totalPopulation = 0;
            
            while (rset.next()) {
                totalPopulation += rset.getLong("total") * rset.getLong("percentageSpeakers") / 100;
            }
            
            populationData.total = totalPopulation;

            return populationData;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to get population details for language speakers");
            return null;
        }
    }
}
