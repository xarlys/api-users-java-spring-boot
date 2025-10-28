package com.example.modules.home.services;

import com.example.modules.home.entities.UserDeliveryInfo;
import java.util.List;
import java.util.Optional;

public interface UserDeliveryService {
    List<UserDeliveryInfo> getAllUserDeliveryInfo();
    Optional<UserDeliveryInfo> getUserDeliveryInfoById(Long userId);
}