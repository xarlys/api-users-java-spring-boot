package com.example.modules.address.services;

import com.example.modules.address.entities.Address;
import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> getAllAddresses();
    Optional<Address> getAddressById(Long id);
    Optional<Address> getAddressByUserId(Long userId);
    Address createAddress(Address address);
    Address updateAddress(Long id, Address address);
    void deleteAddress(Long id);
}