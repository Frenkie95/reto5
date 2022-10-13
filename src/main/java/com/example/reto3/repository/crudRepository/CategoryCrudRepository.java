package com.example.reto3.repository.crudRepository;

import com.example.reto3.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository  extends CrudRepository <Category , Integer> {
}
