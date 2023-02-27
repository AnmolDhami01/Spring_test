package com.onlyjavatech.springbootproject.serviveImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.onlyjavatech.springbootproject.RequestWrapper.BookRequestWrapper;
import com.onlyjavatech.springbootproject.ResponseEntity.ResponseWrapper;
import com.onlyjavatech.springbootproject.ResponseEntity.StatusDescription;
import com.onlyjavatech.springbootproject.model.AuthourModel;
import com.onlyjavatech.springbootproject.model.BooksModel;
import com.onlyjavatech.springbootproject.model.repo.AuthourRepo;
import com.onlyjavatech.springbootproject.model.repo.BooksRepo;
import com.onlyjavatech.springbootproject.servives.BookService;

@Service
public class BookServiveImpl implements BookService {

	@Autowired
	BooksRepo booksRepo;

	@Autowired
	AuthourRepo authourRepo;

	public ResponseWrapper getAllBooks() {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();
		responseWrapper1.setStatusDescriptions(statusDescription1);
		try {

			List<BooksModel> findAll = booksRepo.findAll();

			if (findAll.size() == 0) {
				statusDescription1.setStatusCode(220);
				statusDescription1.setStatusDescription("No Data Found");

			} else {

				responseWrapper1.setBookss(findAll);
				statusDescription1.setStatusCode(200);
				statusDescription1.setStatusDescription("Success");
			}

		} catch (Exception e) {
			e.printStackTrace();
			statusDescription1.setStatusCode(500);
			statusDescription1.setStatusDescription("Internal Server Error");

		}
		return responseWrapper1;
	}

	public ResponseWrapper addBook(@RequestBody BooksModel bookk) {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();
		try {

			if ((bookk.getName() == "" && bookk.getName() == null)
					|| (bookk.getGenre() == "" && bookk.getGenre() == null) || bookk.getAuthor() == null
					|| (bookk.getAuthor().getFirstName() == "" && bookk.getAuthor().getFirstName() == null)
					|| bookk.getAuthor().getLastName() == null || (bookk.getAuthor().getLastName() == "")
					|| (bookk.getAuthor().getLaungauge() == "" && bookk.getAuthor().getLaungauge() == null)) {
				statusDescription1.setStatusCode(400);
				statusDescription1.setStatusDescription("Bad Request");
				

			} else {

				BooksModel save = this.booksRepo.save(bookk);

				responseWrapper1.setBookk(bookk);
				statusDescription1.setStatusCode(200);
				statusDescription1.setStatusDescription("Success");
	
			}
			responseWrapper1.setStatusDescriptions(statusDescription1);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return responseWrapper1;
	}

	public ResponseWrapper addBookWtihAutohourId(@RequestBody BookRequestWrapper boook) {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();
		BooksModel booksModel = new BooksModel();
		System.out.println(boook);
		try {

			if ((boook.getName() == "" && boook.getName() == null)
					|| (boook.getGenre() == "" && boook.getGenre() == null) || boook.getAuthourId() == null) {
				statusDescription1.setStatusCode(400);
				statusDescription1.setStatusDescription("Bad Request");
				responseWrapper1.setStatusDescriptions(statusDescription1);
				responseWrapper1.setHttpStatus(HttpStatus.BAD_REQUEST);

			} else {

				Optional<AuthourModel> findById = this.authourRepo.findById(boook.getAuthourId());

				if (!findById.isPresent()) {
					statusDescription1.setStatusCode(220);
					statusDescription1.setStatusDescription("No Authour with this Id Found");

				}

				else {

					booksModel.setAuthor(findById.get());
					booksModel.setGenre(boook.getGenre());
					booksModel.setName(boook.getName());

					BooksModel save = this.booksRepo.save(booksModel);

					responseWrapper1.setBookk(booksModel);
					statusDescription1.setStatusCode(200);
					statusDescription1.setStatusDescription("Success");
				}
			}
			responseWrapper1.setStatusDescriptions(statusDescription1);
			responseWrapper1.setHttpStatus(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			statusDescription1.setStatusCode(500);
			statusDescription1.setStatusDescription("Internal Server Error");
			responseWrapper1.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			responseWrapper1.setStatusDescriptions(statusDescription1);

		}
		return responseWrapper1;
	}

}
