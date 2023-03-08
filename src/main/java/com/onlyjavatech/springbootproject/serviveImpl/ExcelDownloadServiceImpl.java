package com.onlyjavatech.springbootproject.serviveImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.onlyjavatech.springbootproject.ResponseEntity.ResponseWrapper;
import com.onlyjavatech.springbootproject.ResponseEntity.StatusDescription;
import com.onlyjavatech.springbootproject.helpers.ExcelDownloadHelper;
import com.onlyjavatech.springbootproject.helpers.FileUploadHelper;
import com.onlyjavatech.springbootproject.model.BooksModel;
import com.onlyjavatech.springbootproject.model.repo.AuthourRepo;
import com.onlyjavatech.springbootproject.model.repo.BooksRepo;

import com.onlyjavatech.springbootproject.servives.ExcelDownloadService;

@Service
public class ExcelDownloadServiceImpl implements ExcelDownloadService {

	@Autowired
	BooksRepo booksRepo;

	@Autowired
	AuthourRepo authourRepo;

	@Override
	public ByteArrayInputStream dataToExcel() {
		List<BooksModel> findAll = booksRepo.findAll();

		ByteArrayInputStream dataToExcel;
		try {
			dataToExcel = ExcelDownloadHelper.dataToExcel(findAll);
			return dataToExcel;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResponseWrapper saveExcel(MultipartFile file) {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();
		try {
			
			if (!ExcelDownloadHelper.checkExcelFormat(file)
					+ file.getContentType() == "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") {
				statusDescription1.setStatusCode(400);
				statusDescription1.setStatusDescription("Only Excel files are supported");
				responseWrapper1.setStatusDescriptions(statusDescription1);
				return responseWrapper1;
			}

			List<BooksModel> convertExcelToListOfBooks = ExcelDownloadHelper
					.convertExcelToListOfBooks(file.getInputStream());
			this.booksRepo.saveAll(convertExcelToListOfBooks);
			statusDescription1.setStatusCode(200);
			statusDescription1.setStatusDescription("Success");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return responseWrapper1;
		} catch (IOException e) {

			e.printStackTrace();
			statusDescription1.setStatusCode(500);
			statusDescription1.setStatusDescription("Something Went Wrong");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return responseWrapper1;
		}

	}

	@Override
	public List<BooksModel> getAllBooks() {
		try {
			return this.booksRepo.findAll();
		} catch (Exception e) {
			return null;
		}
	}

}
