package com.example.modle;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(name = "User_FirstName",nullable = false)
	private String firstName;
	@Column(name = "User_LastName",nullable = false)
	private String lastName;
	@Column(name = "UserName",nullable = false, unique = true)
	private String userName;
	@ManyToMany(mappedBy = "likes", fetch = FetchType.LAZY)
	private List<Post> LikedPosts;
	public User() {
	}

	

	public User(int id, String firstName, String lastName, String userName, List<Post> likedPosts) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		LikedPosts = likedPosts;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}



	public List<Post> getLikedPosts() {
		return LikedPosts;
	}



	public void setLikedPosts(List<Post> likedPosts) {
		LikedPosts = likedPosts;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", LikedPosts=" + LikedPosts.toString() + "]";
	}

	

	

}
