/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.repair;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class RepairsRepository {

public List<Map<String, Object>> findByMachineId(String machineId) {
    // Mocked repair data
    return List.of(
        Map.of(
            "id", "1",
            "machine_id", machineId,
            "created_at", "2024-12-01T10:00:00Z",
            "data", Map.of("description", "Replaced broken seal", "image_url", "https://example.com/image1.jpg")
        ),
        Map.of(
            "id", "2",
            "machine_id", machineId,
            "created_at", "2024-12-01T11:30:00Z",
            "data", Map.of("description", "Tightened loose bolts", "image_url", "https://example.com/image2.jpg")
        ),
        Map.of(
            "id", "3",
            "machine_id", machineId,
            "created_at", "2024-12-01T12:45:00Z",
            "data", Map.of("description", "Replaced worn-out belt", "image_url", "https://example.com/image3.jpg")
        ),
        Map.of(
            "id", "4",
            "machine_id", machineId,
            "created_at", "2024-12-01T14:15:00Z",
            "data", Map.of("description", "Lubricated moving parts", "image_url", "https://example.com/image4.jpg")
        )
    );
}
}