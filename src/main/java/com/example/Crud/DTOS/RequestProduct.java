package com.example.Crud.DTOS;

import java.util.UUID;

public record RequestProduct(UUID id, String nome, float preco) {
}
