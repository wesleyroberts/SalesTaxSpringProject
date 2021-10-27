package com.liferay.salesTaxes.salesTaxes.resource;

import com.liferay.salesTaxes.salesTaxes.domain.Cart;
import com.liferay.salesTaxes.salesTaxes.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/Carts")
public class CartResource {
    @Autowired
    CartRepository cartRepository;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Cart>> findAll(){
        return ResponseEntity.status(HttpStatus.FOUND).body(cartRepository.findAll());
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Cart>findById(@PathVariable Long id){
        Cart cart = cartRepository.findById(id).get();
        return ResponseEntity.status(HttpStatus.FOUND).body(cart);
    }

    @PostMapping(value = "/post")
    public ResponseEntity<Cart> post (@RequestBody Cart cart){
        cartRepository.save(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(cart);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        cartRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
}
