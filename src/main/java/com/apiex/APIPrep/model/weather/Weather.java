package com.apiex.APIPrep.model.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
	
	private String operationalMode;
	private String productionCenter;
	private Currentobservation co;
	private Location loc;
	
	public Weather() {
		
	}
	public String getOperationalMode() {
		return operationalMode;
	}
	public void setOperationalMode(String operationalMode) {
		this.operationalMode = operationalMode;
	}
	public Currentobservation getCo() {
		return co;
	}
	public void setCo(Currentobservation co) {
		this.co = co;
	}
	@Override
	public String toString() {
		return "Weather [operationalMode=" + operationalMode + ", co=" + co + "prodCenter=" +productionCenter+ " " + loc+"]";
	}
	public String getProductionCenter() {
		return productionCenter;
	}
	public void setProductionCenter(String productionCenter) {
		this.productionCenter = productionCenter;
	}
	public Location getLoc() {
		return loc;
	}
	public void setLoc(Location loc) {
		this.loc = loc;
	}
	
	

}
