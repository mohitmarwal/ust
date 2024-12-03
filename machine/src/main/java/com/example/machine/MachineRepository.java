/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.machine;

import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class MachineRepository {

    public Map<String, Object> findById(String machineId) {
        // Mocked machine data
        return Map.of(
            "id", machineId,
            "created_at", "2024-12-01T09:00:00Z",
            "data", Map.of("name", "Compressor 1")
        );
    }
}
