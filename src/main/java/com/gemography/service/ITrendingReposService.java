package com.gemography.service;

import java.util.List;

import com.gemography.dto.Item;
import com.gemography.dto.PublicTrendingRepo;
import com.gemography.dto.Result;

public interface ITrendingReposService {

	Result trendingPublicRepos();
	List<String> trendingRposLanguages();
	int numberOfRepos(String language);
	List<Item> reposUsingLanguage(String language);
	List<PublicTrendingRepo> allTrendingRepos();
	
}
