package com.backend.app.laptops.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.app.laptops.entity.Laptop;

@Service
public interface LaptopService {
	
	public List<Laptop> findAll();
	
	public Laptop findById(Long id);
	
	public void deleteById(Long id);
	
	public Laptop save(Laptop instance);
	
	public boolean existsById(Long id);
}
