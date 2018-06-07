package com.apiex.APIPrep.model;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
	
	//@JsonProperty("ID") -- use this annotation if the names don't match
	private int count;
	private String next;
	private ArrayList<Person> results;

	public Result() {
		// TODO Auto-generated constructor stub
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public ArrayList<Person> getResults() {
		return results;
	}

	public void setResults(ArrayList<Person> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "Result [count=" + count + ", next=" + next + ", results=" + results + "]";
	}
	
	



}