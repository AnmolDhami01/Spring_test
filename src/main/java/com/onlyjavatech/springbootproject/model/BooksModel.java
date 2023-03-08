package com.onlyjavatech.springbootproject.model;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "books")
public class BooksModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private String genre;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JsonManagedReference
	private AuthourModel author;

	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private LocalDateTime createdAt;

	public Integer getId() {
		return id;
	}

	public AuthourModel getAuthor() {
		return author;
	}

	public void setAuthor(AuthourModel author) {
		this.author = author;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "BooksModel [id=" + id + ", name=" + name + ", genre=" + genre + ", author=" + author + ", createdAt="
				+ createdAt + "]";
	}

}
