package com.onlyjavatech.springbootproject.controllers;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.onlyjavatech.springbootproject.RequestWrapper.BookRequestWrapper;
import com.onlyjavatech.springbootproject.ResponseEntity.ResponseWrapper;
import com.onlyjavatech.springbootproject.ResponseEntity.StatusDescription;
import com.onlyjavatech.springbootproject.helpers.ExcelDownloadHelper;
import com.onlyjavatech.springbootproject.model.BooksModel;
import com.onlyjavatech.springbootproject.model.Students;
import com.onlyjavatech.springbootproject.servives.BookService;
import com.onlyjavatech.springbootproject.servives.ExcelDownloadService;
import org.springframework.http.HttpHeaders;

@RestController
@RequestMapping("books/excel/v1/")
@CrossOrigin(value = "*")
public class ExcelDownloadController {

	@Autowired
	BookService bookservice;

	@Autowired
	ExcelDownloadService excelDownloadService;

	@GetMapping("downloadBooksExcel")
	public ResponseEntity<Resource> dataToExcel() {

		String fileName = "booksList.xlsx";

		ByteArrayInputStream dataToExcel = excelDownloadService.dataToExcel();
		InputStreamResource inputStreamResource = new InputStreamResource(dataToExcel);

		ResponseEntity<Resource> body = ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment: filename=" + fileName)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(inputStreamResource);

		return body;

	}

	@PostMapping("ExcelBulkBooksUpload")
	public ResponseEntity<ResponseWrapper> uploadExcel(@RequestParam("file") MultipartFile file) {

		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();
		responseWrapper1.setStatusDescriptions(statusDescription1);
		responseWrapper1 = this.excelDownloadService.saveExcel(file);
		return new ResponseEntity<>(responseWrapper1, HttpStatus.OK);
	}

}
