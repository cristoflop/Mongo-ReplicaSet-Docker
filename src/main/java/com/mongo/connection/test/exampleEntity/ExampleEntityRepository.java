package com.mongo.connection.test.exampleEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleEntityRepository extends MongoRepository<ExampleEntity, String> {

}
