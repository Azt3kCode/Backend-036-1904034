package com.backend.app.laptops.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.laptops.entity.Laptop;
import com.backend.app.laptops.service.LaptopService;

@RestController
public class LaptopController {
	
	@Autowired
	private LaptopService service;
	
	@Value("$(server.port")
	private Integer port;
	
	@GetMapping("/list")
	public List<Laptop> list() {
	    return service.findAll()
	        .stream()
	        .map(lap -> {
	            lap.setPort(port);
	            return lap;
	        })
	        .toList();
	}
	
	@GetMapping("/laptop/{id}")
	public Laptop detail(@PathVariable Long id) {
		
//		boolean bl = false;
//		if (!bl) {
//			throw new RuntimeException("No se pudo obtener el detalle de la laptop");
//		}
		return service.findById(id);
	}
	
	@DeleteMapping("/laptop/{id}")
	public ResponseEntity<Void> drop(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/laptop")
	public ResponseEntity<Laptop> add(@RequestBody Laptop instance) {
		Laptop lap = service.save(instance);
		return new ResponseEntity<>(lap, HttpStatus.CREATED);
	}
	
	@PutMapping("/laptop/{id}")
	public ResponseEntity<Laptop> update(@PathVariable Long id, @RequestBody Laptop instance) {
		if (service.existsById(id)) {
			instance.setId(id);
			Laptop lap = service.save(instance);
			return new ResponseEntity<>(lap, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
