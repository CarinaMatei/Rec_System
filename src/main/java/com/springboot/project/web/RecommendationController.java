package com.springboot.project.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.project.model.Movie;
import com.springboot.project.model.User;
import com.springboot.project.service.RecommendationService;
import com.springboot.project.service.UserService;

@Controller
public class RecommendationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecommendationService recommendationService;
	
	@Autowired
	public RecommendationController(UserService userService,
	        RecommendationService recommendationService) {
	    super();
	    this.userService = userService;
	    this.recommendationService = recommendationService;
	}
	
	@GetMapping("/recommendation/friends")
	public String showFriendsList(Model model, Principal principal) {
	    User loggedInUser = userService.findByEmail(principal.getName());
	    List<User> friends = loggedInUser.getFriends();
	    model.addAttribute("friends", friends);
	    return "recommendation_friends";
	}
	
    @PostMapping("/recommendation/movies")    
    public String showMovieRecommendations(@RequestParam List<Long> selectedFriends, Model model, Principal principal) {
        User loggedInUser = userService.findByEmail(principal.getName());
        List<User> friends = userService.getUsersByIds(selectedFriends);
        List<Movie> recommendedMovies = recommendationService.generateCollaborativeRecommendations(loggedInUser, friends);
        model.addAttribute("recommendedMovies", recommendedMovies);
        return "recommendation_movies";
    }

}
