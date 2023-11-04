package com.backend.app.store.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.backend.app.store.models.Laptop;
import com.backend.app.store.models.Store;

@Service("serviceRest")
public class StoreServiceRestImpl implements StoreService {

	@Autowired
	private RestTemplate clientRest;
	
	@Override
	public List<Store> findAll() {
		List<Laptop> laptops = Arrays.asList(
				clientRest.getForObject("http://localhost:8081/list", Laptop[].class)
				);
		
		return laptops.stream()
				.map(c -> new Store(c, 5))
				.collect(Collectors.toList());
	}

	@Override
	public Store findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		Laptop lap = clientRest.getForObject("http://localhost:8081/laptop/{id}", Laptop.class, pathVariables);
		return new Store(lap, cantidad);
	}

}
