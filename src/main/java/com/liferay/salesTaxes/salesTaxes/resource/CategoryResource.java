package com.liferay.salesTaxes.salesTaxes.resource;

import com.liferay.salesTaxes.salesTaxes.domain.Category;
import com.liferay.salesTaxes.salesTaxes.dto.CategoryDTO;
import com.liferay.salesTaxes.salesTaxes.repository.CategoryReository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    CategoryReository categoryReository;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.status(HttpStatus.FOUND).body(categoryReository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category>findById(@PathVariable Long id){
        Category category = categoryReository.findById(id).get();
        return ResponseEntity.status(HttpStatus.FOUND).body(category);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<Category> post(@RequestBody CategoryDTO obj){
        Category category = categoryReository.save(obj.parseCategory());
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        categoryReository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }



}
