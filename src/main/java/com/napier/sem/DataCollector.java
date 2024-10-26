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
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population FROM city";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                String name = rset.getString("city.Name");
                String code = rset.getString("city.CountryCode");
                String district = rset.getString("city.District");
                Integer population = rset.getInt("city.Population");

                City emp = new City(name, code, district, population);

                cities.add(emp);
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
}
