package com.example.restapi.repository;

import com.example.restapi.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity,Long > {

}
