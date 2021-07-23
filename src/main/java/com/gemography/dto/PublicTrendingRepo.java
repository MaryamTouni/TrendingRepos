package com.gemography.dto;

import java.util.List;

public class PublicTrendingRepo {

	private String language;
	private int number_of_repos;
	private List<Item> repos_using_lang;
	
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getNumber_of_repos() {
		return number_of_repos;
	}
	public void setNumber_of_repos(int number_of_repos) {
		this.number_of_repos = number_of_repos;
	}
	public List<Item> getRepos_using_lang() {
		return repos_using_lang;
	}
	public void setRepos_using_lang(List<Item> repos_using_lang) {
		this.repos_using_lang = repos_using_lang;
	}
}
