package org.example.demo.service.impl;

import com.google.gson.JsonArray;
import org.example.demo.repository.SatelliteRepository;
import org.example.demo.service.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SatelliteServiceImpl implements SatelliteService {
    private final SatelliteRepository satelliteRepository;

    @Autowired
    public SatelliteServiceImpl(SatelliteRepository satelliteRepository) {
        this.satelliteRepository = satelliteRepository;
    }

    @Override
    public String getApiData(int number) {
        return satelliteRepository.getApiData(number);
    }

    @Override
    public String deleteApiDataByName(String name) {
        return satelliteRepository.deleteApiDataByName(name);
    }

    @Override
    public void updateApiData(JsonArray data) {
        if(data.size()>0){
            satelliteRepository.updateApiData(data);
        }
    }
}
