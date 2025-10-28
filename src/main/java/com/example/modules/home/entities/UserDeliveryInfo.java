package com.example.modules.home.entities;

import com.example.modules.users.entities.User;
import com.example.modules.address.entities.Address;
import com.example.modules.delivery.entities.Delivery;

public class UserDeliveryInfo {
    private User user;
    private Address address;
    private Delivery delivery;
    
    public UserDeliveryInfo() {}
    
    public UserDeliveryInfo(User user, Address address, Delivery delivery) {
        this.user = user;
        this.address = address;
        this.delivery = delivery;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public Delivery getDelivery() {
        return delivery;
    }
    
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}