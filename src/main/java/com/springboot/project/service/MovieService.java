package com.springboot.project.service;

import java.util.List;

import com.springboot.project.model.Movie;

public interface MovieService {
	List<Movie> getAllMovies();
	
	Movie saveMovie(Movie movie);
	
	Movie getMovieById(Long id);
	
	Movie updateMovie(Movie movie);
	
	void deleteMovieById(Long id);
	
//	List<Movie> getMoviesByGenre(String genre);
}
