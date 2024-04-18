package com.devtech.StorehouseTrackingApp.services.abstracts;

import com.devtech.StorehouseTrackingApp.entities.Storehouse;
import com.devtech.StorehouseTrackingApp.requests.StorehouseCreateRequest;
import com.devtech.StorehouseTrackingApp.responses.StorehouseResponse;

import java.util.List;

public interface StorehouseService {

    List<StorehouseResponse> getAllStorehouses();
    Storehouse getOneStorehouseById(Long storehouseId);
    Storehouse getOneStorehouseByAddress(String storehouseAddress);
    Storehouse createOneStorehouse(StorehouseCreateRequest newStorehouse);
    Storehouse updateOneStorehouse(Long storehouseId, Storehouse storehouse);
    void deleteStorehouse(Long storehouseId);
}
