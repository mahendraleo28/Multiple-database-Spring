package com.example.demo.db2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db2.Enitity.Db2Entity;
import com.example.demo.db2.Repo.Db2Repo;

@CrossOrigin
@RestController
public class Db2Controller {
	
	@Autowired
	private Db2Repo bd2repo;
	
	@GetMapping("/db2/all")
	public List<Db2Entity> getAlldb2Details() {
		return bd2repo.findAll();
	}
	

}
