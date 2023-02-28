package com.onlyjavatech.springbootproject.helpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.onlyjavatech.springbootproject.ResponseEntity.ResponseWrapper;
import com.onlyjavatech.springbootproject.ResponseEntity.StatusDescription;

@Component
public class FileUploadHelper {
	String userDirectory = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
//	public final String uploadDir = "D:\\Java\\springbootproject\\src\\main\\resources\\static\\image";

//	public final String uploadDir = new ClassPathResource("static/image/").getFile().getAbsolutePath();
//	public FileUploadHelper() throws IOException{
//		statusDescription1.setStatusCode(500);
//		statusDescription1.setStatusDescription("Internal Server Error");
//		responseWrapper1.setStatusDescriptions(statusDescription1);
//		return responseWrapper1;
//	}

	public ResponseWrapper uploadFile(MultipartFile multipartFile) {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();

		try {
			final String uploadDir = new ClassPathResource("static/image/").getFile().getAbsolutePath();

//			InputStream inputStream = multipartFile.getInputStream();
//			
//			byte data[] = new byte[inputStream.available()];
//			
//			inputStream.read(data);
//			
//			FileOutputStream fileOutputStream = new FileOutputStream(uploadDir+"\\"+multipartFile.getOriginalFilename());
//			fileOutputStream.write(data);
//			fileOutputStream.flush();
//			fileOutputStream.close();
			
			

			Files.copy(multipartFile.getInputStream(),
					Paths.get(uploadDir + File.separator + multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			
			responseWrapper1.setFilePath( ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(multipartFile.getOriginalFilename()).toUriString());

			statusDescription1.setStatusCode(200);
			statusDescription1.setStatusDescription("Success");
			responseWrapper1.setStatusDescriptions(statusDescription1);

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
