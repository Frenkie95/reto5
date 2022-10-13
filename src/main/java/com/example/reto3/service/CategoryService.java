package com.example.reto3.service;


import com.example.reto3.entities.Category;
import com.example.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import  java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return  categoryRepository.getAll();

    }


    public Optional<Category>getCategory (int id){
        return  categoryRepository.getCategory(id);
    }

    public Category save(Category c) {
        if (c.getId() == null) {
            return categoryRepository.save(c);
        } else {
            Optional<Category> e = categoryRepository.getCategory(c.getId());
            if (e.isPresent()) {
                return c;
            } else {
                return categoryRepository.save(c);
            }

        }

    }


  public  Category update(Category category) {
      if (category.getId() != null) {
          Optional<Category> g = categoryRepository.getCategory(category.getId());
          if (g.isPresent()) {

              if (category.getDescription() != null) {
                  g.get().setDescription(category.getDescription());
              }
              if (category.getName() != null) {
                  g.get().setName(category.getName());

              }
              return categoryRepository.save(g.get());
          } else {
              return category;
          }
      } else {
          return category;
      }
  }



    public boolean delete (int id ){
        boolean d = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;


    }


}