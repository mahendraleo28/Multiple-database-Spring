package com.example.demo.db3.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.db3.Enitity.Db3Entity;

public interface Db3Repo extends JpaRepository<Db3Entity , Integer> {
	List<Db3Entity> findAll();
}
