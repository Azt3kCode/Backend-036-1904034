package com.backend.app.laptops.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.app.laptops.entity.Laptop;
import com.backend.app.laptops.repository.LaptopDao;

@Service
public class LaptopServiceImpl implements LaptopService {
	
	@Autowired
	private LaptopDao laptopDao;
	
	@Override
	public List<Laptop> findAll() {
		return (List<Laptop>) laptopDao.findAll();
	}

	@Override
	public Laptop findById(Long id) {
		return laptopDao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		laptopDao.deleteById(id);
	}

	@Override
	public Laptop save(Laptop instance) {
		return laptopDao.save(instance);
	}

	@Override
	public boolean existsById(Long id) {
		return laptopDao.existsById(id);
	}

}
