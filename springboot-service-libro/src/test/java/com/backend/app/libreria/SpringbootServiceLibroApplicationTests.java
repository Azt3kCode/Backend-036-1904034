package com.backend.app.libreria;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;

@SpringBootTest
class SpringbootServiceLibroApplicationTests {

    @SuppressWarnings("rawtypes")
	@Autowired
    private CrudRepository libroRepository;

    @Test
    void contextLoads() {
        assertNotNull(libroRepository);
    }
}
