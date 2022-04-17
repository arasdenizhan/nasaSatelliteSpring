package org.example.demo.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.service.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class NasaApiClient {
    @Value("${api.nasa.url}")
    private String apiUrl;

    private final SatelliteService satelliteService;

    private final RestTemplate restTemplate;
    private final Gson gson;
    private final JsonParser jsonParser;
    private String apiData;

    @Autowired
    public NasaApiClient(SatelliteService satelliteService, RestTemplate restTemplate, Gson gson, JsonParser jsonParser) {
        this.satelliteService = satelliteService;
        this.restTemplate = restTemplate;
        this.gson = gson;
        this.jsonParser = jsonParser;
    }

    @Autowired


    public String getApiData() {
        return apiData;
    }

    @Scheduled(fixedDelay = 10000)
    private void updateApiData(){
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
        if(response.getStatusCode().equals(HttpStatus.OK)){
            JsonObject responseJson = gson.fromJson(response.getBody(), JsonObject.class);
            apiData = gson.toJson(jsonParser.parse(responseJson.get("member").toString()));
            satelliteService.updateApiData(responseJson.get("member").getAsJsonArray());
            log.info("API Data Updated.");
        }
    }
}
