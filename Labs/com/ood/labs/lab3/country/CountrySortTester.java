package com.ood.labs.lab3.country;

import java.util.ArrayList;
import java.util.Collections;


public class CountrySortTester{
	public static void main(String[] args){
		ArrayList<Country> countries = new ArrayList<Country>();
		countries.add(new Country("Uruguay", 176220));
		countries.add(new Country("Thailand", 514000));
		countries.add(new Country("Belgium", 30510));
		countries.add(new Country("Germany", 514000));
		//Collections.sort(countries);
		Collections.sort(countries,Country.createComparatorByName(true));
		// Now the array list is sorted by area
		for (Country c : countries)
			System.out.println(c.getName() + " " + c.getArea());
		}
	}
