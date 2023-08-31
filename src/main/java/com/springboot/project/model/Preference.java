package com.springboot.project.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "preference")
public class Preference {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int drama;
	private int action;
	private int romance;
	private int comedy;
	private int fantasy;
	private int sf;
	private int thriller;
	private int adventure;
	private int documentary;
	private int animation;
	private int horror;
	private int crime;
	private int mystery;
	private int historical;
	private int musical;
	
	private int year_min;
	private int year_max;
	
	private int length_min;
	private int length_max;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="preferences")
	private Set<User> users = new HashSet<>();
	
	public Preference() {
		
	}

	public Preference(int drama, int action, int romance, int comedy, int fantasy, int sf,
			int thriller, int adventure, int documentary, int animation, int horror, int crime,
			int mystery, int historical, int musical, int year_min, int year_max, int length_min,
			int length_max) {
		super();
		this.drama = drama;
		this.action = action;
		this.romance = romance;
		this.comedy = comedy;
		this.fantasy = fantasy;
		this.sf = sf;
		this.thriller = thriller;
		this.adventure = adventure;
		this.documentary = documentary;
		this.animation = animation;
		this.horror = horror;
		this.crime = crime;
		this.mystery = mystery;
		this.historical = historical;
		this.musical = musical;
		this.year_min = year_min;
		this.year_max = year_max;
		this.length_min = length_min;
		this.length_max = length_max;
	}


	public Preference(int drama, int action, int romance, int comedy, int fantasy, int sf, int thriller, int adventure,
			int documentary, int animation, int horror, int crime, int mystery, int historical, int musical,
			int year_min, int year_max, int length_min, int length_max, Set<User> users) {
		super();
		this.drama = drama;
		this.action = action;
		this.romance = romance;
		this.comedy = comedy;
		this.fantasy = fantasy;
		this.sf = sf;
		this.thriller = thriller;
		this.adventure = adventure;
		this.documentary = documentary;
		this.animation = animation;
		this.horror = horror;
		this.crime = crime;
		this.mystery = mystery;
		this.historical = historical;
		this.musical = musical;
		this.year_min = year_min;
		this.year_max = year_max;
		this.length_min = length_min;
		this.length_max = length_max;
		this.users = users;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getDrama() {
		return drama;
	}
	
	public void setDrama(int drama) {
		this.drama = drama;
	}
	
	public int getAction() {
		return action;
	}
	
	public void setAction(int action) {
		this.action = action;
	}
	
	public int getRomance() {
		return romance;
	}
	
	public void setRomance(int romance) {
		this.romance = romance;
	}
	
	public int getComedy() {
		return comedy;
	}
	
	public void setComedy(int comedy) {
		this.comedy = comedy;
	}
	
	public int getFantasy() {
		return fantasy;
	}
	
	public void setFantasy(int fantasy) {
		this.fantasy = fantasy;
	}
	
	public int getSf() {
		return sf;
	}
	
	public void setSf(int sf) {
		this.sf = sf;
	}
	
	public int getThriller() {
		return thriller;
	}
	
	public void setThriller(int thriller) {
		this.thriller = thriller;
	}
	
	public int getAdventure() {
		return adventure;
	}
	
	public void setAdventure(int adventure) {
		this.adventure = adventure;
	}
	
	public int getDocumentary() {
		return documentary;
	}
	
	public void setDocumentary(int documentary) {
		this.documentary = documentary;
	}
	
	public int getAnimation() {
		return animation;
	}
	
	public void setAnimation(int animation) {
		this.animation = animation;
	}
	
	public int getHorror() {
		return horror;
	}
	
	public void setHorror(int horror) {
		this.horror = horror;
	}
	
	public int getCrime() {
		return crime;
	}
	
	public void setCrime(int crime) {
		this.crime = crime;
	}
	
	public int getMystery() {
		return mystery;
	}
	
	public void setMystery(int mystery) {
		this.mystery = mystery;
	}
	
	public int getHistorical() {
		return historical;
	}
	
	public void setHistorical(int historical) {
		this.historical = historical;
	}
	
	public int getMusical() {
		return musical;
	}
	
	public void setMusical(int musical) {
		this.musical = musical;
	}
	
	public int getYear_min() {
		return year_min;
	}
	
	public void setYear_min(int year_min) {
		this.year_min = year_min;
	}
	
	public int getYear_max() {
		return year_max;
	}
	
	public void setYear_max(int year_max) {
		this.year_max = year_max;
	}
	
	public int getLength_min() {
		return length_min;
	}
	
	public void setLength_min(int length_min) {
		this.length_min = length_min;
	}
	
	public int getLength_max() {
		return length_max;
	}
	
	public void setLength_max(int length_max) {
		this.length_max = length_max;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
