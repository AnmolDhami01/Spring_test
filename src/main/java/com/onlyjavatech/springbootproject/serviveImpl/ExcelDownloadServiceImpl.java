package com.onlyjavatech.springbootproject.serviveImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	public void saveExcel(MultipartFile file) {

		try {
			List<BooksModel> convertExcelToListOfBooks = ExcelDownloadHelper
					.convertExcelToListOfBooks(file.getInputStream());
			this.booksRepo.saveAll(convertExcelToListOfBooks);
		} catch (IOException e) {

			e.printStackTrace();
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
