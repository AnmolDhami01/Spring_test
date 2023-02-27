package com.onlyjavatech.springbootproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlyjavatech.springbootproject.RequestWrapper.BookRequestWrapper;
import com.onlyjavatech.springbootproject.ResponseEntity.ResponseWrapper;
import com.onlyjavatech.springbootproject.ResponseEntity.StatusDescription;
import com.onlyjavatech.springbootproject.model.BooksModel;
import com.onlyjavatech.springbootproject.model.Students;
import com.onlyjavatech.springbootproject.servives.BookService;

@RestController
@RequestMapping("books/v1/")
@CrossOrigin(value = "*")
public class BookController {

	@Autowired
	BookService bookservice;

	@GetMapping("getAllBooks")
	public ResponseEntity<ResponseWrapper> getAllBooks() {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();

		responseWrapper1.setStatusDescriptions(statusDescription1);
		responseWrapper1 = this.bookservice.getAllBooks();
		return new ResponseEntity<>(responseWrapper1, HttpStatus.OK);
	}

	@PostMapping("addBook")
	public ResponseEntity<ResponseWrapper> addBook(@RequestBody BooksModel str) {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();
		try {

			responseWrapper1.setStatusDescriptions(statusDescription1);
			responseWrapper1 = this.bookservice.addBook(str);

		} catch (Exception e) {
			e.printStackTrace();
			statusDescription1.setStatusCode(500);
			statusDescription1.setStatusDescription("Internal Server Error");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return new ResponseEntity<>(responseWrapper1, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(responseWrapper1, HttpStatus.OK);
	}

	@PostMapping("addBookWtihAutohourId")
	public ResponseEntity<ResponseWrapper> addBookWtihAutohourId(@RequestBody BookRequestWrapper boook) {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();

		responseWrapper1.setStatusDescriptions(statusDescription1);
		responseWrapper1 = this.bookservice.addBookWtihAutohourId(boook);

		return new ResponseEntity<>(responseWrapper1, responseWrapper1.getHttpStatus());
	}

}
