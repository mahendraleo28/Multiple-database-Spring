package com.example.demo.db1.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db1.Entity.DB1Entity;
import com.example.demo.db1.Repo.Db1Repo;

@CrossOrigin
@RestController
public class Db1Controller {
	
	@Autowired
	private Db1Repo db1repo;

	@GetMapping("/db1/all") 
	public List<DB1Entity> getAllDb1details() { 
	 return db1repo.findAll(); 
	}

	@PostMapping("/db1/create")
    public ResponseEntity<String> createDb1Entity(@Validated @RequestBody DB1Entity db1Entity) {
        try {
            db1repo.save(db1Entity);
            return ResponseEntity.ok("DB1Entity created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to create DB1Entity: " + e.getMessage());
        }
    }
}
