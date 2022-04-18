package org.example.demo.repository.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.example.demo.constant.DatabaseConstants;
import org.example.demo.dto.SatelliteDto;
import org.example.demo.exception.DataUpdateFailedException;
import org.example.demo.repository.SatelliteRepository;
import org.example.demo.util.JsonUtil;
import org.example.demo.util.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SatelliteRepositoryImpl implements SatelliteRepository {

    private final Connection connection;
    private final Gson gson;
    private PreparedStatement preparedStatement;

    @Autowired
    public SatelliteRepositoryImpl(Connection connection, Gson gson) {
        this.connection = connection;
        this.gson = gson;
    }

    @Override
    public String getApiData(int number) {
        try {
            List<SatelliteDto> resultObjects = new ArrayList<>();
            preparedStatement = connection.prepareStatement(DatabaseConstants.GET_QUERY);
            QueryUtil.prepareSelectQuery(preparedStatement, number);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.wasNull()){
                throw new DataUpdateFailedException(DatabaseConstants.EXECUTION_FAILED);
            }
            while(resultSet.next()){
                resultObjects.add(QueryUtil.convertQueryResult(resultSet));
            }
            resultSet.close();
            return gson.toJson(resultObjects);
        } catch (SQLException e) {
            throw new DataUpdateFailedException(DatabaseConstants.PREPARATION_FAILED, e);
        }
    }

    @Override
    public String deleteApiDataByName(String name) {
        try {
            preparedStatement = connection.prepareStatement(DatabaseConstants.DELETE_QUERY);
            QueryUtil.prepareDeleteQuery(preparedStatement,name);
            if(preparedStatement.executeUpdate()!=2){
                throw new DataUpdateFailedException(DatabaseConstants.EXECUTION_FAILED);
            }
            return "Records with: " + name + " were deleted";
        } catch (SQLException e) {
            throw new DataUpdateFailedException(DatabaseConstants.PREPARATION_FAILED, e);
        }
    }

    @Override
    public void updateApiData(JsonArray data) {
        try {
            preparedStatement = connection.prepareStatement(DatabaseConstants.INSERT_QUERY);
            data.forEach(jsonElement -> {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                try {
                    QueryUtil.prepareInsertQuery(preparedStatement, jsonObject);
                    if(preparedStatement.executeUpdate()!=1){
                        throw new DataUpdateFailedException(DatabaseConstants.EXECUTION_FAILED);
                    }
                } catch (SQLException e) {
                    throw new DataUpdateFailedException(DatabaseConstants.UPDATE_FAILED, e);
                }
            });
        } catch (SQLException e) {
            throw new DataUpdateFailedException(DatabaseConstants.PREPARATION_FAILED, e);
        }
    }
}
