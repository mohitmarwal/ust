/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.machinefeeds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/machine-feeds")
public class MachineFeedController {

    @Autowired
    private MachineFeedService machineFeedService;

    /**
     *
     * @param machineId
     * @return
     */
    @GetMapping("/{machineId}")
    public ResponseEntity<?> getMachineFeeds(@PathVariable String machineId) {
        return ResponseEntity.ok(machineFeedService.getMachineFeeds(machineId));
    }
}