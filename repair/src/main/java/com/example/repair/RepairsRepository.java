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
                "data", Map.of("description", "Replaced broken seal", "image_url", "https://example.com/image.jpg")
            )
        );
    }
}