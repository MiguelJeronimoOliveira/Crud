package com.example.Crud.Controller;

import com.example.Crud.DTOS.RequestProduct;
import com.example.Crud.Entities.Product;
import com.example.Crud.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping
public class ProductController {

    @Autowired
    ProductRepository productRepository;



}
