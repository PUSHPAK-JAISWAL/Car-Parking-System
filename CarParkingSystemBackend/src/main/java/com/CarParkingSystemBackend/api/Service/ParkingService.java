package com.CarParkingSystemBackend.api.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.CarParkingSystemBackend.api.Entity.ParkingSlot;

@Service
public class ParkingService {

    private final RestTemplate restTemplate;

    public ParkingService() {
        this.restTemplate = new RestTemplate();
    }

    private static final String NODEMCU_API_URL = "https://blr1.blynk.cloud/external/api/get?token=3bgeF2MkmryyR6kj07RrfbuahDM0DNPg&v1";

    public List<ParkingSlot> getParkingSlotsStatus() {
        ResponseEntity<String> response = restTemplate.getForEntity(NODEMCU_API_URL, String.class);
        String body = response.getBody();

        return parseSlots(body);
    }

    private List<ParkingSlot> parseSlots(String response) {
        List<ParkingSlot> slots = new ArrayList<>();

        if (response == null || response.isEmpty()) {
            return slots;
        }

        String[] lines = response.split("\\r?\\n"); // Handles both \n and \r\n
        for (String line : lines) {
            String[] parts = line.split(":");
            if (parts.length == 2) {
                String slotName = parts[0].trim();
                String status = parts[1].trim();
                boolean isEmpty = status.equalsIgnoreCase("Empty");
                slots.add(new ParkingSlot(slotName, isEmpty)); // Ensure this constructor exists
            }
        }

        return slots;
    }
}
