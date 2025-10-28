package com.example.modules.delivery.entities;

import java.time.LocalDateTime;

public class Delivery {
    private Long id;
    private Long userId;
    private String deliveryLocation;
    private boolean delivered;
    private LocalDateTime deliveryDate;
    private String status;
    
    public Delivery() {}
    
    public Delivery(Long id, Long userId, String deliveryLocation, boolean delivered, LocalDateTime deliveryDate, String status) {
        this.id = id;
        this.userId = userId;
        this.deliveryLocation = deliveryLocation;
        this.delivered = delivered;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getDeliveryLocation() {
        return deliveryLocation;
    }
    
    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }
    
    public boolean isDelivered() {
        return delivered;
    }
    
    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
    
    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }
    
    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}