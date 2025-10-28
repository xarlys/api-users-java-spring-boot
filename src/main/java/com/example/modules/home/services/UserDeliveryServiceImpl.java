package com.example.modules.home.services;

import com.example.modules.home.entities.UserDeliveryInfo;
import com.example.modules.users.services.UserService;
import com.example.modules.address.services.AddressService;
import com.example.modules.delivery.services.DeliveryService;
import com.example.modules.users.entities.User;
import com.example.modules.address.entities.Address;
import com.example.modules.delivery.entities.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDeliveryServiceImpl implements UserDeliveryService {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AddressService addressService;
    
    @Autowired
    private DeliveryService deliveryService;
    
    @Override
    public List<UserDeliveryInfo> getAllUserDeliveryInfo() {
        List<UserDeliveryInfo> userDeliveryInfos = new ArrayList<>();
        List<User> users = userService.getAllUsers();
        
        for (User user : users) {
            Optional<Address> address = addressService.getAddressByUserId(user.getId());
            List<Delivery> deliveries = deliveryService.getDeliveriesByUserId(user.getId());
            
            if (address.isPresent() && !deliveries.isEmpty()) {
                // coloquei de exemplo para pegar a primeira entrega
                Delivery delivery = deliveries.get(0);
                userDeliveryInfos.add(new UserDeliveryInfo(user, address.get(), delivery));
            }
        }
        
        return userDeliveryInfos;
    }
    
    @Override
    public Optional<UserDeliveryInfo> getUserDeliveryInfoById(Long userId) {
        Optional<User> user = userService.getUserById(userId);
        Optional<Address> address = addressService.getAddressByUserId(userId);
        List<Delivery> deliveries = deliveryService.getDeliveriesByUserId(userId);
        
        if (user.isPresent() && address.isPresent() && !deliveries.isEmpty()) {
            Delivery delivery = deliveries.get(0); // coloquei de exemplo para pegar a primeira entrega
            return Optional.of(new UserDeliveryInfo(user.get(), address.get(), delivery));
        }
        
        return Optional.empty();
    }
}