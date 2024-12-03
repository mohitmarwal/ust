/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.repair;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepairsService {

    @Autowired
    private RepairsRepository repairsRepository;

    public List<Map<String, Object>> getRepairsByMachineId(String machineId) {
        return repairsRepository.findByMachineId(machineId);
    }
}