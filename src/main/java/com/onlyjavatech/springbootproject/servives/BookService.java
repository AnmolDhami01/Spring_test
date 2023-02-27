package com.onlyjavatech.springbootproject.servives;

import org.springframework.web.bind.annotation.RequestBody;

import com.onlyjavatech.springbootproject.RequestWrapper.BookRequestWrapper;
import com.onlyjavatech.springbootproject.ResponseEntity.ResponseWrapper;
import com.onlyjavatech.springbootproject.model.BooksModel;



public interface BookService {
	
	ResponseWrapper getAllBooks();
	ResponseWrapper addBook(@RequestBody BooksModel bookk);
	ResponseWrapper addBookWtihAutohourId(@RequestBody BookRequestWrapper boook);
	
	

	

}
