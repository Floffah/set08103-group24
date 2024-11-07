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

    /**
     * Get Langauge data as array list.
     *
     * @param con the Sql Database connection
     * @return ArrayList of Language Classes
     */
    public ArrayList<Language> getLangaugeData(Connection con){
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
}
