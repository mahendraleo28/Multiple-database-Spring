package com.example.demo.db3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db3.Enitity.Db3Entity;
import com.example.demo.db3.Repo.Db3Repo;

@RestController
@CrossOrigin
public class Db3Controller {
	@Autowired
	private Db3Repo db3repo;
	
	@GetMapping("/db3/all")
	public List<Db3Entity> getAlldb3Details() {
		return db3repo.findAll();
	}
	@PostMapping("/db3/create")
    public String createDb3Entity(@RequestBody Db3Entity db3Entity) {
        try {
            db3repo.save(db3Entity);
            return "DB3Entity created successfully";
        } catch (Exception e) {
            return "Failed to create DB2Entity: " + e.getMessage();
        }
    }
}
