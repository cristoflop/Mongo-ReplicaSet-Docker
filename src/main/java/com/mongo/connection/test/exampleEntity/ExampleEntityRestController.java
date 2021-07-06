package com.mongo.connection.test.exampleEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExampleEntityRestController {

	@Autowired
	private ExampleEntityRepository repository;

	@GetMapping("/example")
	public List<ExampleEntity> findAll() {
		return this.repository.findAll();
	}

	@PostMapping("/example")
	public ExampleEntity save(@RequestBody String field) {
		return this.repository.save(new ExampleEntity(field));
	}

}
