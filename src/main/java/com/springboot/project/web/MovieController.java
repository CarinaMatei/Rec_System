package com.springboot.project.web;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.project.model.Movie;
import com.springboot.project.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	@GetMapping("/movies")
	public String listMovies(Model model) {
	    List<Movie> movies = movieService.getAllMovies();
	    
	    for (Movie movie : movies) {
	        String imageBase64 = Base64.getEncoder().encodeToString(movie.getImage());
	        movie.setImageBase64(imageBase64);
	    }
	    
	    model.addAttribute("movies", movies);
	    return "movies";
	}
	
	@GetMapping("/movies/new")
	public String createMovieForm(Model model) {
		
		//create movie object to hold movie form data 
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "create_movie";
	}
	
	@PostMapping("/movies")
	public String saveMovie(@ModelAttribute("movie") Movie movie,
	                        @RequestParam("imageFile") MultipartFile imageFile, Model model) {
	    // Process the imageFile and save the bytes to the movie's image field
	    if (!imageFile.isEmpty()) {
	        try {
	            movie.setImage(imageFile.getBytes());
	        } catch (IOException e) {
	        	e.printStackTrace();
	        	model.addAttribute("error", "An error occurred while processing the image.");
	        }
	    }
	    movieService.saveMovie(movie);
	    return "redirect:/movies";
	}
	
	@GetMapping("/movies/edit/{id}")
	public String editMovieForm(@PathVariable Long id, Model model) {
		model.addAttribute("movie", movieService.getMovieById(id));
		return "edit_movie";
	}
	
	@PostMapping("/movies/{id}")
	public String updateMovie(@PathVariable Long id, @ModelAttribute("movie") Movie updatedMovie, Model model) {
		
		//get movie from database by id
		Movie existingMovie = movieService.getMovieById(id);
		
		existingMovie.setMovie_name(updatedMovie.getMovie_name());
		existingMovie.setGenre_drama(updatedMovie.getGenre_drama());
		existingMovie.setGenre_action(updatedMovie.getGenre_action());
		existingMovie.setGenre_romance(updatedMovie.getGenre_romance());
		existingMovie.setGenre_comedy(updatedMovie.getGenre_comedy());
		existingMovie.setGenre_fantasy(updatedMovie.getGenre_fantasy());
		existingMovie.setGenre_sf(updatedMovie.getGenre_sf());
		existingMovie.setGenre_thriller(updatedMovie.getGenre_thriller());
		existingMovie.setGenre_adventure(updatedMovie.getGenre_adventure());
		existingMovie.setGenre_documentary(updatedMovie.getGenre_documentary());
		existingMovie.setGenre_animation(updatedMovie.getGenre_animation());
		existingMovie.setGenre_horror(updatedMovie.getGenre_horror());
		existingMovie.setGenre_crime(updatedMovie.getGenre_crime());
		existingMovie.setGenre_mystery(updatedMovie.getGenre_mystery());
		existingMovie.setGenre_historical(updatedMovie.getGenre_historical());
		existingMovie.setGenre_musical(updatedMovie.getGenre_musical());
		existingMovie.setRelease(updatedMovie.getRelease());
		existingMovie.setLength(updatedMovie.getLength());
		existingMovie.setRating(updatedMovie.getRating());
		existingMovie.setActors(updatedMovie.getActors());
		existingMovie.setDescription(updatedMovie.getDescription());
		
		//save updated movie object
		movieService.updateMovie(existingMovie);
		
		return "redirect:/movies";
	}
	
	@GetMapping("/movies/{id}")
	public String deleteMovie(@PathVariable Long id) {
		movieService.deleteMovieById(id);
		return "redirect:/movies";
	}
}
