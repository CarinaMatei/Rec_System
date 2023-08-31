package com.springboot.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "movie_name", nullable = false)
	private String movie_name;
	
	private int genre_drama;
	private int genre_action;
	private int genre_romance;
	private int genre_comedy;
	private int genre_fantasy;
	private int genre_sf;
	private int genre_thriller;
	private int genre_adventure;
	private int genre_documentary;
	private int genre_animation;
	private int genre_horror;
	private int genre_crime;
	private int genre_mystery;
	private int genre_historical;
	private int genre_musical;
	
	private int release;	
	private int length;	
	private double rating;	
	private String actors;	
	private String description;
	
	@Lob
	@Column(name = "image", length = 1048576)
	private byte[] image;
	
    @Transient
    private String imageBase64;
	
	public Movie() {
		
	}

	public Movie(String movie_name, int genre_drama, int genre_action, int genre_romance, int genre_comedy,
			int genre_fantasy, int genre_sf, int genre_thriller, int genre_adventure, int genre_documentary,
			int genre_animation, int genre_horror, int genre_crime, int genre_mystery, int genre_historical,
			int genre_musical, int release, int length, double rating, String actors, String description) {
		super();
		this.movie_name = movie_name;
		this.genre_drama = genre_drama;
		this.genre_action = genre_action;
		this.genre_romance = genre_romance;
		this.genre_comedy = genre_comedy;
		this.genre_fantasy = genre_fantasy;
		this.genre_sf = genre_sf;
		this.genre_thriller = genre_thriller;
		this.genre_adventure = genre_adventure;
		this.genre_documentary = genre_documentary;
		this.genre_animation = genre_animation;
		this.genre_horror = genre_horror;
		this.genre_crime = genre_crime;
		this.genre_mystery = genre_mystery;
		this.genre_historical = genre_historical;
		this.genre_musical = genre_musical;
		this.release = release;
		this.length = length;
		this.rating = rating;
		this.actors = actors;
		this.description = description;
	}
	
	public Movie(String movie_name, int genre_drama, int genre_action, int genre_romance, int genre_comedy,
			int genre_fantasy, int genre_sf, int genre_thriller, int genre_adventure, int genre_documentary,
			int genre_animation, int genre_horror, int genre_crime, int genre_mystery, int genre_historical,
			int genre_musical, int release, int length, double rating, String actors, String description,
			byte[] image) {
		super();
		this.movie_name = movie_name;
		this.genre_drama = genre_drama;
		this.genre_action = genre_action;
		this.genre_romance = genre_romance;
		this.genre_comedy = genre_comedy;
		this.genre_fantasy = genre_fantasy;
		this.genre_sf = genre_sf;
		this.genre_thriller = genre_thriller;
		this.genre_adventure = genre_adventure;
		this.genre_documentary = genre_documentary;
		this.genre_animation = genre_animation;
		this.genre_horror = genre_horror;
		this.genre_crime = genre_crime;
		this.genre_mystery = genre_mystery;
		this.genre_historical = genre_historical;
		this.genre_musical = genre_musical;
		this.release = release;
		this.length = length;
		this.rating = rating;
		this.actors = actors;
		this.description = description;
		this.image = image;
	}

	public Movie(String movie_name, int genre_drama, int genre_action, int genre_romance, int genre_comedy,
			int genre_fantasy, int genre_sf, int genre_thriller, int genre_adventure, int genre_documentary,
			int genre_animation, int genre_horror, int genre_crime, int genre_mystery, int genre_historical,
			int genre_musical, int release, int length, double rating, String actors, String description, byte[] image,
			String imageBase64) {
		super();
		this.movie_name = movie_name;
		this.genre_drama = genre_drama;
		this.genre_action = genre_action;
		this.genre_romance = genre_romance;
		this.genre_comedy = genre_comedy;
		this.genre_fantasy = genre_fantasy;
		this.genre_sf = genre_sf;
		this.genre_thriller = genre_thriller;
		this.genre_adventure = genre_adventure;
		this.genre_documentary = genre_documentary;
		this.genre_animation = genre_animation;
		this.genre_horror = genre_horror;
		this.genre_crime = genre_crime;
		this.genre_mystery = genre_mystery;
		this.genre_historical = genre_historical;
		this.genre_musical = genre_musical;
		this.release = release;
		this.length = length;
		this.rating = rating;
		this.actors = actors;
		this.description = description;
		this.image = image;
		this.imageBase64 = imageBase64;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMovie_name() {
		return movie_name;
	}
	
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	
	public int getGenre_drama() {
		return genre_drama;
	}
	
	public void setGenre_drama(int genre_drama) {
		this.genre_drama = genre_drama;
	}
	
	public int getGenre_action() {
		return genre_action;
	}
	
	public void setGenre_action(int genre_action) {
		this.genre_action = genre_action;
	}
	
	public int getGenre_romance() {
		return genre_romance;
	}
	
	public void setGenre_romance(int genre_romance) {
		this.genre_romance = genre_romance;
	}
	
	public int getGenre_comedy() {
		return genre_comedy;
	}
	
	public void setGenre_comedy(int genre_comedy) {
		this.genre_comedy = genre_comedy;
	}
	
	public int getGenre_fantasy() {
		return genre_fantasy;
	}
	
	public void setGenre_fantasy(int genre_fantasy) {
		this.genre_fantasy = genre_fantasy;
	}
	
	public int getGenre_sf() {
		return genre_sf;
	}
	
	public void setGenre_sf(int genre_sf) {
		this.genre_sf = genre_sf;
	}
	
	public int getGenre_thriller() {
		return genre_thriller;
	}
	
	public void setGenre_thriller(int genre_thriller) {
		this.genre_thriller = genre_thriller;
	}
	
	public int getGenre_adventure() {
		return genre_adventure;
	}
	
	public void setGenre_adventure(int genre_adventure) {
		this.genre_adventure = genre_adventure;
	}
	
	public int getGenre_documentary() {
		return genre_documentary;
	}
	
	public void setGenre_documentary(int genre_documentary) {
		this.genre_documentary = genre_documentary;
	}
	
	public int getGenre_animation() {
		return genre_animation;
	}
	
	public void setGenre_animation(int genre_animation) {
		this.genre_animation = genre_animation;
	}
	
	public int getGenre_horror() {
		return genre_horror;
	}
	
	public void setGenre_horror(int genre_horror) {
		this.genre_horror = genre_horror;
	}
	
	public int getGenre_crime() {
		return genre_crime;
	}
	
	public void setGenre_crime(int genre_crime) {
		this.genre_crime = genre_crime;
	}
	
	public int getGenre_mystery() {
		return genre_mystery;
	}
	
	public void setGenre_mystery(int genre_mystery) {
		this.genre_mystery = genre_mystery;
	}
	
	public int getGenre_historical() {
		return genre_historical;
	}
	
	public void setGenre_historical(int genre_historical) {
		this.genre_historical = genre_historical;
	}
	
	public int getGenre_musical() {
		return genre_musical;
	}
	
	public void setGenre_musical(int genre_musical) {
		this.genre_musical = genre_musical;
	}
	
	public int getRelease() {
		return release;
	}
	
	public void setRelease(int release) {
		this.release = release;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public double getRating() {
		return rating;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public String getActors() {
		return actors;
	}
	
	public void setActors(String actors) {
		this.actors = actors;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}

	
}
