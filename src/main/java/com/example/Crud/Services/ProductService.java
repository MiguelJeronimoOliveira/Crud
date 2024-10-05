package com.example.Crud.Services;

import com.example.Crud.DTOS.RequestProduct;
import com.example.Crud.Entities.Product;
import com.example.Crud.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


}
