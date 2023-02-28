package com.onlyjavatech.springbootproject.serviveImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.onlyjavatech.springbootproject.ResponseEntity.ResponseWrapper;
import com.onlyjavatech.springbootproject.ResponseEntity.StatusDescription;
import com.onlyjavatech.springbootproject.helpers.FileUploadHelper;
import com.onlyjavatech.springbootproject.servives.UploadService;

@Service
public class UploadSeriveImpl implements UploadService {

	@Autowired
	FileUploadHelper fileuploadhepler;

	@Override
	public ResponseWrapper uploadFile(MultipartFile file) {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();
		try {
			if (file.isEmpty()) {
				statusDescription1.setStatusCode(400);
				statusDescription1.setStatusDescription("Bad Request");
				responseWrapper1.setStatusDescriptions(statusDescription1);
			}

			System.out.println(file.getContentType() + "--" + file.getSize() + "--" + file.getOriginalFilename());

			if (!file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
				statusDescription1.setStatusCode(400);
				statusDescription1.setStatusDescription("Only Excel file format supported");
				responseWrapper1.setStatusDescriptions(statusDescription1);
			}
			responseWrapper1 = fileuploadhepler.uploadFile(file);
		} catch (Exception e) {
			e.printStackTrace();
			statusDescription1.setStatusCode(500);
			statusDescription1.setStatusDescription("Internal Server Error");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return responseWrapper1;
		}
		return responseWrapper1;

	}

}
