package com.apiex.APIPrep.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// for Vicki
@JsonIgnoreProperties(ignoreUnknown = true)
public class Definition {

	@JsonProperty("type")
	private String type;
	@JsonProperty("definition")
	private String definition;
	@JsonProperty("example")
	private String example;
	public Definition() {
		// TODO Auto-generated constructor stub
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
	@Override
	public String toString() {
		return "Definition [type=" + type + ", definition=" + definition + ", example=" + example + "]";
	}
	
	
}
