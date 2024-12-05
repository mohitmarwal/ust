/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.session;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class SessionsRepository {

    public List<Map<String, Object>> findByMachineId(String machineId) {
        // Mocked session data
 return List.of(
            Map.of(
                "id", "1",
                "machine_id", machineId,
                "created_at", "2024-12-01T11:00:00Z",
                "data", Map.of("metrics", Map.of("temperature", 75, "vibration", 0.02))
            ),
            Map.of(
                "id", "2",
                "machine_id", machineId,
                "created_at", "2024-12-01T12:00:00Z",
                "data", Map.of("metrics", Map.of("temperature", 78, "vibration", 0.03))
            ),
            Map.of(
                "id", "3",
                "machine_id", machineId,
                "created_at", "2024-12-01T13:00:00Z",
                "data", Map.of("metrics", Map.of("temperature", 80, "vibration", 0.04))
            ),
            Map.of(
                "id", "4",
                "machine_id", machineId,
                "created_at", "2024-12-01T14:00:00Z",
                "data", Map.of("metrics", Map.of("temperature", 77, "vibration", 0.01))
            )
        );
    }
}