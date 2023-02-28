package com.onlyjavatech.springbootproject.servives;


import org.springframework.web.multipart.MultipartFile;

import com.onlyjavatech.springbootproject.ResponseEntity.ResponseWrapper;


public interface UploadService {
	ResponseWrapper uploadFile(MultipartFile file);

}
