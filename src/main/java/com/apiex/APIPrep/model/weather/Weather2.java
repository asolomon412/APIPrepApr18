package com.apiex.APIPrep.model.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather2 {
	private Temperature temp;

	public Temperature getTemp() {
		return temp;
	}

	public void setTemp(Temperature temp) {
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "Weather2 [temp=" + temp + "]";
	}
	
	
	

}
