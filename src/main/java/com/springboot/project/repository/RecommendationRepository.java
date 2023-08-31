package com.springboot.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.project.model.Movie;


@Repository
public interface RecommendationRepository extends JpaRepository<Movie, Long> {
	
    // Fetch movies based on genre, release year, and length preferences
	@Query("SELECT m FROM Movie m WHERE " +
		       "(m.genre_drama >= :dramaThreshold OR " +
		       "m.genre_action >= :actionThreshold OR " +
		       "m.genre_romance >= :romanceThreshold OR " +
		       "m.genre_comedy >= :comedyThreshold OR " +
		       "m.genre_fantasy >= :fantasyThreshold OR " +
		       "m.genre_sf >= :sfThreshold OR " +
		       "m.genre_thriller >= :thrillerThreshold OR " +
		       "m.genre_adventure >= :adventureThreshold OR " +
		       "m.genre_documentary >= :documentaryThreshold OR " +
		       "m.genre_animation >= :animationThreshold OR " +
		       "m.genre_horror >= :horrorThreshold OR " +
		       "m.genre_crime >= :crimeThreshold OR " +
		       "m.genre_mystery >= :mysteryThreshold OR " +
		       "m.genre_historical >= :historicalThreshold OR " +
		       "m.genre_musical >= :musicalThreshold) " +
		       "AND m.release BETWEEN :releaseStart AND :releaseEnd " +
		       "AND m.length BETWEEN :lengthStart AND :lengthEnd")
		List<Movie> findMoviesByPreferences(
		    @Param("dramaThreshold") int dramaThreshold, 
		    @Param("actionThreshold") int actionThreshold,
		    @Param("romanceThreshold") int romanceThreshold,
		    @Param("comedyThreshold") int comedyThreshold,
		    @Param("fantasyThreshold") int fantasyThreshold,
		    @Param("sfThreshold") int sfThreshold,
		    @Param("thrillerThreshold") int thrillerThreshold,
		    @Param("adventureThreshold") int adventureThreshold,
		    @Param("documentaryThreshold") int documentaryThreshold,
		    @Param("animationThreshold") int animationThreshold,
		    @Param("horrorThreshold") int horrorThreshold,
		    @Param("crimeThreshold") int crimeThreshold,
		    @Param("mysteryThreshold") int mysteryThreshold,
		    @Param("historicalThreshold") int historicalThreshold,
		    @Param("musicalThreshold") int musicalThreshold,
		    @Param("releaseStart") int releaseStart, 
		    @Param("releaseEnd") int releaseEnd, 
		    @Param("lengthStart") int lengthStart, 
		    @Param("lengthEnd") int lengthEnd
		);

}
