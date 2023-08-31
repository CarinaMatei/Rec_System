package com.springboot.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.project.model.Movie;
import com.springboot.project.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	private MovieRepository movieRepository;	

	public MovieServiceImpl(MovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public Movie getMovieById(Long id) {
		return movieRepository.findById(id).get();
	}

	@Override
	public Movie updateMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public void deleteMovieById(Long id) {
		movieRepository.deleteById(id);
	}
	
//	public List<Movie> getMoviesByGenre(String genre) {
//	    // Define default values for year and length ranges
//	    int defaultYearMin = 1900; // Example value
//	    int defaultYearMax = 2023; // Example value
//	    int defaultLengthMin = 0;  // Example value
//	    int defaultLengthMax = 300; // Example value
//
//	    switch (genre.toLowerCase()) {
//	        case "drama":
//	            return movieRepository.findByGenreDramaAndReleaseBetweenAndLengthBetween(1, defaultYearMin, defaultYearMax, defaultLengthMin, defaultLengthMax);
//	        case "action":
//	            return movieRepository.findByGenreActionAndReleaseBetweenAndLengthBetween(1, defaultYearMin, defaultYearMax, defaultLengthMin, defaultLengthMax);
//	        case "comedy":
//	            return movieRepository.findByGenreComedyAndReleaseBetweenAndLengthBetween(1, defaultYearMin, defaultYearMax, defaultLengthMin, defaultLengthMax);
//	        case "fantasy":
//	            return movieRepository.findByGenreFantasyAndReleaseBetweenAndLengthBetween(1, defaultYearMin, defaultYearMax, defaultLengthMin, defaultLengthMax);
//	        case "sf":
//	            return movieRepository.findByGenreSFAndReleaseBetweenAndLengthBetween(1, defaultYearMin, defaultYearMax, defaultLengthMin, defaultLengthMax);
//	        case "thriller":
//	            return movieRepository.findByGenreThrillerAndReleaseBetweenAndLengthBetween(1, defaultYearMin, defaultYearMax, defaultLengthMin, defaultLengthMax);
//	        case "adventure":
//	            return movieRepository.findByGenreAdventureAndReleaseBetweenAndLengthBetween(1, defaultYearMin, defaultYearMax, defaultLengthMin, defaultLengthMax);
//	        case "documentary":
//	            return movieRepository.findByGenreDocumentaryAndReleaseBetweenAndLengthBetween(1, defaultYearMin, defaultYearMax, defaultLengthMin, defaultLengthMax);
//	        case "animation":
//	            return movieRepository.findByGenreAnimationAndReleaseBetweenAndLengthBetween(1, defaultYearMin, defaultYearMax, defaultLengthMin, defaultLengthMax);
//	        case "horror":
//	            return movieRepository.findByGenreHorrorAndReleaseBetweenAndLengthBetween(1, defaultYearMin, defaultYearMax, defaultLengthMin, defaultLengthMax);
//	        case "crime":
//	            return movieRepository.findByGenreCrimeAndReleaseBetweenAndLengthBetween(1, defaultYearMin, defaultYearMax, defaultLengthMin, defaultLengthMax);
//	        case "mystery":
//	            return movieRepository.findByGenreMysteryAndReleaseBetweenAndLengthBetween(1, defaultYearMin, defaultYearMax, defaultLengthMin, defaultLengthMax);
//	        case "historical":
//	            return movieRepository.findByGenreHistoricalAndReleaseBetweenAndLengthBetween(1, defaultYearMin, defaultYearMax, defaultLengthMin, defaultLengthMax);
//	        case "musical":
//	            return movieRepository.findByGenreMusicalAndReleaseBetweenAndLengthBetween(1, defaultYearMin, defaultYearMax, defaultLengthMin, defaultLengthMax);
//	        default:
//	            return new ArrayList<>(); // Return an empty list if genre doesn't match any known genres
//	    }
	}
	
