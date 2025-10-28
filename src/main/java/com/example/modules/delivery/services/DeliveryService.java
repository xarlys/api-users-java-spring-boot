package com.example.modules.delivery.services;

import com.example.modules.delivery.entities.Delivery;
import java.util.List;
import java.util.Optional;

public interface DeliveryService {
    List<Delivery> getAllDeliveries();
    Optional<Delivery> getDeliveryById(Long id);
    List<Delivery> getDeliveriesByUserId(Long userId);
    Delivery createDelivery(Delivery delivery);
    Delivery updateDelivery(Long id, Delivery delivery);
    void deleteDelivery(Long id);
}