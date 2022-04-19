package org.example.demo.controller;

import org.apache.logging.log4j.util.Strings;
import org.example.demo.service.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/satellite")
public class SatelliteController {
    private final SatelliteService satelliteService;

    @Autowired
    public SatelliteController(SatelliteService satelliteService) {
        this.satelliteService = satelliteService;
    }

    @GetMapping
    public ResponseEntity<String> getApiData(@RequestParam("number") int number){
        String apiData = satelliteService.getApiData(number);
        return Strings.isNotEmpty(apiData) ? ResponseEntity.ok(apiData) : ResponseEntity.badRequest().body("Number should be greeter than 0.");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteApiDataByName (@RequestParam("name") String name){
        String deleteApiDataByName = satelliteService.deleteApiDataByName(name);
        return Strings.isNotEmpty(deleteApiDataByName) ? ResponseEntity.ok(deleteApiDataByName) : ResponseEntity.badRequest().body("No records were deleted.");
    }
}
