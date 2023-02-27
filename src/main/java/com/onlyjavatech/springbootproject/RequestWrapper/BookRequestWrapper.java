package com.onlyjavatech.springbootproject.RequestWrapper;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.onlyjavatech.springbootproject.model.BooksModel;

@SuppressWarnings("deprecation")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BookRequestWrapper implements Serializable {

	List<BooksModel> bookss;
	BooksModel bookk;
	
	Integer authourId;
	String name;
	String genre;

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

	

	public List<BooksModel> getBookss() {
		return bookss;
	}

	public void setBookss(List<BooksModel> bookss) {
		this.bookss = bookss;
	}

	public BooksModel getBookk() {
		return bookk;
	}

	

	

	

	@Override
	public String toString() {
		return "BookRequestWrapper [bookss=" + bookss + ", bookk=" + bookk + ", authourId=" + authourId + ", name="
				+ name + ", genre=" + genre + "]";
	}

	public Integer getAuthourId() {
		return authourId;
	}

	public void setAuthourId(Integer authourId) {
		this.authourId = authourId;
	}

	public void setBookk(BooksModel bookk) {
		this.bookk = bookk;
	}

}
