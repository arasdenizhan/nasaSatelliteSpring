package org.example.demo;

import org.assertj.core.api.Assertions;
import org.example.demo.service.SatelliteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SatelliteServiceTest {
    @Autowired
    SatelliteService satelliteService;

    @Test
    void givenNumber_whenGetApiData_thenReturnApiData(){
        int number = -5;
        Assertions.assertThat(satelliteService.getApiData(number)).isNull();
        number = 0;
        Assertions.assertThat(satelliteService.getApiData(number)).isNull();
        number = 3;
        Assertions.assertThat(satelliteService.getApiData(number)).isNotNull();
    }

    @Test
    void givenName_whenDeleteApiData_thenReturnDeletedDataName(){
        String name = "";
        Assertions.assertThat(satelliteService.deleteApiDataByName(name)).isNull();
        name = "ISS (ZARYA)";
        Assertions.assertThat(satelliteService.deleteApiDataByName(name)).isNotNull();
    }
}
