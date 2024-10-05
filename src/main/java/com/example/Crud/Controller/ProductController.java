package com.example.Crud.Controller;

import com.example.Crud.DTOS.RequestProduct;
import com.example.Crud.Entities.Product;
import com.example.Crud.Repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity AllProduts(){

        var products = productRepository.findAll();

        return ResponseEntity.ok(products);
    }

    @PostMapping("/addproduct")
    public ResponseEntity AddProduct(@RequestBody RequestProduct request ){

        Product newProduct = new Product(request);
        productRepository.save(newProduct);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateproduct")
    public ResponseEntity UpdateProduct(@RequestBody RequestProduct request){
        Optional<Product> productOptional = productRepository.findById(request.id());

        if(productOptional.isPresent()){
            Product product = productOptional.get();

            product.setNome(request.nome());
            product.setPreco(request.preco());

            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity DeleteProduct(@PathVariable UUID id){
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            productRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