//    public List<Movie> getMoviesByPreference(Preference preference) {
//        List<Movie> recommendedMovies = new ArrayList<>();
//        
//        // Example: Get drama movies released between 2000 and 2022 with a length between 90 and 120 minutes
//        if (preference.getDrama() > 0) {
//            List<Movie> dramaMovies = movieRepository.findByGenreDramaAndReleaseBetweenAndLengthBetween(
//                1, preference.getYear_min(), preference.getYear_max(), preference.getLength_min(), preference.getLength_max());
//            recommendedMovies.addAll(dramaMovies);
//        }
//        
//        if (preference.getAction() > 0) {
//            List<Movie> actionMovies = movieRepository.findByGenreActionAndReleaseBetweenAndLengthBetween(
//                1, preference.getYear_min(), preference.getYear_max(), preference.getLength_min(), preference.getLength_max());
//            recommendedMovies.addAll(actionMovies);
//        }
//        
//        if (preference.getRomance() > 0) {
//            List<Movie> romanceMovies = movieRepository.findByGenreRomanceAndReleaseBetweenAndLengthBetween(
//                1, preference.getYear_min(), preference.getYear_max(), preference.getLength_min(), preference.getLength_max());
//            recommendedMovies.addAll(romanceMovies);
//        }
//        
//        if (preference.getComedy() > 0) {
//            List<Movie> comedyMovies = movieRepository.findByGenreDramaAndReleaseBetweenAndLengthBetween(
//                1, preference.getYear_min(), preference.getYear_max(), preference.getLength_min(), preference.getLength_max());
//            recommendedMovies.addAll(comedyMovies);
//        }
//        
//        if (preference.getFantasy() > 0) {
//            List<Movie> fantasyMovies = movieRepository.findByGenreDramaAndReleaseBetweenAndLengthBetween(
//                1, preference.getYear_min(), preference.getYear_max(), preference.getLength_min(), preference.getLength_max());
//            recommendedMovies.addAll(fantasyMovies);
//        }
//        
//        if (preference.getSf() > 0) {
//            List<Movie> sfMovies = movieRepository.findByGenreDramaAndReleaseBetweenAndLengthBetween(
//                1, preference.getYear_min(), preference.getYear_max(), preference.getLength_min(), preference.getLength_max());
//            recommendedMovies.addAll(sfMovies);
//        }
//        
//        if (preference.getThriller() > 0) {
//            List<Movie> thrillerMovies = movieRepository.findByGenreDramaAndReleaseBetweenAndLengthBetween(
//                1, preference.getYear_min(), preference.getYear_max(), preference.getLength_min(), preference.getLength_max());
//            recommendedMovies.addAll(thrillerMovies);
//        }
//        
//        if (preference.getAdventure() > 0) {
//            List<Movie> adventureMovies = movieRepository.findByGenreDramaAndReleaseBetweenAndLengthBetween(
//                1, preference.getYear_min(), preference.getYear_max(), preference.getLength_min(), preference.getLength_max());
//            recommendedMovies.addAll(adventureMovies);
//        }
//        
//        if (preference.getDocumentary() > 0) {
//            List<Movie> documentaryMovies = movieRepository.findByGenreDramaAndReleaseBetweenAndLengthBetween(
//                1, preference.getYear_min(), preference.getYear_max(), preference.getLength_min(), preference.getLength_max());
//            recommendedMovies.addAll(documentaryMovies);
//        }
//        
//        if (preference.getAnimation() > 0) {
//            List<Movie> animationMovies = movieRepository.findByGenreDramaAndReleaseBetweenAndLengthBetween(
//                1, preference.getYear_min(), preference.getYear_max(), preference.getLength_min(), preference.getLength_max());
//            recommendedMovies.addAll(animationMovies);
//        }
//        
//        if (preference.getHorror() > 0) {
//            List<Movie> horrorMovies = movieRepository.findByGenreDramaAndReleaseBetweenAndLengthBetween(
//                1, preference.getYear_min(), preference.getYear_max(), preference.getLength_min(), preference.getLength_max());
//            recommendedMovies.addAll(horrorMovies);
//        }
//        
//        if (preference.getCrime() > 0) {
//            List<Movie> crimeMovies = movieRepository.findByGenreDramaAndReleaseBetweenAndLengthBetween(
//                1, preference.getYear_min(), preference.getYear_max(), preference.getLength_min(), preference.getLength_max());
//            recommendedMovies.addAll(crimeMovies);
//        }
//        
//        if (preference.getMystery() > 0) {
//            List<Movie> mysteryMovies = movieRepository.findByGenreDramaAndReleaseBetweenAndLengthBetween(
//                1, preference.getYear_min(), preference.getYear_max(), preference.getLength_min(), preference.getLength_max());
//            recommendedMovies.addAll(mysteryMovies);
//        }
//        
//        if (preference.getHistorical() > 0) {
//            List<Movie> historicalMovies = movieRepository.findByGenreDramaAndReleaseBetweenAndLengthBetween(
//                1, preference.getYear_min(), preference.getYear_max(), preference.getLength_min(), preference.getLength_max());
//            recommendedMovies.addAll(historicalMovies);
//        }
//        
//        if (preference.getMusical() > 0) {
//            List<Movie> musicalMovies = movieRepository.findByGenreDramaAndReleaseBetweenAndLengthBetween(
//                1, preference.getYear_min(), preference.getYear_max(), preference.getLength_min(), preference.getLength_max());
//            recommendedMovies.addAll(musicalMovies);
//        }
//
//        return recommendedMovies;
//    }
