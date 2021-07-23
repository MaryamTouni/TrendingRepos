package com.gemography.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gemography.dto.Item;
import com.gemography.dto.PublicTrendingRepo;
import com.gemography.dto.Result;

@Service
public class TrendingReposService implements ITrendingReposService{

	private List<Item> allTrendingRepos;

	@Override
	public Result trendingPublicRepos() {
		Date currentDate = new Date();
		currentDate.setMonth(currentDate.getMonth() - 1);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dateOnly = dateFormat.format(currentDate);
		final String BASE_URL = "https://api.github.com/search/repositories?q=" + dateOnly + "&sort=stars&order=desc";
		RestTemplate restTemplate = new RestTemplate();
		Result o = restTemplate.getForObject(BASE_URL, Result.class);
		return o;
	}

	@Override
	public List<String> trendingRposLanguages() {
		if (allTrendingRepos == null) {
			allTrendingRepos = trendingPublicRepos().getItems();
		}
		List<String> languages = new ArrayList<String>();
		if (allTrendingRepos != null) {
			for (int i = 0; i < allTrendingRepos.size(); i++) {
				if (allTrendingRepos.get(i).getLanguage() != null
						&& !languages.contains(allTrendingRepos.get(i).getLanguage()))
					languages.add(allTrendingRepos.get(i).getLanguage());
			}
		}
		return languages;
	}

	@Override
	public int numberOfRepos(String language) {
		if (allTrendingRepos == null) {
			allTrendingRepos = trendingPublicRepos().getItems();
		}
		int countOfRepos = 0;
		if (allTrendingRepos != null) {
			for (int i = 0; i < allTrendingRepos.size(); i++) {
				if (allTrendingRepos.get(i) != null && allTrendingRepos.get(i).getLanguage() != null
						&& allTrendingRepos.get(i).getLanguage().equals(language)) {
					countOfRepos++;
				}
			}
		}

		return countOfRepos;
	}

	@Override
	public List<Item> reposUsingLanguage(String language) {
		if (allTrendingRepos == null) {
			allTrendingRepos = trendingPublicRepos().getItems();
		}
		List<Item> repos = new ArrayList<Item>();
		if (allTrendingRepos != null) {
			for (int i = 0; i < allTrendingRepos.size(); i++) {
				if (allTrendingRepos.get(i) != null && allTrendingRepos.get(i).getLanguage() != null
						&& allTrendingRepos.get(i).getLanguage().equals(language)) {
					repos.add(allTrendingRepos.get(i));
				}
			}
		}
		return repos;
	}

	@Override
	public List<PublicTrendingRepo> allTrendingRepos() {
		List<String> languages = trendingRposLanguages();
		List<PublicTrendingRepo> repos = new ArrayList<PublicTrendingRepo>();
		
		for (int i = 0; i < languages.size(); i++) {
			PublicTrendingRepo repo = new PublicTrendingRepo();
			repo.setLanguage(languages.get(i));
			repo.setNumber_of_repos(numberOfRepos(repo.getLanguage()));
			repo.setRepos_using_lang(reposUsingLanguage(repo.getLanguage()));
			repos.add(i, repo);
		}
		return repos;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
