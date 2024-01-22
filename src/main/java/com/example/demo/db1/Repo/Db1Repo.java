package com.example.demo.db1.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.db1.Entity.DB1Entity;

public interface Db1Repo extends JpaRepository<DB1Entity , Integer> {
	

}