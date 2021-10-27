package com.liferay.salesTaxes.salesTaxes.resource;

import com.liferay.salesTaxes.salesTaxes.domain.Tax;
import com.liferay.salesTaxes.salesTaxes.dto.TaxeDTO;
import com.liferay.salesTaxes.salesTaxes.repository.TaxeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/taxes")
public class TaxeResource {
    @Autowired
    TaxeRepository taxeRepository;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Tax>> findAll(){
        return ResponseEntity.status(HttpStatus.FOUND).body(taxeRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tax>findById(@PathVariable Long id){
        Tax tax = taxeRepository.findById(id).get();
        return ResponseEntity.status(HttpStatus.FOUND).body(tax);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<Tax> post (@RequestBody TaxeDTO obj){
        Tax tax = taxeRepository.save(obj.parseTax());
        return ResponseEntity.status(HttpStatus.CREATED).body(tax);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        taxeRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
}
