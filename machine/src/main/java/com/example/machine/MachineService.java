/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.machine;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public Map<String, Object> getMachineById(String machineId) {
        return machineRepository.findById(machineId);
    }
}