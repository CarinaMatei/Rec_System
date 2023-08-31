package com.springboot.project.service;

import java.util.List;

import com.springboot.project.model.Movie;
import com.springboot.project.model.User;

public interface RecommendationService {
	
	List<Movie> generateCollaborativeRecommendations(User user, List<User> friends);

}
