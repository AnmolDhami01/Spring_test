package com.onlyjavatech.springbootproject;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import com.onlyjavatech.springbootproject.ResponseEntity.ResponseWrapper;
import com.onlyjavatech.springbootproject.ResponseEntity.StatusDescription;
import com.onlyjavatech.springbootproject.model.Students;
import com.onlyjavatech.springbootproject.model.repo.StudentRepo;

@RestController
// @ResponseBody
@RequestMapping("student/v1/")
@CrossOrigin(value = "*")
public class TestController {

	@Autowired
	StudentRepo studentRepo;

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/test")
	public String firstHandler() {
		return "New Endpoint";
	}

	@GetMapping("/myapi")
	public String myApiEndpoint() {
		return "Hello, World!";
	}

	@PostMapping("saveStudent")
	public ResponseEntity<ResponseWrapper> saveStudet(@RequestBody Students str) {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();
		try {

			if (str.getAge() == null || str.getClass1() == null) {

				return new ResponseEntity<>(responseWrapper1, HttpStatus.BAD_REQUEST);

			}

			this.studentRepo.save(str);
			responseWrapper1.setStudentt(str);
			statusDescription1.setStatusCode(200);
			statusDescription1.setStatusDescription("Success");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return new ResponseEntity<>(responseWrapper1, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			statusDescription1.setStatusCode(500);
			statusDescription1.setStatusDescription("Internal Server Error");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return new ResponseEntity<>(responseWrapper1, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("saveStudentBulk")
	public ResponseEntity<ResponseWrapper> saveStudetBulk(@RequestBody ResponseWrapper str) {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();
		try {

			List<Students> studentts = str.getStudentts();

			for (Students students : studentts) {

				if (students.getAge() == null || students.getClass1() == null) {

					return new ResponseEntity<>(responseWrapper1, HttpStatus.BAD_REQUEST);

				}
			}

			System.out.println(str.getStudentts());

			this.studentRepo.saveAll(str.getStudentts());
			// responseWrapper1.setStudentts(studentts);
			statusDescription1.setStatusCode(200);
			statusDescription1.setStatusDescription("Success");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return new ResponseEntity<>(responseWrapper1, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			statusDescription1.setStatusCode(500);
			statusDescription1.setStatusDescription("Internal Server Error");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return new ResponseEntity<>(responseWrapper1, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("getAllStudents")
	public ResponseEntity<ResponseWrapper> getAllStudents() {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();
		try {

			List<Students> findAll = studentRepo.findAll();

			if (findAll.size() == 0) {
				statusDescription1.setStatusCode(220);
				statusDescription1.setStatusDescription("No Data Found");
				responseWrapper1.setStatusDescriptions(statusDescription1);
				return new ResponseEntity<>(responseWrapper1, HttpStatus.OK);
			}
			responseWrapper1.setStudentts(findAll);
			statusDescription1.setStatusCode(200);
			statusDescription1.setStatusDescription("Success");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return new ResponseEntity<>(responseWrapper1, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			statusDescription1.setStatusCode(500);
			statusDescription1.setStatusDescription("Internal Server Error");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return new ResponseEntity<>(responseWrapper1, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("getStudentById")
	public ResponseEntity<ResponseWrapper> updateStudent(
			@RequestParam(value = "userId", required = true, defaultValue = "0") Integer userId) {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();
		System.out.println(userId);
		try {

			Optional<Students> foundUser = studentRepo.findById(userId);

			if (!foundUser.isPresent()) {
				statusDescription1.setStatusCode(220);
				statusDescription1.setStatusDescription("No User Found with this id exist");
				responseWrapper1.setStatusDescriptions(statusDescription1);
				return new ResponseEntity<>(responseWrapper1, HttpStatus.OK);
			}
			responseWrapper1.setStudentt(foundUser.get());
			statusDescription1.setStatusCode(200);
			statusDescription1.setStatusDescription("Success");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return new ResponseEntity<>(responseWrapper1, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			statusDescription1.setStatusCode(500);
			statusDescription1.setStatusDescription("Internal Server Error");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return new ResponseEntity<>(responseWrapper1, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("updateStudent")
	public ResponseEntity<ResponseWrapper> updateStudet(@RequestBody Students str) {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();
		try {

			if ((str.getAge() == "" || str.getAge() == null) || str.getClass1() == null || str.getId() == null) {
				statusDescription1.setStatusCode(400);
				statusDescription1.setStatusDescription("Bad Request");
				responseWrapper1.setStatusDescriptions(statusDescription1);
				return new ResponseEntity<>(responseWrapper1, HttpStatus.BAD_REQUEST);

			}

			Optional<Students> foundUser = studentRepo.findById(str.getId());

			if (!foundUser.isPresent()) {
				statusDescription1.setStatusCode(220);
				statusDescription1.setStatusDescription("No User Found");
				responseWrapper1.setStatusDescriptions(statusDescription1);
				return new ResponseEntity<>(responseWrapper1, HttpStatus.OK);
			}

			Students students = foundUser.get();

			students.setAge(str.getAge());
			students.setClass1(str.getClass1());

			studentRepo.save(students);

			responseWrapper1.setStudentt(str);
			statusDescription1.setStatusCode(200);
			statusDescription1.setStatusDescription("Success");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return new ResponseEntity<>(responseWrapper1, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			statusDescription1.setStatusCode(500);
			statusDescription1.setStatusDescription("Internal Server Error");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return new ResponseEntity<>(responseWrapper1, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("deleteStudentById")
	public ResponseEntity<ResponseWrapper> deleteStudent(
			@RequestParam(value = "userId", required = true) Integer userId) {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();

		try {

			Optional<Students> foundUser = studentRepo.findById(userId);

			if (!foundUser.isPresent()) {
				statusDescription1.setStatusCode(220);
				statusDescription1.setStatusDescription("No User Found with this id exist");
				responseWrapper1.setStatusDescriptions(statusDescription1);
				return new ResponseEntity<>(responseWrapper1, HttpStatus.OK);
			}
			studentRepo.deleteById(userId);
			statusDescription1.setStatusCode(200);
			statusDescription1.setStatusDescription("Success");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return new ResponseEntity<>(responseWrapper1, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			statusDescription1.setStatusCode(500);
			statusDescription1.setStatusDescription("Internal Server Error");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return new ResponseEntity<>(responseWrapper1, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@SuppressWarnings("deprecation")
	@GetMapping("getStudentsByAge")
	public ResponseEntity<ResponseWrapper> getAllStudentsByAge(
			@RequestParam(value = "age", required = true) String age) {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();
		try {

			List<Students> findAll = studentRepo.findByAge(age);
			List<Students> findByAgeAndClass1 = studentRepo.findByAgeAndClass1(age, age);

			List<Students> findByCreationDate = studentRepo.findByCreationDate("2023-02-27");
			
//			Students studentsFiltered = findByCreationDate.stream().filter(e->e.getId()== 48).findFirst().get();
//			
//			System.out.println(studentsFiltered);

//			findByCreationDate.forEach(e -> {
//
//				System.out.println(e);
//			});

//			System.out.println(findByAgeAndClass1);

			if (findAll.size() == 0) {

				statusDescription1.setStatusCode(220);
				statusDescription1.setStatusDescription("No Data Found");
				responseWrapper1.setStatusDescriptions(statusDescription1);
				return new ResponseEntity<>(responseWrapper1, HttpStatus.OK);
			}
			responseWrapper1.setStudentts(findAll);
			statusDescription1.setStatusCode(200);
			statusDescription1.setStatusDescription("Success");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return new ResponseEntity<>(responseWrapper1, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			statusDescription1.setStatusCode(500);
			statusDescription1.setStatusDescription("Internal Server Error");
			responseWrapper1.setStatusDescriptions(statusDescription1);
			return new ResponseEntity<>(responseWrapper1, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
