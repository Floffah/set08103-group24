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
    public ArrayList<City> getCityData(Connection con){

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
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
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
}
