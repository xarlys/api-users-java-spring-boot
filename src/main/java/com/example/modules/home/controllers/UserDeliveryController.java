package com.example.modules.home.controllers;

import com.example.modules.home.entities.UserDeliveryInfo;
import com.example.modules.home.services.UserDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-delivery")
public class UserDeliveryController {
    
    @Autowired
    private UserDeliveryService userDeliveryService;
    
    @GetMapping
    public ResponseEntity<List<UserDeliveryInfo>> getAllUserDeliveryInfo() {
        List<UserDeliveryInfo> userDeliveryInfos = userDeliveryService.getAllUserDeliveryInfo();
        return ResponseEntity.ok(userDeliveryInfos);
    }
    
    @GetMapping("/{userId}")
    public ResponseEntity<UserDeliveryInfo> getUserDeliveryInfoById(@PathVariable Long userId) {
        Optional<UserDeliveryInfo> userDeliveryInfo = userDeliveryService.getUserDeliveryInfoById(userId);
        return userDeliveryInfo.map(ResponseEntity::ok)
                              .orElse(ResponseEntity.notFound().build());
    }
}