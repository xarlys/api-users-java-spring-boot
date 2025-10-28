# Como Executar

```bash
# Compilar
./mvnw clean compile

# Executar
./mvnw spring-boot:run
```

### Endpoints Individuais

**Usuários:**
- GET /api/users - Lista todos os usuários
- GET /api/users/{id} - Usuário específico

**Endereços:**
- GET /api/addresses - Lista todos os endereços
- GET /api/addresses/{id} - Endereço específico
- GET /api/addresses/user/{userId} - Endereço de um usuário

**Entregas:**
- GET /api/deliveries - Lista todas as entregas
- GET /api/deliveries/{id} - Entrega específica
- GET /api/deliveries/user/{userId} - Entregas de um usuário

## Estrutura do Projeto

```
src/main/java/com/example/
├── HomeApplication.java (Classe principal)
├── controllers/
│   └── ApiIndexController.java (Lista todos os endpoints na raiz)
└── modules/
    ├── users/
    │   ├── entities/User.java
    │   ├── services/
    │   │   ├── UserService.java
    │   │   └── UserServiceImpl.java
    │   └── controllers/UserController.java
    ├── address/
    │   ├── entities/Address.java
    │   ├── services/
    │   │   ├── AddressService.java
    │   │   └── AddressServiceImpl.java
    │   └── controllers/AddressController.java
    ├── delivery/
    │   ├── entities/Delivery.java
    │   ├── services/
    │   │   ├── DeliveryService.java
    │   │   └── DeliveryServiceImpl.java
    │   └── controllers/DeliveryController.java
    └── home/
        ├── entities/UserDeliveryInfo.java
        ├── services/
        │   ├── UserDeliveryService.java
        │   └── UserDeliveryServiceImpl.java
        └── controllers/UserDeliveryController.java
```

## Testando a API

Após executar a aplicação, acesse:
- **http://localhost:8080/** (página inicial com todos os endpoints disponíveis)
- http://localhost:8080/api/user-delivery (informações completas)
- http://localhost:8080/api/users (apenas usuários)
- http://localhost:8080/api/addresses (apenas endereços)
- http://localhost:8080/api/deliveries (apenas entregas)