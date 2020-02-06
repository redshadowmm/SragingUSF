package com.example.modle;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "Message",nullable = false,updatable = true,length = 2500)
	private String message;
	
	@ManyToOne
	private User poster;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Likes", joinColumns = { @JoinColumn(name = "Post_id") }, inverseJoinColumns = {
			@JoinColumn(name = "users_id") })
	private List<User> likes;
	
	public Post() {
	}

	public Post(int id, String message, User poster, List<User> likes) {
		super();
		this.id = id;
		this.message = message;
		this.poster = poster;
		this.likes = likes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getPoster() {
		return poster;
	}

	public void setPoster(User poster) {
		this.poster = poster;
	}

	public List<User> getLikes() {
		return likes;
	}

	public void setLikes(List<User> likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", message=" + message + ", poster=" + poster + ", likes=" + likes.toString()
				+ "]";
	}
	
	
	
	
	

}
