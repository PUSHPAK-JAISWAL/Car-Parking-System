package com.CarParkingSystemBackend.api.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CarParkingSystemBackend.api.Entity.ParkingSlot;
import com.CarParkingSystemBackend.api.Service.ParkingService;

@RestController
@RequestMapping("/api/parking")
@CrossOrigin(origins = "*") // Allow all origins. For production, specify allowed origins.
public class ParkingController {

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping("/slots")
    public ResponseEntity<List<ParkingSlot>> getParkingSlots() {
        List<ParkingSlot> slots = parkingService.getParkingSlotsStatus();
        return ResponseEntity.ok(slots);
    }
}
