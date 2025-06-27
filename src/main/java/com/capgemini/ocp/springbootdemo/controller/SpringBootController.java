package com.capgemini.ocp.springbootdemo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ocp.springbootdemo.service.SpringBootService;

@RestController
public class SpringBootController {

	@Autowired
	public SpringBootService springBootService;

	// http://localhost:8080/getDuplicates?input=20,15,34,56,56,76,15,45,20
	// http://localhost:8080/getDuplicates?input=apple,banana,mango,apple,guva,mango
	@GetMapping("/getDuplicates")
	public ResponseEntity<?> getDuplicateDetails(@RequestParam String input) {

		List<String> duplicates = Arrays.asList(input.split(","));

		List<String> response = springBootService.getDuplicates(duplicates);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/getDuplicates")
	public ResponseEntity<?> getDuplicateDetails(@RequestBody List<String> inputList) {
		System.out.println("Received input : " + inputList);

		List<String> response = springBootService.getDuplicateElements(inputList);
		System.out.println("The Duplicate Elements is :" + response);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/createDuplicates")
	public ResponseEntity<?> createDuplicates(@RequestBody List<String> inputList) {
		List<String> duplicates = springBootService.createDuplicates(inputList);
		System.out.println("The duplicate values are : " + duplicates);
		return ResponseEntity.ok(duplicates);
	}

	@GetMapping("/getAllDuplicates")
	public ResponseEntity<?> getAllDuplicates() {
		List<String> allDuplicates = springBootService.getAllDuplicateElements();
		return ResponseEntity.ok(allDuplicates);
	}

}
