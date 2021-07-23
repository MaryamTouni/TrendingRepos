package com.gemography.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gemography.dto.PublicTrendingRepo;
import com.gemography.service.ITrendingReposService;


@RestController
public class TrendingRepoController {

	@Autowired
	ITrendingReposService trendingRepoService;
	
	
	@RequestMapping("/100-trending-public-repos-languages")
	public List<PublicTrendingRepo> allTrendingRepos() {
		return trendingRepoService.allTrendingRepos();
		
	}
}
