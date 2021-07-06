package com.mongo.connection.test.exampleEntity;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class DataLoader {

	private ExampleEntityRepository repository;

	public DataLoader(ExampleEntityRepository repository) {
		this.repository = repository;
	}

	@PostConstruct
	public void setUp() {

		this.repository.save(new ExampleEntity("Ejemplo uno"));
		this.repository.save(new ExampleEntity("Ejemplo dos"));
		this.repository.save(new ExampleEntity("Ejemplo tres"));
		this.repository.save(new ExampleEntity("Ejemplo cuatro"));
		this.repository.save(new ExampleEntity("Ejemplo cinco"));

	}

}
