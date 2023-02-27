package com.onlyjavatech.springbootproject.serviveImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.onlyjavatech.springbootproject.ResponseEntity.ResponseWrapper;
import com.onlyjavatech.springbootproject.ResponseEntity.StatusDescription;
import com.onlyjavatech.springbootproject.model.BooksModel;
import com.onlyjavatech.springbootproject.model.repo.BooksRepo;
import com.onlyjavatech.springbootproject.servives.BookService;

@Service
public class BookServiveImpl implements BookService {

	@Autowired
	BooksRepo booksRepo;

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
					|| (bookk.getGenre() == "" && bookk.getGenre() == null)
					|| (bookk.getAuthor().getFirstName() == "" && bookk.getAuthor().getFirstName() == null)
					|| (bookk.getAuthor().getLastName() == "")
					|| (bookk.getAuthor().getLaungauge() == "" && bookk.getAuthor().getLaungauge() == null)) {
				statusDescription1.setStatusCode(400);
				statusDescription1.setStatusDescription("Bad Request");
				responseWrapper1.setStatusDescriptions(statusDescription1);

			} else {

				BooksModel save = this.booksRepo.save(bookk);

				responseWrapper1.setBookk(bookk);
				statusDescription1.setStatusCode(200);
				statusDescription1.setStatusDescription("Success");
				responseWrapper1.setStatusDescriptions(statusDescription1);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return responseWrapper1;
	}

}
