package com.lab.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Country {
	
	private String code;
	private String name;
	private Integer population;

	public Country() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param code
	 * @param name
	 * @param population
	 */
	public Country(String code, String name, Integer population) {
		this.code = code;
		this.name = name;
		this.population = population;
	}



	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the population
	 */
	public Integer getPopulation() {
		return population;
	}

	/**
	 * @param population the population to set
	 */
	public void setPopulation(Integer population) {
		this.population = population;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this.getClass()).add("code", code)
	            .add("name", name)
	            .add("population", population)
	            .toString();
	}
	
	@Override
	public int hashCode() {
	    return Objects.hashCode(code, name, population);
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;

	    Country that = (Country) o;

	    return Objects.equal(this.code, that.code);
	}
	

}
