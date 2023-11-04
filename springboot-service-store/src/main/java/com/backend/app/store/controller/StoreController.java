package com.backend.app.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.laptops.entity.Laptop;
import com.backend.app.store.models.Store;
import com.backend.app.store.services.StoreService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping("/list")
	public List<Store> list() {
		return storeService.findAll();
	}
	
	@HystrixCommand(fallbackMethod = "metodoGenerico")
	@GetMapping("/laptop/{id}/cantidad/{cantidad}")
	public Store detail(@PathVariable Long id, @PathVariable Integer cantidad) {
		return storeService.findById(id, cantidad);
	}
	
	public Store metodoGenerico(Long id, Integer cantidad) {
		Store store = new Store();
		Laptop lap = new Laptop(id, "La lap de Alexis", "Hp");
		store.setCantidad(cantidad);
		store.setLap(lap);
		
		return store;
	}
}	
