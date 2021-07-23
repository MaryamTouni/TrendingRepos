package com.gemography.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Item {

	private long id;
	private String name;
	private String full_name;
	private String url;
	private String description;
	private String language;
	public Item(){
		
	}
	public Item(long id, String name, String full_name, String url, String description, String language) {
		super();
		this.id = id;
		this.name = name;
		this.full_name = full_name;
		this.url = url;
		this.description = description;
		this.language = language;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
