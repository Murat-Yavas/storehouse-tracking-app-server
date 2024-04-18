package com.devtech.StorehouseTrackingApp.services.concretes;


import com.devtech.StorehouseTrackingApp.entities.Product;
import com.devtech.StorehouseTrackingApp.entities.Storehouse;
import com.devtech.StorehouseTrackingApp.entities.User;
import com.devtech.StorehouseTrackingApp.exceptions.StorehouseNotFoundException;
import com.devtech.StorehouseTrackingApp.repositories.ProductRepository;
import com.devtech.StorehouseTrackingApp.repositories.StorehouseRepository;
import com.devtech.StorehouseTrackingApp.requests.StorehouseCreateRequest;
import com.devtech.StorehouseTrackingApp.responses.StorehouseResponse;
import com.devtech.StorehouseTrackingApp.services.abstracts.StorehouseService;
import com.devtech.StorehouseTrackingApp.services.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class StorehouseManager implements StorehouseService {

    private StorehouseRepository storehouseRepository;
    private ProductRepository productRepository;
    private UserService userService;


    @Override
    public List<StorehouseResponse> getAllStorehouses() {
        List<Storehouse> list = storehouseRepository.findAll();
        return list.stream().map(l -> {
            List<Product> products = productRepository.findByStorehouseId(l.getId());
            return new StorehouseResponse(l, products);
        }).collect(Collectors.toList());
    }

    @Override
    public Storehouse getOneStorehouseById(Long storehouseId) {
        return storehouseRepository.findById(storehouseId).orElse(null);
    }

    @Override
    public Storehouse getOneStorehouseByAddress(String storehouseAddress) {
        return storehouseRepository.findByAddress(storehouseAddress);
    }

    @Override
    public Storehouse createOneStorehouse(StorehouseCreateRequest newStorehouse) {
        User user = userService.getOneUserById(newStorehouse.getUserId());
        if (user != null) {
            Storehouse storehouseToSave = new Storehouse();
            storehouseToSave.setName(newStorehouse.getName());
            storehouseToSave.setStorageCapacity(newStorehouse.getStorageCapacity());
            storehouseToSave.setAddress(newStorehouse.getAddress());
            storehouseToSave.setUser(user);
            return storehouseRepository.save(storehouseToSave);
        }
        return null;
    }

    @Override
    public Storehouse updateOneStorehouse(Long storehouseId, Storehouse storehouse) {
        Optional<Storehouse> storehouseToUpdate = storehouseRepository.findById(storehouseId);

        if(storehouseToUpdate.isPresent()) {
            Storehouse foundStorehouse = storehouseToUpdate.get();
            foundStorehouse.setAddress(storehouse.getAddress());
            foundStorehouse.setName(storehouse.getName());
            foundStorehouse.setStorageCapacity(storehouse.getStorageCapacity());
            return storehouseRepository.save(foundStorehouse);
        } else
            throw new StorehouseNotFoundException("The storehouse with id: '" + storehouseId + "' not found");
    }

    @Override
    public void deleteStorehouse(Long storehouseId) {
        storehouseRepository.deleteById(storehouseId);
    }
}
