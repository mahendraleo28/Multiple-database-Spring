package com.example.demo.db2.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.db2.Enitity.Db2Entity;

public interface Db2Repo extends JpaRepository<Db2Entity , Integer> {
	List<Db2Entity> findAll();
}
