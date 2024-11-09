package com.nareshit.raghu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.raghu.entity.Company;
import com.nareshit.raghu.exception.CompanyNotFoundException;
import com.nareshit.raghu.service.ICompanyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyRestController {

	@Autowired
	private ICompanyService service;

	// 1. create company
	@PostMapping("/create")
	public ResponseEntity<String> createCompany(@RequestBody Company company) {
		log.info("ENTERED INTO SAVE METHOD");
		ResponseEntity<String> response = null;
		try {
			Long id = service.createCompany(company);
			response = ResponseEntity.ok("CREATED WITH ID : " + id);
			log.info("COMPANY IS CREATED {}.", id);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.info("ABOUT TO LEAVE SAVE METHOD");
		return response;
	}

	// 2. fetch all
	@GetMapping("/all")
	public ResponseEntity<List<Company>> getAllCompanies() {
		ResponseEntity<List<Company>> response = null;
		log.info("ENTERED INTO FETCH METHOD");
		try {
			List<Company> list = service.getAllCompanies();
			response = ResponseEntity.ok(list);
			log.info("FETCH METHOD IS SUCCESS");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.info("ABOUT TO LEAVE FETCH ALL METHOD");
		return response;
	}

	// 3. fetch one
	@GetMapping("/fetch/{id}")
	public ResponseEntity<Company> getOneCompany(@PathVariable Long id) {
		ResponseEntity<Company> response = null;
		log.info("ENTERED INTO FETCH ONE METHOD");
		try {
			Company cob = service.getOneCompany(id);
			response = ResponseEntity.ok(cob);
			log.info("FETCH ONE METHOD IS SUCCESS");
		} catch (CompanyNotFoundException e) {
			// e.printStackTrace();
			log.error(e.getMessage());
			throw e;
		}
		log.info("ABOUT TO LEAVE FETCH ONE METHOD");
		return response;
	}

	

}
