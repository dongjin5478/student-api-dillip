package com.student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Person;
import com.student.repository.PersonRepository;
import com.student.repository.ProductRepository;
import com.student.request.PersonProduct;
import com.student.response.PersonProductResponse;
import com.student.response.StudentResponse;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class PersonProductController {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Operation(summary = "savePersonAndProductDetais")
	@RequestMapping(path = "/save-person-product",method = RequestMethod.POST)
	public ResponseEntity<StudentResponse> addPersonProductDetails(@RequestBody PersonProduct pp)
	{
		StudentResponse response = new StudentResponse();
		HttpStatus status = null;
		try {
			personRepository.save(pp.getPerson());
			response.setMessage("Data Added Successfully!!");
			status= HttpStatus.CREATED;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			response.setMessage(e.toString());
			status=HttpStatus.BAD_REQUEST;
			
		}
		return new ResponseEntity<StudentResponse>(response,status);
		
	}
	
	@Operation(summary = "fetchAllPersonAndProductDetais")
	@RequestMapping(path = "/fetch-person-product",method = RequestMethod.GET,consumes = "text/plain",produces = "application/json")
	public ResponseEntity<PersonProductResponse> fetchPersonProductDetails()
	{
		List<Person> person = new ArrayList<>();
		person = personRepository.findAll();
//		person.clear();
		PersonProductResponse response = new PersonProductResponse();
		HttpStatus status = null;
		String message = null;
		try {
			System.out.println("============================Heoooo>"+person.isEmpty());
			if (person.size() == 0) {
				message = "No Data is Present in Database";
				response.setMessage(message);
				response.setData(null);
				status = HttpStatus.NOT_FOUND;
			} else {
				response.setData(person);
				message = "Data Found";
				response.setMessage(message);
				status = HttpStatus.OK;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			response.setData(null);
			message = "Data not Found";
			response.setMessage(message);
			status=HttpStatus.BAD_REQUEST;
			
		}
		return new ResponseEntity<PersonProductResponse>(response,status);
		
	}
	
//	@Operation(summary = "fetchPersonAndProductDetaisByPersonId")
//	@RequestMapping(path = "/fetch-person-product/{person_id}",method = RequestMethod.GET)
//	public ResponseEntity<PersonProductResponse> fetchPersonProductDetailsByPersonId(@PathVariable(name = "person_id") int id)
//	{
//		Optional<Person> person = null;
//		HttpStatus status = null;
//		PersonProductResponse response = new PersonProductResponse();
//		String message = null;
//		try {
//			person = personRepository.findById(id);
//			System.out.println("============================>"+person.isEmpty());
//			if (person.isEmpty()) {
//				message = "No Detais Found with this person ID "+id;
//				response.setMessage(message);
//				status = HttpStatus.NOT_FOUND;
//			} else {
//				response.setData(person);
//				message = "Data Found";
//				response.setMessage(message);
//				status = HttpStatus.OK;
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//			response.setData(null);
//			message = "Data not Found";
//			response.setMessage(message);
//			status=HttpStatus.BAD_REQUEST;
//			
//		}
//		return new ResponseEntity<PersonProductResponse>(response,status);
//		
//	}
}
