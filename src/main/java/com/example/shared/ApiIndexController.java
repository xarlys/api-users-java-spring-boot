package com.example.shared;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiIndexController {
    
    @GetMapping("/")
    public Map<String, Object> getApiIndex() {
        Map<String, Object> response = new HashMap<>();
        
        response.put("message", "Criação de api de exemplo, desenvolvido em java com spring boot");
        response.put("developer", "Xarlys Luiz de S. Oliveira");
        response.put("version", "1.0.0");
        
        Map<String, String> endpoints = new HashMap<>();
        
        endpoints.put("GET /api/user-delivery", "Lista todos os usuários com informações completas (nome, email, endereço, entrega)");
        endpoints.put("GET /api/user-delivery/{userId}", "Informações completas de um usuário específico");
        
        endpoints.put("GET /api/users", "Lista todos os usuários");
        endpoints.put("GET /api/users/{id}", "Busca usuário por ID");
        endpoints.put("POST /api/users", "Cria novo usuário");
        endpoints.put("PUT /api/users/{id}", "Atualiza usuário");
        endpoints.put("DELETE /api/users/{id}", "Remove usuário");
        
        endpoints.put("GET /api/addresses", "Lista todos os endereços");
        endpoints.put("GET /api/addresses/{id}", "Busca endereço por ID");
        endpoints.put("GET /api/addresses/user/{userId}", "Busca endereço por ID do usuário");
        endpoints.put("POST /api/addresses", "Cria novo endereço");
        endpoints.put("PUT /api/addresses/{id}", "Atualiza endereço");
        endpoints.put("DELETE /api/addresses/{id}", "Remove endereço");
        
        endpoints.put("GET /api/deliveries", "Lista todas as entregas");
        endpoints.put("GET /api/deliveries/{id}", "Busca entrega por ID");
        endpoints.put("GET /api/deliveries/user/{userId}", "Busca entregas por ID do usuário");
        endpoints.put("POST /api/deliveries", "Cria nova entrega");
        endpoints.put("PUT /api/deliveries/{id}", "Atualiza entrega");
        endpoints.put("DELETE /api/deliveries/{id}", "Remove entrega");
        
        response.put("endpoints", endpoints);
        
        Map<String, String> examples = new HashMap<>();
        examples.put("Dados completos", "http://localhost:8080/api/user-delivery");
        examples.put("Usuário específico", "http://localhost:8080/api/user-delivery/1");
        examples.put("Todos usuários", "http://localhost:8080/api/users");
        examples.put("Todos endereços", "http://localhost:8080/api/addresses");
        examples.put("Todas entregas", "http://localhost:8080/api/deliveries");
        
        response.put("endpoint de exemplos", examples);
        
        return response;
    }
}