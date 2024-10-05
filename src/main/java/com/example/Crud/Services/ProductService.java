package com.example.Crud.Services;

import com.example.Crud.DTOS.RequestProduct;
import com.example.Crud.Entities.Product;
import com.example.Crud.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void SalvarProduto(RequestProduct product){
        Product NovoProduto = new Product(product);
        productRepository.save(NovoProduto);
    }

    public List<Product> ListarProdutos(){
        List<Product> produtos = productRepository.findAll();

        return produtos;
    }


    public Optional<Product> ProcurarPorId(UUID id){
        Optional<Product> produto = productRepository.findById(id);

        return  produto;
    }

    public void DeletarPorId(UUID id){
        productRepository.deleteById(id);
    }



}
