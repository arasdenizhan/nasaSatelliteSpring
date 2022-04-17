package org.example.demo.controller;

import org.example.demo.client.NasaApiClient;
import org.example.demo.service.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> getApiData(){
        return ResponseEntity.ok(nasaApiClient.getApiData());
    }
}
