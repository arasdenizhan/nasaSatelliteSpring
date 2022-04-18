package org.example.demo.controller;

import org.example.demo.client.NasaApiClient;
import org.example.demo.service.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/satellite")
public class SatelliteController {
    private final NasaApiClient nasaApiClient;
    private final SatelliteService satelliteService;

    @Autowired
    public SatelliteController(NasaApiClient nasaApiClient, SatelliteService satelliteService) {
        this.nasaApiClient = nasaApiClient;
        this.satelliteService = satelliteService;
    }

    @GetMapping
    public ResponseEntity<String> getApiData(@RequestParam("number") int number){
        return ResponseEntity.ok(satelliteService.getApiData(number));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteApiDataByName (@RequestParam("name") String name){
        return ResponseEntity.ok(satelliteService.deleteApiDataByName(name));
    }
}
