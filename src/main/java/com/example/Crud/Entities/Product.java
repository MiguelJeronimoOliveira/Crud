package com.example.Crud.Entities;

import com.example.Crud.DTOS.RequestProduct;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    private float preco;

    public Product(RequestProduct request) {
        this.nome = request.nome();
        this.preco = request.preco();
    }
}
