package com.example.modules.delivery.controllers;

import com.example.modules.delivery.entities.Delivery;
import com.example.modules.delivery.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {
    
    @Autowired
    private DeliveryService deliveryService;
    
    @GetMapping
    public ResponseEntity<List<Delivery>> getAllDeliveries() {
        List<Delivery> deliveries = deliveryService.getAllDeliveries();
        return ResponseEntity.ok(deliveries);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable Long id) {
        Optional<Delivery> delivery = deliveryService.getDeliveryById(id);
        return delivery.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Delivery>> getDeliveriesByUserId(@PathVariable Long userId) {
        List<Delivery> deliveries = deliveryService.getDeliveriesByUserId(userId);
        return ResponseEntity.ok(deliveries);
    }
    
    @PostMapping
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery) {
        Delivery createdDelivery = deliveryService.createDelivery(delivery);
        return ResponseEntity.ok(createdDelivery);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Delivery> updateDelivery(@PathVariable Long id, @RequestBody Delivery delivery) {
        Delivery updatedDelivery = deliveryService.updateDelivery(id, delivery);
        if (updatedDelivery != null) {
            return ResponseEntity.ok(updatedDelivery);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
        return ResponseEntity.noContent().build();
    }
}