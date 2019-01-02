package com.test.crud.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.crud.models.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{

}
