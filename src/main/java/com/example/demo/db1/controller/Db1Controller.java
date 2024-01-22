package com.example.demo.db1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
}
