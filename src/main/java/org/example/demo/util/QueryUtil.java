package org.example.demo.util;

import com.google.gson.JsonObject;
import org.example.demo.constant.DatabaseConstants;
import org.example.demo.dto.SatelliteDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryUtil {

    private QueryUtil(){
        throw new UnsupportedOperationException("You can not create an object of QueryUtil class.");
    }

    public static void prepareInsertQuery(PreparedStatement preparedStatement, JsonObject jsonObject) throws SQLException {
        preparedStatement.setString(1, JsonUtil.getJsonFieldValue(jsonObject, DatabaseConstants.SATELLITE_ID));
        preparedStatement.setString(2, JsonUtil.getJsonFieldValue(jsonObject, DatabaseConstants.NAME));
        preparedStatement.setString(3, JsonUtil.getJsonFieldValue(jsonObject, DatabaseConstants.DATE));
        preparedStatement.setString(4, JsonUtil.getJsonFieldValue(jsonObject, DatabaseConstants.LINE1));
        preparedStatement.setString(5, JsonUtil.getJsonFieldValue(jsonObject, DatabaseConstants.LINE2));
    }

    public static void prepareSelectQuery (PreparedStatement preparedStatement, int number) throws SQLException {
        preparedStatement.setInt(1, number);
    }

    public static void prepareDeleteQuery (PreparedStatement preparedStatement, String name) throws SQLException {
        preparedStatement.setString(1, name);
    }

    public static SatelliteDto convertQueryResult(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(1);
        String satelliteId = resultSet.getString(2);
        String name = resultSet.getString(3);
        String date = resultSet.getString(4);
        String line1 = resultSet.getString(5);
        String line2 = resultSet.getString(6);
        return SatelliteDto.builder()
                .id(id)
                .satelliteId(satelliteId)
                .name(name)
                .date(date)
                .line1(line1)
                .line2(line2).build();
    }
}
