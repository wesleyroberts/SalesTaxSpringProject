package com.liferay.salesTaxes.salesTaxes.resource;

import com.liferay.salesTaxes.salesTaxes.domain.Category;
import com.liferay.salesTaxes.salesTaxes.domain.Product;
import com.liferay.salesTaxes.salesTaxes.domain.Tax;
import com.liferay.salesTaxes.salesTaxes.dto.ProductDTO;
import com.liferay.salesTaxes.salesTaxes.repository.CategoryReository;
import com.liferay.salesTaxes.salesTaxes.repository.ProductRepository;
import com.liferay.salesTaxes.salesTaxes.repository.TaxeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryReository categoryReository;
    @Autowired
    TaxeRepository taxeRepository;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.status(HttpStatus.FOUND).body(productRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product>findById(@PathVariable Long id){
        Product product = productRepository.findById(id).get();
        return ResponseEntity.status(HttpStatus.FOUND).body(product);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<Product> post (@RequestBody ProductDTO obj){
        //melhorar a forma de criar productos
        Category category = categoryReository.findById(obj.getCategoryId()).get();
        Tax tax = taxeRepository.findById(obj.getTaxeId()).get();
        Product product = productRepository.save(obj.parseProduct(category,tax));
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        productRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
}
