package com.backend.app.store.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.backend.app.store.models.Laptop;

@FeignClient(name = "service-laptops", url = "localhost:8081")
public interface LaptopClientFeign {
	
	@GetMapping("/list")
	public List<Laptop> list();
	
	@GetMapping("/laptop/{id}")
	public Laptop detail(@PathVariable Long id);
}