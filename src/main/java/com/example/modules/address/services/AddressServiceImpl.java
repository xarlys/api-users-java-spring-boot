package com.example.modules.address.services;

import com.example.modules.address.entities.Address;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    
    private List<Address> addresses;
    
    public AddressServiceImpl() {
        addresses = new ArrayList<>();
        addresses.add(new Address(1L, 1L, "Rua das Flores, 123", "São Paulo", "SP", "01234-567", "Brasil"));
        addresses.add(new Address(2L, 2L, "Rua das Flores, 123", "São Paulo", "SP", "01234-567", "Brasil"));
        addresses.add(new Address(3L, 3L, "Rua das Flores, 123", "São Paulo", "SP", "01234-567", "Brasil"));
    }
    
    @Override
    public List<Address> getAllAddresses() {
        return new ArrayList<>(addresses);
    }
    
    @Override
    public Optional<Address> getAddressById(Long id) {
        return addresses.stream()
                .filter(address -> address.getId().equals(id))
                .findFirst();
    }
    
    @Override
    public Optional<Address> getAddressByUserId(Long userId) {
        return addresses.stream()
                .filter(address -> address.getUserId().equals(userId))
                .findFirst();
    }
    
    @Override
    public Address createAddress(Address address) {
        addresses.add(address);
        return address;
    }
    
    @Override
    public Address updateAddress(Long id, Address address) {
        Optional<Address> existingAddress = getAddressById(id);
        if (existingAddress.isPresent()) {
            Address addressToUpdate = existingAddress.get();
            addressToUpdate.setStreet(address.getStreet());
            addressToUpdate.setCity(address.getCity());
            addressToUpdate.setState(address.getState());
            addressToUpdate.setZipCode(address.getZipCode());
            addressToUpdate.setCountry(address.getCountry());
            return addressToUpdate;
        }
        return null;
    }
    
    @Override
    public void deleteAddress(Long id) {
        addresses.removeIf(address -> address.getId().equals(id));
    }
}