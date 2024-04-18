package com.devtech.StorehouseTrackingApp.controllers;

import com.devtech.StorehouseTrackingApp.entities.Storehouse;
import com.devtech.StorehouseTrackingApp.requests.StorehouseCreateRequest;
import com.devtech.StorehouseTrackingApp.responses.StorehouseResponse;
import com.devtech.StorehouseTrackingApp.services.abstracts.StorehouseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storehouses")
@AllArgsConstructor
@CrossOrigin("*")
public class StorehouseController {

    private StorehouseService storehouseService;

    @GetMapping
    public List<StorehouseResponse> receiveAllStorehouses() {
        return storehouseService.getAllStorehouses();
    }

    @PostMapping
    public Storehouse createOneStorehouse(@RequestBody StorehouseCreateRequest newStorehouse) {
        return storehouseService.createOneStorehouse(newStorehouse);
    }

    @GetMapping("/{storehouseId}")
    public Storehouse receiveOneStorehouseById(@PathVariable Long storehouseId) {
        return storehouseService.getOneStorehouseById(storehouseId);
    }

    @PutMapping("/{storehouseId}")
    public Storehouse updateOneStorehouse(@PathVariable Long storehouseId, @RequestBody Storehouse newStorehouse) {
        return storehouseService.updateOneStorehouse(storehouseId, newStorehouse);
    }

    @DeleteMapping("/{storehouseId}")
    public void deleteOneStorehouse(@PathVariable Long storehouseId) {
        storehouseService.deleteStorehouse(storehouseId);
    }
}
