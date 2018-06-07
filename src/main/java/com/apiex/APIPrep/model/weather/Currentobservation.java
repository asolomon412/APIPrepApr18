package com.apiex.APIPrep.model.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonRootName(value = "currentobservation")
public class Currentobservation {
	@JsonProperty(value="id")
	private String id;
	@JsonProperty(value="name")
	private String name;
	@JsonProperty(value="Weather")
	private String weather;
	@JsonProperty(value="Temp")
	private String temp;
	@JsonProperty(value="Weatherimage")
	private String weatherImage;
	
	public Currentobservation() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getWeatherImage() {
		return weatherImage;
	}

	public void setWeatherImage(String weatherImage) {
		this.weatherImage = weatherImage;
	}

	@Override
	public String toString() {
		return "CurrentObservation [id=" + id + ", name=" + name + ", weather=" + weather + ", temp=" + temp
				+ ", weatherImage=" + weatherImage + "]";
	}

}
