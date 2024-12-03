/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.repair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repairs")
public class RepairsController {

    @Autowired
    private RepairsService repairsService;

    @GetMapping("/{machineId}")
    public ResponseEntity<?> getRepairs(@PathVariable String machineId) {
        return ResponseEntity.ok(repairsService.getRepairsByMachineId(machineId));
    }
}