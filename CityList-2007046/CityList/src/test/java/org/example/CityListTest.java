package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CityListTest {
    City city1 = new City("Dhaka","Bangladesh");
    City city2 = new City("Mumbai","India");
    City city3 = new City("Tokyo","Japan");



    @Test
    public void testdelete()
    {
        CityList list = new CityList();
        list.add(city1);
        list.add(city2);
        list.add(city3);
        list.delete(city1);
        List<City> cityList=list.getCities(CityList.Criteria.BY_PROVINCE);
        assertFalse(cityList.contains(city1));
    }

    @Test
    public void testdeleteexception()
    {
        CityList list = new CityList();
        list.add(city1);
        list.add(city2);
        list.add(city3);
        list.delete(city1);
        List<City> cityList=list.getCities(CityList.Criteria.BY_PROVINCE);
        assertThrows(IllegalArgumentException.class, () -> list.delete(city1));
    }

    @Test
    public void CountTest()
    {
        CityList list = new CityList();
        list.add(city1);
        list.add(city2);
        assertEquals(2,list.count());
    }

    @Test
    public void testsort()
    {
        CityList list = new CityList();
        list.add(city1);
        list.add(city2);
        list.add(city3);

        List<City> sortedCities = list.getCities(CityList.Criteria.BY_PROVINCE);
        int n=sortedCities.size();
        for (int i = 0; i < n-1; i++) {
            assertTrue(sortedCities.get(i).compareTo(sortedCities.get(i + 1)) <= 0);
        }
    }

    @Test
    public void testGetCitiesByCityName() {
        CityList cityList = new CityList();
        cityList.add(new City("City1", "Province1"));
        cityList.add(new City("City3", "Province2"));
        cityList.add(new City("City2", "Province3"));

        List<City> sortedCities = cityList.getCities(CityList.Criteria.BY_CITY);

        assertEquals("City1", sortedCities.get(0).getCityName());
        assertEquals("City2", sortedCities.get(1).getCityName());
        assertEquals("City3", sortedCities.get(2).getCityName());
    }

    @Test
    public void testGetCitiesByProvinceName() {
        CityList cityList = new CityList();
        cityList.add(new City("City1", "Province3"));
        cityList.add(new City("City2", "Province2"));
        cityList.add(new City("City3", "Province1"));

        List<City> sortedCities = cityList.getCities(CityList.Criteria.BY_PROVINCE);

        assertEquals("Province1", sortedCities.get(0).getProvinceName());
        assertEquals("Province2", sortedCities.get(1).getProvinceName());
        assertEquals("Province3", sortedCities.get(2).getProvinceName());
    }


}