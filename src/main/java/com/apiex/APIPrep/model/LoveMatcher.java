package com.apiex.APIPrep.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoveMatcher {

	@JsonProperty("fname")
	private String fname;
	@JsonProperty("sname")
	private String sname;
	@JsonProperty("percentage")
	private String percentage;
	@JsonProperty("result")
	private String result;

	public LoveMatcher() {
		// TODO Auto-generated constructor stub
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String lname) {
		this.sname = lname;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "LoveMatcher [fname=" + fname + ", lname=" + sname + ", percentage=" + percentage + ", result=" + result
				+ "]";
	}

}
