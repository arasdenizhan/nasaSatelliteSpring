package org.example.demo.repository.impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.example.demo.constant.DatabaseConstants;
import org.example.demo.exception.DataUpdateFailedException;
import org.example.demo.repository.SatelliteRepository;
import org.example.demo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class SatelliteRepositoryImpl implements SatelliteRepository {

    private final Connection connection;
    private PreparedStatement preparedStatement;

    @Autowired
    public SatelliteRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String getApiData(int number) {
        return null;
    }

    @Override
    public String deleteApiDataByName(String name) {
        return null;
    }

    @Override
    public void updateApiData(JsonArray data) {
        try {
            preparedStatement = connection.prepareStatement(DatabaseConstants.INSERT_QUERY);
            data.forEach(jsonElement -> {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                try {
                    preparedStatement.setString(1, JsonUtil.getJsonFieldValue(jsonObject, DatabaseConstants.SATELLITE_ID));
                    preparedStatement.setString(2, JsonUtil.getJsonFieldValue(jsonObject, DatabaseConstants.NAME));
                    preparedStatement.setString(3, JsonUtil.getJsonFieldValue(jsonObject, DatabaseConstants.DATE));
                    preparedStatement.setString(4, JsonUtil.getJsonFieldValue(jsonObject, DatabaseConstants.LINE1));
                    preparedStatement.setString(5, JsonUtil.getJsonFieldValue(jsonObject, DatabaseConstants.LINE2));
                    if(preparedStatement.executeUpdate()!=1){
                        throw new DataUpdateFailedException("Execution of query failed.");
                    }
                } catch (SQLException e) {
                    throw new DataUpdateFailedException("Data Update Failed.", e);
                }
            });
        } catch (SQLException e) {
            throw new DataUpdateFailedException("PreparedStatement preparation failed.", e);
        }
    }
}
