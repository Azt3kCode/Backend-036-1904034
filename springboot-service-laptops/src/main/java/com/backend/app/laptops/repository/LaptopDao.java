package com.backend.app.laptops.repository;

import org.springframework.data.repository.CrudRepository;

import com.backend.app.laptops.entity.Laptop;

public interface LaptopDao extends CrudRepository<Laptop, Long>{

}
