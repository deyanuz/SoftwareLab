package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This deletes a city from the list if that city exists.
     * @param city
     *      This is the city to delete
     */
    public  void delete(City city){
        if (cities.contains(city)) {
            cities.remove(city);
        }else {
            throw new IllegalArgumentException();
        }
    }
    /**
     * This returns the number of cities that exist.
     * @return
     *      returns an integer, the number of cities.
     */
    public int count(){
        return cities.size();
    }

    /**
     * Returns a list of cities sorted according to the specified criteria.
     *
     * @param criteria The criteria by which the cities should be sorted.
     *                 Use {@link Criteria#BY_CITY} to sort by city name,
     *                 or {@link Criteria#BY_PROVINCE} to sort by province name.
     * @return A list of cities sorted according to the specified criteria.
     */
    public List<City> getCities(Criteria criteria) {
        List<City> cityList = new ArrayList<>(cities);

        // Define comparator based on the sort criteria
        Comparator<City> comparator = null;
        if (criteria == Criteria.BY_CITY) {
            comparator = Comparator.comparing(City::getCityName);
        } else if (criteria == Criteria.BY_PROVINCE) {
            comparator = Comparator.comparing(City::getProvinceName);
        }

        // Sort the list using comparator if it's not null
        if (comparator != null) {
            cityList.sort(comparator);
        }

        return cityList;
    }

    public enum Criteria {
        BY_CITY,
        BY_PROVINCE
    }
}