package com.gemography.dto;

import java.util.List;

public class Result {


	private String total_count;
	private String incomplete_results;
	private List<Item> items;
	
	public String getTotal_count() {
		return total_count;
	}
	public void setTotal_count(String total_count) {
		this.total_count = total_count;
	}
	public String getIncomplete_results() {
		return incomplete_results;
	}
	public void setIncomplete_results(String incomplete_results) {
		this.incomplete_results = incomplete_results;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	
}
