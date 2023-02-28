package com.onlyjavatech.springbootproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.onlyjavatech.springbootproject.ResponseEntity.ResponseWrapper;
import com.onlyjavatech.springbootproject.ResponseEntity.StatusDescription;
import com.onlyjavatech.springbootproject.helpers.FileUploadHelper;
import com.onlyjavatech.springbootproject.model.BooksModel;
import com.onlyjavatech.springbootproject.servives.BookService;
import com.onlyjavatech.springbootproject.servives.UploadService;

@RestController
@RequestMapping("upload/v1/")
@CrossOrigin(value = "*")
public class FileUploadController {

	@Autowired
	UploadService uploadService;

	@PostMapping("uploadFile")
	public ResponseEntity<ResponseWrapper> uploadFile(@RequestParam("file") MultipartFile file) {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();

		responseWrapper1.setStatusDescriptions(statusDescription1);
		responseWrapper1 = this.uploadService.uploadFile(file);

		return new ResponseEntity<>(responseWrapper1, HttpStatus.OK);
	}

}
