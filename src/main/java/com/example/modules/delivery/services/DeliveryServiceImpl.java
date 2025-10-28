package com.example.modules.delivery.services;

import com.example.modules.delivery.entities.Delivery;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    
    private List<Delivery> deliveries;
    
    public DeliveryServiceImpl() {
        deliveries = new ArrayList<>();
        deliveries.add(new Delivery(1L, 1L, "Portaria do prédio", true,
            LocalDateTime.of(2024, 10, 25, 14, 30), "Entregue"));
        deliveries.add(new Delivery(2L, 2L, "Portaria do prédio", false,
            null, "Em trânsito"));
        deliveries.add(new Delivery(3L, 3L, "Portaria do prédio", true,
            LocalDateTime.of(2024, 10, 26, 16, 45), "Entregue"));
    }
    
    @Override
    public List<Delivery> getAllDeliveries() {
        return new ArrayList<>(deliveries);
    }
    
    @Override
    public Optional<Delivery> getDeliveryById(Long id) {
        return deliveries.stream()
                .filter(delivery -> delivery.getId().equals(id))
                .findFirst();
    }
    
    @Override
    public List<Delivery> getDeliveriesByUserId(Long userId) {
        return deliveries.stream()
                .filter(delivery -> delivery.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
    
    @Override
    public Delivery createDelivery(Delivery delivery) {
        deliveries.add(delivery);
        return delivery;
    }
    
    @Override
    public Delivery updateDelivery(Long id, Delivery delivery) {
        Optional<Delivery> existingDelivery = getDeliveryById(id);
        if (existingDelivery.isPresent()) {
            Delivery deliveryToUpdate = existingDelivery.get();
            deliveryToUpdate.setDeliveryLocation(delivery.getDeliveryLocation());
            deliveryToUpdate.setDelivered(delivery.isDelivered());
            deliveryToUpdate.setDeliveryDate(delivery.getDeliveryDate());
            deliveryToUpdate.setStatus(delivery.getStatus());
            return deliveryToUpdate;
        }
        return null;
    }
    
    @Override
    public void deleteDelivery(Long id) {
        deliveries.removeIf(delivery -> delivery.getId().equals(id));
    }
}