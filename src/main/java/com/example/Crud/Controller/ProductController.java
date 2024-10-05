package com.example.Crud.Controller;

import com.example.Crud.DTOS.RequestProduct;
import com.example.Crud.Entities.Product;
import com.example.Crud.Repositories.ProductRepository;
import com.example.Crud.Services.ProductService;
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
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity AllProduts(){

        var products = productService.ListarProdutos();

        return ResponseEntity.ok(products);
    }

    @PostMapping("/addproduct")
    public ResponseEntity AddProduct(@RequestBody RequestProduct request ){

        productService.SalvarProduto(request);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateproduct")
    public ResponseEntity UpdateProduct(@RequestBody RequestProduct request){
        Optional<Product> productOptional = productService.ProcurarPorId(request.id());

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
        Optional<Product> productOptional = productService.ProcurarPorId(id);
        if(productOptional.isPresent()){
            productService.DeletarPorId(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
