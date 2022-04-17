package org.example.demo.service;

import com.google.gson.JsonArray;

public interface SatelliteService {
    String getApiData (int number);
    String deleteApiDataByName (String name);
    void updateApiData (JsonArray data);
}
