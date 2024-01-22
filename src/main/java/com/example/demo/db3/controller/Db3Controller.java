package com.example.demo.db3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
}
