/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessions")
public class SessionsController {

    @Autowired
    private SessionsService sessionsService;

    @GetMapping("/{machineId}")
    public ResponseEntity<?> getSessions(@PathVariable String machineId) {
        return ResponseEntity.ok(sessionsService.getSessionsByMachineId(machineId));
    }
}