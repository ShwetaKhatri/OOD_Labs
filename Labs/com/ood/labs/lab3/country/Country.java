package com.ood.labs.lab3.country;

import java.util.Comparator;

public class Country implements Comparable<Country>{
 /**
  * Constructs a country.
  * @param aName the name of the country
  *  @param anArea the area of the country
  */
	public Country(String aName, double anArea){
		name = aName;
		area = anArea;
	}

/**
  Gets the name of the country.
  @return the name
*/
	public String getName()
	{
		return name;
	}
/** 
 Gets the area of the country.
 @return the area
*/
	public double getArea(){
		return area;
	}
/**
 Compares two countries by area.
 @param otherObject the other country
 @return a negative number if this country has a smaller
 area than otherCountry, 0 if the areas are the same,
 a positive number otherwise
*/
	public int compareTo(Country other)
	{
		if (area < other.area) return -1;
		if (area > other.area) return 1;
		return 0;
	}
	
	public static Comparator<Country> createComparatorByName(final boolean increasing){
		return new 
				Comparator<Country>(){	
			public int compare(Country count1, Country count2) {
				if(increasing) {
					return 1 * count1.getName().compareTo(count2.getName());				
				}
				return -1 * count1.getName().compareTo(count2.getName());	
			}			
		};
	}
	
	public static Comparator<Country> createComparatorByArea(final boolean increasing){
		return new 
				Comparator<Country>() {
			int result;
			public int compare(Country count1, Country count2) {
				if(count1.getArea() == count2.getArea()){
					result = 0;
					return result;
				}
				 result = (count1.getArea() < count2.getArea() ? -1 : 1);
			    return increasing ? result : - result;
			}
		};
	}

	private String name;
	private double area;
}
