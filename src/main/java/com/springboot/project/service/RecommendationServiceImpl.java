package com.springboot.project.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.model.Movie;
import com.springboot.project.model.Preference;
import com.springboot.project.model.User;
import com.springboot.project.repository.MovieRepository;
import com.springboot.project.repository.PreferenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    
    @Autowired
    private PreferenceRepository preferenceRepository;

    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private UserService userService;
    
    private static final List<String> ALL_GENRES = Arrays.asList(
            "drama", "action", "romance", "comedy", "fantasy", "sf", "thriller", 
            "adventure", "documentary", "animation", "horror", "crime", 
            "mystery", "historical", "musical"
        );
    
    private static final Logger logger = LoggerFactory.getLogger(RecommendationServiceImpl.class);
    
    @Override
    public List<Movie> generateCollaborativeRecommendations(User user, List<User> friends) {
        // Calculate dynamic thresholds
        Map<String, Double> genreThresholds = calculateDynamicThresholds(user, friends);

        // Fetch movies based on the dynamic genre thresholds
        List<Movie> recommendedMovies = getMoviesByGenreThresholds(genreThresholds);

        // Remove duplicates and return the list
        return recommendedMovies.stream().distinct().collect(Collectors.toList());
    }
    
 // Fetch the Preference object associated with a given User
    public Preference getPreference(User user) {
        List<Preference> preferences = preferenceRepository.findByUsers_Id(user.getId());
        return preferences.isEmpty() ? null : preferences.get(0);
    }

    // Return a list of all genres
    public List<String> getAllGenres() {
        return ALL_GENRES;
    }

    // Fetch movies based on a given genre
    public List<Movie> getMoviesByGenreThresholds(Map<String, Double> genreThresholds) {
        return movieRepository.findByGenre(
            (int) (genreThresholds.getOrDefault("drama", 0.0) * 100),
            (int) (genreThresholds.getOrDefault("action", 0.0) * 100),
            (int) (genreThresholds.getOrDefault("romance", 0.0) * 100),
            (int) (genreThresholds.getOrDefault("comedy", 0.0) * 100),
            (int) (genreThresholds.getOrDefault("fantasy", 0.0) * 100),
            (int) (genreThresholds.getOrDefault("sf", 0.0) * 100),
            (int) (genreThresholds.getOrDefault("thriller", 0.0) * 100),
            (int) (genreThresholds.getOrDefault("adventure", 0.0) * 100),
            (int) (genreThresholds.getOrDefault("documentary", 0.0) * 100),
            (int) (genreThresholds.getOrDefault("animation", 0.0) * 100),
            (int) (genreThresholds.getOrDefault("horror", 0.0) * 100),
            (int) (genreThresholds.getOrDefault("crime", 0.0) * 100),
            (int) (genreThresholds.getOrDefault("mystery", 0.0) * 100),
            (int) (genreThresholds.getOrDefault("historical", 0.0) * 100),
            (int) (genreThresholds.getOrDefault("musical", 0.0) * 100)
        );
    }
    
    private double getGenrePreference(Preference userPref, String genre) {
        double preferenceValue = 0.0;
        switch (genre.toLowerCase()) {
            case "drama":
                preferenceValue = userPref.getDrama();
                break;
            case "action":
                preferenceValue = userPref.getAction();
                break;
            case "romance":
                preferenceValue = userPref.getRomance();
                break;
            case "comedy":
                preferenceValue = userPref.getComedy();
                break;
            case "fantasy":
                preferenceValue = userPref.getFantasy();
                break;
            case "sf":
                preferenceValue = userPref.getSf();
                break;
            case "thriller":
                preferenceValue = userPref.getThriller();
                break;
            case "adventure":
                preferenceValue = userPref.getAdventure();
                break;
            case "documentary":
                preferenceValue = userPref.getDocumentary();
                break;
            case "animation":
                preferenceValue = userPref.getAnimation();
                break;
            case "horror":
                preferenceValue = userPref.getHorror();
                break;
            case "crime":
                preferenceValue = userPref.getCrime();
                break;
            case "mystery":
                preferenceValue = userPref.getMystery();
                break;
            case "historical":
                preferenceValue = userPref.getHistorical();
                break;
            case "musical":
                preferenceValue = userPref.getMusical();
                break;
            default:
                return 0.0; // Return 0.0 if the genre doesn't match any known genres
        }
        return preferenceValue / 100.0; // Normalize the value
    }
    
    //cosine similarity
    private double computeSimilarity(Preference userPref, Preference friendPref) {
        if (userPref == null || friendPref == null) {
            return 0.0; // Return default similarity value if either preference is null
        }
        // Convert preferences to vectors
        double[] userVector = {
            userPref.getDrama() / 100.0, 
            userPref.getAction() / 100.0, 
            userPref.getRomance() / 100.0, 
            userPref.getComedy() / 100.0, 
            userPref.getFantasy() / 100.0, 
            userPref.getSf() / 100.0, 
            userPref.getThriller() / 100.0, 
            userPref.getAdventure() / 100.0, 
            userPref.getDocumentary() / 100.0, 
            userPref.getAnimation() / 100.0, 
            userPref.getHorror() / 100.0, 
            userPref.getCrime() / 100.0, 
            userPref.getMystery() / 100.0, 
            userPref.getHistorical() / 100.0, 
            userPref.getMusical() / 100.0
        };

        double[] friendVector = {
            friendPref.getDrama() / 100.0, 
            friendPref.getAction() / 100.0, 
            friendPref.getRomance() / 100.0, 
            friendPref.getComedy() / 100.0, 
            friendPref.getFantasy() / 100.0, 
            friendPref.getSf() / 100.0, 
            friendPref.getThriller() / 100.0, 
            friendPref.getAdventure() / 100.0, 
            friendPref.getDocumentary() / 100.0, 
            friendPref.getAnimation() / 100.0, 
            friendPref.getHorror() / 100.0, 
            friendPref.getCrime() / 100.0, 
            friendPref.getMystery() / 100.0, 
            friendPref.getHistorical() / 100.0, 
            friendPref.getMusical() / 100.0
        };

        // Compute dot product and magnitudes
        double dotProduct = 0.0;
        double userMagnitude = 0.0;
        double friendMagnitude = 0.0;

        for (int i = 0; i < userVector.length; i++) {
            dotProduct += userVector[i] * friendVector[i];
            userMagnitude += Math.pow(userVector[i], 2);
            friendMagnitude += Math.pow(friendVector[i], 2);
        }

        userMagnitude = Math.sqrt(userMagnitude);
        friendMagnitude = Math.sqrt(friendMagnitude);

        // Compute cosine similarity
        if (userMagnitude != 0.0 && friendMagnitude != 0.0) {
            return dotProduct / (userMagnitude * friendMagnitude);
        } else {
            return 0.0; // Handle cases where magnitude is zero to avoid division by zero
        }
    }
    
    public Map<String, Double> calculateDynamicThresholds(User user, List<User> friends) {
        Map<String, Double> genreThresholds = new HashMap<>();
        Preference userPreference = getPreference(user);

        for (String genre : ALL_GENRES) {
            double weightedTotalPreference = 0.0;
            double squaredTotalPreference = 0.0;
            double totalSimilarity = 0.0; // This will be used to normalize the weighted sum

            for (User friend : friends) {
                Preference friendPreference = getPreference(friend);
                if (friendPreference == null) {
                    continue; // Skip if friend preference is null
                }
                
                double similarity = computeSimilarity(userPreference, friendPreference);
                double preferenceValue = getGenrePreference(friendPreference, genre);
                
                weightedTotalPreference += preferenceValue * similarity;
                squaredTotalPreference += Math.pow(preferenceValue, 2);
                totalSimilarity += similarity;
            }

            // Calculate weighted mean
            double meanPreference = totalSimilarity != 0 ? weightedTotalPreference / totalSimilarity : 0;
            double variance = (squaredTotalPreference / friends.size()) - Math.pow(meanPreference, 2);
            double standardDeviation = Math.sqrt(variance);

            // Set threshold as mean plus a fraction (e.g., 0.5) of the standard deviation
            double threshold = meanPreference + 0.5 * standardDeviation;
            genreThresholds.put(genre, threshold);
        }

        return genreThresholds;
    }
    
}
