package com.springboot.project.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	@JoinTable(name="friend",
	 joinColumns=@JoinColumn(name="personId"),
	 inverseJoinColumns=@JoinColumn(name="friendId"))
	private List<User> friends;

	@ManyToMany
	@JoinTable(name="friend",
	 joinColumns=@JoinColumn(name="friendId"),
	 inverseJoinColumns=@JoinColumn(name="personId"))
	private List<User> friendOf;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String email;
	
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_preference",
			joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "preference_id", referencedColumnName = "id")})
	
	private Set<Preference> preferences = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role",
			joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
	
	private Collection<Role> roles;
	
	public User() {
		
	}
	
	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public User(List<User> friends, List<User> friendOf, String firstName, String lastName, String email,
			String password, Collection<Role> roles) {
		super();
		this.friends = friends;
		this.friendOf = friendOf;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public User(List<User> friends, List<User> friendOf, String firstName, String lastName, String email,
			String password, Set<Preference> preferences, Collection<Role> roles) {
		super();
		this.friends = friends;
		this.friendOf = friendOf;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.preferences = preferences;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<User> getFriendOf() {
		return friendOf;
	}

	public void setFriendOf(List<User> friendOf) {
		this.friendOf = friendOf;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(Set<Preference> preferences) {
		this.preferences = preferences;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
}
