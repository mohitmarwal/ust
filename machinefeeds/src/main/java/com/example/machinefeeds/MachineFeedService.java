/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.machinefeeds;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MachineFeedService {
    @Value("${service.machine.url}")
    private String machineServiceUrl;

    @Value("${service.repair.url}")
    private String repairsServiceUrl;

    @Value("${service.session.url}")
    private String sessionsServiceUrl;
    
    @Autowired
    private RestTemplate restTemplate;

    public Map<String, Object> getMachineFeeds(String machineId) {
        
       // Fetch data from services
        String machineUrl = machineServiceUrl + machineId;
        String repairsUrl = repairsServiceUrl + machineId  ;
        String sessionsUrl = sessionsServiceUrl + machineId ;

        Map<String, Object> machine = restTemplate.getForObject(machineUrl, Map.class);
        List<Map<String, Object>> repairs = restTemplate.getForObject(repairsUrl, List.class);
        List<Map<String, Object>> sessions = restTemplate.getForObject(sessionsUrl, List.class);

    // Combine and sort by `created_at`
    List<Map<String, Object>> combinedFeeds = new ArrayList<>();
    combinedFeeds.addAll(repairs);
    combinedFeeds.addAll(sessions);
    combinedFeeds.sort(Comparator.comparing(feed -> (String) feed.get("created_at")));

    // Combine into a single response
    Map<String, Object> response = new HashMap<>();
    response.put("machineDetails", machine);
    response.put("combinedFeeds", combinedFeeds);

    return response;
    }
}