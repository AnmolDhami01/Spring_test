package com.onlyjavatech.springbootproject.servives;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.onlyjavatech.springbootproject.ResponseEntity.ResponseWrapper;
import com.onlyjavatech.springbootproject.model.BooksModel;

public interface ExcelDownloadService {
	ByteArrayInputStream dataToExcel();

	ResponseWrapper saveExcel(MultipartFile file);

	List<BooksModel> getAllBooks();
}
