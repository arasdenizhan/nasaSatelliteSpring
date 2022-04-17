package org.example.demo.repository;

import com.google.gson.JsonArray;

public interface SatelliteRepository {
    String getApiData (int number);
    String deleteApiDataByName (String name);
    void updateApiData (JsonArray data);
}
