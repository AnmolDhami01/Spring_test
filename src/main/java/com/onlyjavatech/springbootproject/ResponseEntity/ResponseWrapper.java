package com.onlyjavatech.springbootproject.ResponseEntity;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.onlyjavatech.springbootproject.model.AuthourModel;
import com.onlyjavatech.springbootproject.model.BooksModel;
import com.onlyjavatech.springbootproject.model.Students;

@SuppressWarnings("deprecation")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseWrapper implements Serializable {

	/**
	 * 
	 */

	StatusDescription statusDescriptions;
	Students studentt;
	List<Students> studentts;
	List<BooksModel> bookss;
	BooksModel bookk;
	AuthourModel authourmodel;
	
	HttpStatus httpStatus;

	public BooksModel getBookk() {
		return bookk;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public AuthourModel getAuthourmodel() {
		return authourmodel;
	}

	public void setAuthourmodel(AuthourModel authourmodel) {
		this.authourmodel = authourmodel;
	}

	public void setBookk(BooksModel bookk) {
		this.bookk = bookk;
	}

	public List<BooksModel> getBookss() {
		return bookss;
	}

	public void setBookss(List<BooksModel> bookss) {
		this.bookss = bookss;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "ResponseWrapper [statusDescriptions=" + statusDescriptions + ", studentt=" + studentt + ", studentts="
				+ (studentts != null ? studentts.subList(0, Math.min(studentts.size(), maxLen)) : null) + ", bookss="
				+ (bookss != null ? bookss.subList(0, Math.min(bookss.size(), maxLen)) : null) + ", bookk=" + bookk
				+ "]";
	}

	public List<Students> getStudentts() {
		return studentts;
	}

	public void setStudentts(List<Students> studentts) {
		this.studentts = studentts;
	}

	public Students getStudentt() {
		return studentt;
	}

	public void setStudentt(Students studentt) {
		this.studentt = studentt;
	}

	public StatusDescription getStatusDescriptions() {
		return statusDescriptions;
	}

	public void setStatusDescriptions(StatusDescription statusDescriptions) {
		this.statusDescriptions = statusDescriptions;
	}

}
