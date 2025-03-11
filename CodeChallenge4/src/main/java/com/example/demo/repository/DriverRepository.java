package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Driver;

public interface DriverRepository extends JpaRepository<Driver,Integer> {
    Optional<Driver> findByName(String name);   
}
