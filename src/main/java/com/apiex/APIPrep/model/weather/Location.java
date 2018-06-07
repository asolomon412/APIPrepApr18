package com.apiex.APIPrep.model.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
	private String region;
	

	public Location() {
		// TODO Auto-generated constructor stub
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Location [region=" + region + "]";
	}
	

}
