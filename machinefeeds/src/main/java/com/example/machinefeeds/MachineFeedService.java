/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.machinefeeds;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MachineFeedService {

    @Autowired
    private RestTemplate restTemplate;

    public Map<String, Object> getMachineFeeds(String machineId) {
        // Fetch data from services
        String machineServiceUrl = "http://localhost:8081/machines/" + machineId;
        String repairsServiceUrl = "http://localhost:8082/repairs/" + machineId;
        String sessionsServiceUrl = "http://localhost:8083/sessions/" + machineId;

        Map<String, Object> machine = restTemplate.getForObject(machineServiceUrl, Map.class);
        List<Map<String, Object>> repairs = restTemplate.getForObject(repairsServiceUrl, List.class);
        List<Map<String, Object>> sessions = restTemplate.getForObject(sessionsServiceUrl, List.class);

        // Combine data
        List<Map<String, Object>> feeds = new ArrayList<>();
        if (repairs != null) {
            repairs.forEach(r -> feeds.add(Map.of("type", "repair", "timestamp", r.get("created_at"), "data", r.get("data"))));
        }
        if (sessions != null) {
            sessions.forEach(s -> feeds.add(Map.of("type", "session", "timestamp", s.get("created_at"), "data", s.get("data"))));
        }

        return Map.of("machine", machine, "feeds", feeds);
    }
}